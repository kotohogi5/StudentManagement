package raisetech.student.manegement.data;

import java.sql.Timestamp;
import lombok.Getter;
import lombok.Setter;

/**
 * 生徒が受講中のコース情報を保持するエンティティクラス
 */

@Getter
@Setter
public class Course {

  private String id;
  private String studentInfoId;
  private String courseName;
  private Timestamp courseStartDate;
  private Timestamp courseEndDate;

}
