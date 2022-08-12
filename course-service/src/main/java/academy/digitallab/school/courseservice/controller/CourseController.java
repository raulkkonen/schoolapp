package academy.digitallab.school.courseservice.controller;

import academy.digitallab.school.courseservice.entity.Course;
import academy.digitallab.school.courseservice.service.CourseService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/courses")
public class CourseController {

    @Autowired
    private CourseService courseService ;

    @GetMapping
    public ResponseEntity<List<Course>> listCourse(){
        List<Course> courses = new ArrayList<>();

        courses = courseService.listAllCourse();
        if (courses.isEmpty()){
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(courses);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Course> getCourse(@PathVariable("id") Long id) {
        Course course =  courseService.getCourse(id);
        if (null==course){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(course);
    }

    @PostMapping
    public ResponseEntity<Course> createCourse(@Valid @RequestBody Course course, BindingResult result){
        if (result.hasErrors()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, this.formatMessage(result));
        }
        Course courseCreate =  courseService.createCourse(course);
        return ResponseEntity.status(HttpStatus.CREATED).body(courseCreate);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Course> updateCourse(@PathVariable("id") Long id, @RequestBody Course course){
        course.setId(id);
        Course courseDB =  courseService.updateCourse(course);
        if (courseDB == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(courseDB);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Course> deleteCourse(@PathVariable("id") Long id){
        Course courseDelete = courseService.deleteCourse(id);
        if (courseDelete == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(courseDelete);
    }

    private String formatMessage( BindingResult result){
        List<Map<String,String>> errors = result.getFieldErrors().stream()
                .map(err ->{
                    Map<String,String>  error =  new HashMap<>();
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
