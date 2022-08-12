package academy.digitallab.school.courseservice.repository;

import academy.digitallab.school.courseservice.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course,Long> {
}
