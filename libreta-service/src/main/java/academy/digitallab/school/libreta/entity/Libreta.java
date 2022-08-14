package academy.digitallab.school.libreta.entity;

import academy.digitallab.school.libreta.model.Course;
import academy.digitallab.school.libreta.model.Student;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tbl_libretas")
@Data
public class Libreta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "La descripción no debe estar vacío")
    private String descripcion;

    @Column(name = "nota_final")
    private Long notaFinal;

    @Column(name = "student_id")
    private Long studentId;

    @Column(name = "course_id")
    private Long courseId;

    @Column(name = "created_user")
    private String createdUser;

    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Column(name = "row_version")
    private Long rowVersion;

    private String status;

    @Valid
    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "libreta_id")
    private List<LibretaNota> notas;

    @Transient
    private Student studend;

    @Transient
    private Course course;
}
