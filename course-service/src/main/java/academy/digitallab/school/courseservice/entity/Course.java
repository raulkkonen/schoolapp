package academy.digitallab.school.courseservice.entity;

import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import java.util.Date;

@Entity
@Data
@Table(name = "tbl_courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "created_user")
    private String createdUser;

    @Column(name = "created_date")
    private Date createdDate;

    @Column(name = "row_version")
    private Long rowVersion;

    @Column(name = "end_date")
    private Date endDate;

    @Positive(message = "Las horas deben ser mayor que cero")
    private Long hours;

    @NotEmpty(message = "El nombre no puede ser vacío")
    private String name;
    private Double price;

    @Column(name = "start_date")
    private Date startDate;
    private String status;
    private String url;
}
