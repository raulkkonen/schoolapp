package academy.digitallab.school.libreta.entity;

import lombok.Data;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tbl_libreta_notas")
@Data
public class LibretaNota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "libreta_id")
    private Long libretaId;
    private String bimestre;
    private Long nota;
    private String observacion;

    @Column(name = "created_user")
    private String createdUser;

    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Column(name = "row_version")
    private Long rowVersion;

    private String status;
}
