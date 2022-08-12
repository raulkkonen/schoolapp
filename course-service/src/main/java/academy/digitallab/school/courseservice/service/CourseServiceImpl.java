package academy.digitallab.school.courseservice.service;

import academy.digitallab.school.courseservice.entity.Course;
import academy.digitallab.school.courseservice.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService{
    private final CourseRepository courseRepository;

    @Override
    public List<Course> listAllCourse() {
        return courseRepository.findAll();
    }

    @Override
    public Course getCourse(Long id) {
        return courseRepository.findById(id).orElse(null);
    }

    @Override
    public Course createCourse(Course course) {
        course.setCreatedUser("REGISTRADOR_01");
        course.setCreatedDate(new Date());
        course.setStatus("CREATED");

        return courseRepository.save(course);
    }

    @Override
    public Course updateCourse(Course course) {
        Course courseDB = getCourse(course.getId());
        if (null == courseDB){
            return null;
        }
        courseDB.setRowVersion(course.getRowVersion());
        courseDB.setEndDate(course.getEndDate());
        courseDB.setHours(course.getHours());
        courseDB.setName(course.getName());
        courseDB.setPrice(course.getPrice());
        courseDB.setStartDate(course.getStartDate());
        courseDB.setUrl(course.getUrl());

        return courseRepository.save(courseDB);
    }

    @Override
    public Course deleteCourse(Long id) {
        Course courseDB = getCourse(id);
        if (null == courseDB){
            return null;
        }
        courseDB.setStatus("DELETED");
        return courseRepository.save(courseDB);
    }
}
