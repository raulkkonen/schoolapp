package academy.digitallab.school.libreta.model;

import lombok.Data;
import java.util.Date;

@Data
public class Course {

    private Long id;
    private String createdUser;
    private Date createdDate;
    private Long rowVersion;
    private Date endDate;
    private Long hours;
    private String name;
    private Double price;
    private Date startDate;
    private String status;
    private String url;

}
