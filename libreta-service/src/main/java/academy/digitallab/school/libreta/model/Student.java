package academy.digitallab.school.libreta.model;

import lombok.Data;
import java.util.Date;

@Data
public class Student {

    private Long id;
    private String createdUser;
    private Date createdDate;
    private Long rowVersion;
    private String fullname;
    private String status;
    private String userName;
}
