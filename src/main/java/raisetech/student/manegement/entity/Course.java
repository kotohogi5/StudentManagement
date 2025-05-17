package raisetech.student.manegement.entity;

import java.time.LocalDate;
import lombok.Getter;
import lombok.AllArgsConstructor;

/**
 * 生徒が受講中のコース情報を保持するエンティティクラス
 */
@Getter
@AllArgsConstructor
public class Course {

  private int id;
  private int studentId;
  private String courseName;
  private LocalDate courseStartDate;
  private LocalDate courseEndDate;

  /**
   * 出力用コンストラクタ（全フィールド）
   *
   * @AllArgsConstructorで自動生成
   **/


  /**
   * 登録用コンストラクタ
   *
   * @param courseName      　登録コース名
   * @param courseStartDate 　受講開始日
   */
  public Course(String courseName, LocalDate courseStartDate) {
    this(0, 0, courseName, courseStartDate, null);

  }

}
