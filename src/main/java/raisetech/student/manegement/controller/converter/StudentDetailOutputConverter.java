package raisetech.student.manegement.controller.converter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;
import raisetech.student.manegement.entity.Course;
import raisetech.student.manegement.entity.Student;
import raisetech.student.manegement.dto.StudentDetailResponseDto;

/**
 * 後処理用のResponse系コンバータークラス
 */
@Component
public class StudentDetailOutputConverter {

  /**
   * フィルタリング済み生徒情報を起点にしたデータ結合を行う、コンバータークラスメソッド
   *
   * @param students 処理対象の生徒リスト
   * @param courses  全コース情報
   * @return コース情報が紐付けられた生徒詳細リスト
   */
  public List<StudentDetailResponseDto> getStudentDetailsByStudent(List<Student> students,
      List<Course> courses) {

    // 生徒IDをキーにして、コース情報をグループ化
    Map<Integer, List<Course>> courseMap = courses.stream()
        .collect(Collectors.groupingBy(Course::getStudentId));

    List<StudentDetailResponseDto> studentDetails = new ArrayList<>();

    for (Student student : students) {
      StudentDetailResponseDto studentDetail = new StudentDetailResponseDto();
      studentDetail.setStudent(student);

      // その生徒が受講しているコース情報を取得
      List<Course> matchedCourses = courseMap.getOrDefault(student.getId(),
          Collections.emptyList());

      studentDetail.setCourses(matchedCourses);
      studentDetails.add(studentDetail);
    }
    return studentDetails;
  }


  /**
   * フィルタリング済みのコース情報を起点にしたデータ結合を行う、コンバータークラスメソッド
   *
   * @param allStudents     全生徒情報
   * @param filteredCourses 絞り込み済みコース情報
   * @return コース情報に紐づく生徒詳細リスト
   */

  public List<StudentDetailResponseDto> getStudentDetailsByCourse(List<Student> allStudents,
      List<Course> filteredCourses) {

    //指定されたコース情報を持つ生徒IDだけを呼び出して、変数にまとめる
    Set<Integer> filteredStudentId = filteredCourses.stream().map(Course::getStudentId)
        .collect(Collectors.toSet());

    //生徒IDをキーにして、コース情報をまとめる
    Map<Integer, List<Course>> courseMap = filteredCourses.stream()
        .collect(Collectors.groupingBy(Course::getStudentId));

    //全生徒情報から「コースに紐づく生徒情報」のみを抽出して変数にまとめる
    List<Student> filteredStudents = allStudents.stream()
        .filter(student -> filteredStudentId.contains(student.getId())).toList();

    //生徒詳細情報を構築
    return filteredStudents.stream().map(student -> {
      StudentDetailResponseDto studentDetail = new StudentDetailResponseDto();
      studentDetail.setStudent(student);
      studentDetail.setCourses(courseMap.getOrDefault(student.getId(), Collections.emptyList()));
      return studentDetail;
    }).collect(Collectors.toList());
  }


}
