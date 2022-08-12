package academy.digitallab.school.student.service;

import academy.digitallab.school.student.entity.Student;
import academy.digitallab.school.student.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService{

    private final StudentRepository studentRepository;

    @Override
    public List<Student> listAllStudent() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudent(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public Student createStudent(Student student) {
        student.setCreatedUser("REGISTRADOR_01");
        student.setCreatedDate(new Date());
        student.setStatus("CREATED");

        return studentRepository.save(student);
    }

    @Override
    public Student updateStudent(Student student) {
        Student studentDB = getStudent(student.getId());
        if (null == studentDB){
            return null;
        }
        studentDB.setRowVersion(student.getRowVersion());
        studentDB.setFullname(student.getFullname());
        studentDB.setUserName(student.getUserName());
        return studentRepository.save(studentDB);
    }

    @Override
    public Student deleteStudent(Long id) {
        Student studentDB = getStudent(id);
        if (null == studentDB){
            return null;
        }
        studentDB.setStatus("DELETED");
        return studentRepository.save(studentDB);
    }

}
