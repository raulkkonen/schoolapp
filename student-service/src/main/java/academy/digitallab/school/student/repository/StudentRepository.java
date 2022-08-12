package academy.digitallab.school.student.repository;

import academy.digitallab.school.student.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
