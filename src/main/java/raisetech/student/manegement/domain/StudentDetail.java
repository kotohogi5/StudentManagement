package raisetech.student.manegement.domain;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import raisetech.student.manegement.data.Course;
import raisetech.student.manegement.data.Student;

/*
* 生徒情報＋コース情報を保持するクラス
* 概要：生徒情報とその生徒が受講しているコース一覧を管理する
* 用途：生徒情報とコース情報を紐づけて利用したい場合
 */

@Getter
@Setter
public class StudentDetail {

  private Student student;
  private List<Course> courses;

}
