package raisetech.student.manegement.domain;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import raisetech.student.manegement.data.Course;
import raisetech.student.manegement.data.Student;

/**
 * 生徒情報＋コース情報「＝生徒詳細情報」をまとめて画面やAPIに返すためのDTOクラス
 * 概要：出力用・詳細情報用DTO
 * 用途：生徒情報とコース情報を紐づけて利用したい場合
 */


@Getter
@Setter
public class StudentDetail {

  private Student student;
  private List<Course> courses;

}
