package academy.digitallab.school.libreta.service;

import academy.digitallab.school.libreta.client.CourseClient;
import academy.digitallab.school.libreta.client.StudentClient;
import academy.digitallab.school.libreta.entity.Libreta;
import academy.digitallab.school.libreta.model.Course;
import academy.digitallab.school.libreta.model.Student;
import academy.digitallab.school.libreta.repository.LibretaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;

@Slf4j
@Service
public class LibretaServiseImpl implements LibretaService{
    @Autowired
    LibretaRepository libretaRepository;

    @Autowired
    StudentClient studentClient;

    @Autowired
    CourseClient courseClient;

    @Override
    public List<Libreta> findLibretaAll() {
        return  libretaRepository.findAll();
    }

    @Override
    public Libreta createLibreta(Libreta libreta) {
        Libreta libretaDB = getLibreta(libreta.getId());
        if (libretaDB !=null){
            return  libretaDB;
        }
        libreta.setCreatedUser("REGISTRADOR_01");
        libreta.setCreatedDate(new Date());
        libreta.setStatus("CREATED");

        return libretaRepository.save(libreta);
    }


    @Override
    public Libreta updateLibreta(Libreta libreta) {
        Libreta libretaDB = getLibreta(libreta.getId());
        if (libretaDB == null){
            return  null;
        }
        libretaDB.setRowVersion(libreta.getRowVersion());
        libretaDB.setDescripcion(libreta.getDescripcion());
        libretaDB.setNotaFinal(libreta.getNotaFinal());
        libretaDB.setCourseId(libreta.getCourseId());
        libretaDB.setStudentId(libreta.getStudentId());
        return libretaRepository.save(libretaDB);
    }


    @Override
    public Libreta deleteLibreta(Libreta libreta) {
        Libreta libretaDB = getLibreta(libreta.getId());
        if (libretaDB == null){
            return  null;
        }
        libretaDB.setStatus("DELETED");
        return libretaRepository.save(libretaDB);
    }

    @Override
    public Libreta getLibreta(Long id) {
        Libreta libreta = libretaRepository.findById(id).orElse(null);

        Student student = studentClient.getStudent(libreta.getStudentId()).getBody();
        Course course = courseClient.getCourse(libreta.getCourseId()).getBody();

        libreta.setStudend(student);
        libreta.setCourse(course);

        return libreta;
    }
}
