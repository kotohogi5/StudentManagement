package raisetech.student.manegement;

import java.sql.Timestamp;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Course {
  private String id;
  private String studentInfoId;
  private String courseName;
  private Timestamp courseStartDate;
  private Timestamp courseEndDate;

}
