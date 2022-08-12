package academy.digitallab.school.courseservice.service;

import academy.digitallab.school.courseservice.entity.Course;
import java.util.List;

public interface CourseService {
    public List<Course> listAllCourse();
    public Course getCourse(Long id);
    public Course createCourse(Course course);
    public Course updateCourse(Course course);
    public  Course deleteCourse(Long id);
}
