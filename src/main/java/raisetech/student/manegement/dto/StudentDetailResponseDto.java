package raisetech.student.manegement.dto;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import raisetech.student.manegement.entity.Course;
import raisetech.student.manegement.entity.Student;

/**
 * 生徒情報＋コース情報「＝生徒詳細情報」をresponseするための、出力用DTOクラス
 */


@Getter
@Setter
public class StudentDetailResponseDto {

  private Student student;
  private List<Course> courses;

}
