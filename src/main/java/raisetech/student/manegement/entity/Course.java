package raisetech.student.manegement.entity;

import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

/**
 * 生徒が受講中のコース情報を保持するエンティティクラス
 */
@Getter
@Setter
public class Course {

  private int id;
  private int studentId;
  private String courseName;
  private LocalDate courseStartDate;
  private LocalDate courseEndDate;

}
