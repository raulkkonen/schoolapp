package academy.digitallab.school.student.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Entity
@Table(name = "tbl_students")
@Data
@AllArgsConstructor @NoArgsConstructor @Builder
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "created_user")
    private String createdUser;

    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Column(name = "row_version")
    private Long rowVersion;

    @NotEmpty(message = "El nombre no debe ser vacío")
    private String fullname;
    private String status;

    @Column(name = "user_name")
    @NotEmpty(message = "El nombre de usuario no debe ser vacío")
    private String userName;
}
