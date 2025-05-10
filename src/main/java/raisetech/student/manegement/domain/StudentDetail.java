package raisetech.student.manegement.domain;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import raisetech.student.manegement.data.Course;
import raisetech.student.manegement.data.Student;

/**
 * 生徒情報＋コース情報「＝生徒詳細情報」をまとめて画面やAPIに返すための、出力用・詳細情報用DTOクラス
 */


@Getter
@Setter
public class StudentDetail {

  private Student student;
  private List<Course> courses;

}
