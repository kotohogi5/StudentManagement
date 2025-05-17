package raisetech.student.manegement.service;

import raisetech.student.manegement.dto.StudentDetailRegisterDto;
import io.micrometer.common.util.StringUtils;
import java.util.Objects;
import raisetech.student.manegement.dto.StudentsSortDto;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import raisetech.student.manegement.controller.converter.StudentDetailOutputConverter;
import raisetech.student.manegement.entity.Course;
import raisetech.student.manegement.entity.Student;
import raisetech.student.manegement.dto.StudentDetailResponseDto;
import raisetech.student.manegement.service.converter.CourseInputConverter;
import raisetech.student.manegement.service.converter.StudentInputConverter;


/**
 * 生徒情報・コース情報を統合し、ビジネスロジックを処理するサービスクラス
 */
@Service
@Transactional
public class StudentDetailService {

  private final StudentService studentService;
  private final CourseService courseService;
  private final StudentDetailOutputConverter studentDetailOutputConverter;
  private final StudentInputConverter studentInputConverter;
  private final CourseInputConverter courseInputConverter;

  /**
   * 依存サービスを受け取るコンストラクタ
   *
   * @param studentService               生徒情報サービス
   * @param courseService                コース情報サービス
   * @param studentDetailOutputConverter 生徒詳細情報の出力用コンバーター
   * @param studentInputConverter        生徒情報の入力用コンバーター
   * @param courseInputConverter         コース情報の入力用コンバーター
   */
  @Autowired
  public StudentDetailService(
      StudentService studentService, CourseService courseService,
      StudentDetailOutputConverter studentDetailOutputConverter,
      StudentInputConverter studentInputConverter,
      CourseInputConverter courseInputConverter) {
    this.studentService = studentService;
    this.courseService = courseService;
    this.studentDetailOutputConverter = studentDetailOutputConverter;
    this.studentInputConverter = studentInputConverter;
    this.courseInputConverter = courseInputConverter;
  }


  /*
-------------------------------------
READ系
-------------------------------------
 */

  /**
   * 検索条件に応じてフィルタリングされた生徒詳細情報リストを返す、統合処理用サービスメソッド
   *
   * @param sortDto 検索条件
   * @return 生徒詳細情報リスト
   */
  @Transactional(readOnly = true)
  public List<StudentDetailResponseDto> getStudentsDetails(StudentsSortDto sortDto) {

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
   * 検索条件なし（全件）の生徒詳細情報リストを返す、統合処理用サービスメソッド
   *
   * @return 検索条件先でコンバートされた全生徒詳細情報リスト
   */
  private List<StudentDetailResponseDto> defaultStudentsDetails() {

    //生徒情報を格納するリスト
    List<Student> allStudents = studentService.getAllStudents();

    //コース情報を格納するリスト
    List<Course> allCourses = courseService.getAllCourses();

    //生徒情報とコース情報のコンバートを返す
    return studentDetailOutputConverter.getStudentDetailsByStudent(allStudents, allCourses);
  }


  /**
   * 年齢条件で絞り込んだ生徒詳細情報リストを返す、統合処理用サービスメソッド
   *
   * @param sortDto 年齢条件
   * @return 条件に合致する生徒詳細情報リスト
   */
  private List<StudentDetailResponseDto> searchStudentsDetailsByAge(StudentsSortDto sortDto) {

    //条件に応じた生徒情報を格納するリスト
    List<Student> filterStudents = studentService.searchStudentsByAge(sortDto);

    //条件に応じたコース情報を格納するリスト
    List<Course> allCourses = courseService.getAllCourses();

    //生徒情報とコース情報を統合サービスへ渡し、コンバート処理を依頼
    return studentDetailOutputConverter.getStudentDetailsByStudent(filterStudents, allCourses);
  }


  /**
   * コース名条件で絞り込んだ生徒詳細情報リストを返す、統合処理用サービスメソッド
   *
   * @param sortDto コース名条件
   * @return 条件に合致する生徒詳細情報リスト
   */
  private List<StudentDetailResponseDto> searchStudentsDetailsByCourse(StudentsSortDto sortDto) {

    //全生徒情報を格納するリスト
    List<Student> allStudents = studentService.getAllStudents();

    //条件に応じたコース情報を格納するリスト
    List<Course> filterCourses = courseService.searchCourseBySubject(sortDto);

    //生徒情報とコース情報を統合サービスへ渡し、コンバート処理を依頼
    return studentDetailOutputConverter.getStudentDetailsByCourse(allStudents, filterCourses);
  }

  /*
-------------------------------------
CREATE系
-------------------------------------
 */

  /**
   * 生徒情報とコース情報を同時登録する統合処理用サービスメソッド
   *
   * @param dto 登録したい生徒情報とコース情報を格納
   */
  public void registerStudentDetails(StudentDetailRegisterDto dto) {

    //DTOからSQL用のエンティティへコンバート処理
    Student student = studentInputConverter.convertDtoToStudent(dto);
    Course course = courseInputConverter.convertDtoToCourse(dto);

    //生徒情報登録
    studentService.registerStudent(student);
    //生徒IDを利用してコース情報登録
    courseService.registerCourse(student.getId(), course);
  }

}
