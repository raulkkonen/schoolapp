package academy.digitallab.school.libreta.controller;

import academy.digitallab.school.libreta.entity.Libreta;
import academy.digitallab.school.libreta.service.LibretaService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/libretas")
public class LibretaRest {
    @Autowired
    LibretaService libretaService;

    // -------------------Retrieve Single Invoice------------------------------------------
    @GetMapping
    public ResponseEntity<List<Libreta>> listAllInvoices() {
        List<Libreta> libretas = libretaService.findLibretaAll();
        if (libretas.isEmpty()) {
            return  ResponseEntity.noContent().build();
        }
        return  ResponseEntity.ok(libretas);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Libreta> getLibreta(@PathVariable("id") long id) {
        log.info("Fetching Invoice with id {}", id);
        Libreta libreta  = libretaService.getLibreta(id);
        if (null == libreta) {
            log.error("Invoice with id {} not found.", id);
            return  ResponseEntity.notFound().build();
        }
        return  ResponseEntity.ok(libreta);
    }

    // -------------------Create a Invoice-------------------------------------------
    @PostMapping
    public ResponseEntity<Libreta> createLibreta(@Valid @RequestBody Libreta libreta, BindingResult result) {
        log.info("Creating Invoice : {}", libreta);
        if (result.hasErrors()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, this.formatMessage(result));
        }
        Libreta libretaDB = libretaService.createLibreta (libreta);

        return  ResponseEntity.status( HttpStatus.CREATED).body(libretaDB);
    }

    // ------------------- Update a Invoice ------------------------------------------------
    @PutMapping(value = "/{id}")
    public ResponseEntity<?> updateLibreta(@PathVariable("id") long id, @RequestBody Libreta libreta) {
        log.info("Updating Invoice with id {}", id);

        libreta.setId(id);
        Libreta currentLibreta=libretaService.updateLibreta(libreta);

        if (currentLibreta == null) {
            log.error("Unable to update. Invoice with id {} not found.", id);
            return  ResponseEntity.notFound().build();
        }
        return  ResponseEntity.ok(currentLibreta);
    }

    // ------------------- Delete a Invoice-----------------------------------------
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Libreta> deleteLibreta(@PathVariable("id") long id) {
        log.info("Fetching & Deleting Invoice with id {}", id);

        Libreta libreta = libretaService.getLibreta(id);
        if (libreta == null) {
            log.error("Unable to delete. Invoice with id {} not found.", id);
            return  ResponseEntity.notFound().build();
        }
        libreta = libretaService.deleteLibreta(libreta);
        return ResponseEntity.ok(libreta);
    }

    private String formatMessage( BindingResult result){
        List<Map<String,String>> errors = result.getFieldErrors().stream()
                .map(err ->{
                    Map<String,String> error =  new HashMap<>();
                    error.put(err.getField(), err.getDefaultMessage());
                    return error;

                }).collect(Collectors.toList());
        ErrorMessage errorMessage = ErrorMessage.builder()
                .code("01")
                .messages(errors).build();
        ObjectMapper mapper = new ObjectMapper();
        String jsonString="";
        try {
            jsonString = mapper.writeValueAsString(errorMessage);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return jsonString;
    }
}
