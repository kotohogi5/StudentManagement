package raisetech.student.manegement.service;

import io.micrometer.common.util.StringUtils;
import java.util.Objects;
import dto.StudentsSortDto;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import raisetech.student.manegement.controller.converter.StudentConverter;
import raisetech.student.manegement.data.Course;
import raisetech.student.manegement.data.Student;
import raisetech.student.manegement.domain.StudentDetail;


/**
 * 生徒情報・コース情報を統合し、検索条件に応じて生徒詳細情報を返す統合サービスクラス
 */
@Service
public class StudentDetailService {

  private final StudentService studentService;
  private final CourseService courseService;
  private final StudentConverter converter;

  /**
   * 依存サービスを受け取るコンストラクタ
   *
   * @param service       生徒情報サービス
   * @param courseService コース情報サービス
   * @param converter     生徒詳細情報コンバーター
   */
  @Autowired
  public StudentDetailService(
      StudentService service, CourseService courseService, StudentConverter converter) {
    this.studentService = service;
    this.courseService = courseService;
    this.converter = converter;
  }


  /**
   * 検索条件に応じてフィルタリングされた生徒詳細情報リストを返す、統合サービスメソッド
   *
   * @param sortDto 検索条件
   * @return 生徒詳細情報リスト
   */
  public List<StudentDetail> getStudentsDetails(StudentsSortDto sortDto) {

    //生徒年齢の絞り込みの場合
    if (Objects.nonNull(sortDto.getMinAge()) && Objects.nonNull(sortDto.getMaxAge())) {
      return searchStudentsDetailsByAge(sortDto);
    }
    //コース情報の絞り込みの場合
    if (StringUtils.isNotEmpty(sortDto.getCourseName())) {
      return searchStudentsDetailsByCourse(sortDto);
    }
    //絞り込みの指定がない場合
    return defaultStudentsDetails();
  }


  /**
   * 検索条件なし（全件）の生徒詳細情報リストを返す、統合サービスメソッド
   *
   * @return 検索条件先でコンバートされた全生徒詳細情報リスト
   */
  public List<StudentDetail> defaultStudentsDetails() {

    //生徒情報を格納するリスト
    List<Student> allStudents = studentService.allStudents();

    //コース情報を格納するリスト
    List<Course> allCourses = courseService.allCourses();

    //生徒情報とコース情報のコンバートを返す
    return converter.getStudentDetailsByStudent(allStudents, allCourses);
  }


  /**
   * 年齢条件で絞り込んだ生徒詳細情報リストを返す、統合サービスメソッド
   *
   * @param sortDto 年齢条件
   * @return 条件に合致する生徒詳細情報リスト
   */
  public List<StudentDetail> searchStudentsDetailsByAge(StudentsSortDto sortDto) {

    //条件に応じた生徒情報を格納するリスト
    List<Student> filterStudents = studentService.searchStudentsByAge(sortDto);

    //条件に応じたコース情報を格納するリスト
    List<Course> allCourses = courseService.allCourses();

    //生徒情報とコース情報を統合サービスへ渡し、コンバート処理を依頼
    return converter.getStudentDetailsByStudent(filterStudents, allCourses);
  }


  /**
   * コース名条件で絞り込んだ生徒詳細情報リストを返す、統合サービスメソッド
   *
   * @param sortDto コース名条件
   * @return 条件に合致する生徒詳細情報リスト
   */
  public List<StudentDetail> searchStudentsDetailsByCourse(StudentsSortDto sortDto) {

    //全生徒情報を格納するリスト
    List<Student> allStudents = studentService.allStudents();

    //条件に応じたコース情報を格納するリスト
    List<Course> filterCourses = courseService.searchCourseBySubject(sortDto);

    //生徒情報とコース情報を統合サービスへ渡し、コンバート処理を依頼
    return converter.getStudentDetailsByCourse(allStudents, filterCourses);
  }

}
