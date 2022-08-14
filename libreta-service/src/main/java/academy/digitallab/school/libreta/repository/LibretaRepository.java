package academy.digitallab.school.libreta.repository;

import academy.digitallab.school.libreta.entity.Libreta;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface LibretaRepository extends JpaRepository<Libreta, Long> {
    //public List<Libreta> findByEstudentId(Long studentId );
    //public List<Libreta> findByCourseId(Long courseId );
}
