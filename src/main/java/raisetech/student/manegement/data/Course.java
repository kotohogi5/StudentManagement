package raisetech.student.manegement.data;

import java.sql.Timestamp;
import lombok.Getter;
import lombok.Setter;

/*
* 生徒が受講中のコース情報を保持するクラス
* 概要：DBに登録された、生徒と紐づく受講コース一覧を保持
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
