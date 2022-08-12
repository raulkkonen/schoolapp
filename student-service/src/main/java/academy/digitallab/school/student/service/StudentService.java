package academy.digitallab.school.student.service;

import academy.digitallab.school.student.entity.Student;
import java.util.List;

public interface StudentService {
    public List<Student> listAllStudent();
    public Student getStudent(Long id);
    public Student createStudent(Student student);
    public Student updateStudent(Student Student);
    public  Student deleteStudent(Long id);
}
