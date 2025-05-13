package raisetech.student.manegement.service;

import raisetech.student.manegement.dto.StudentsSortDto;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import raisetech.student.manegement.entity.Course;
import raisetech.student.manegement.repository.CourseRepository;

/**
 * コース情報に関するビジネスロジックを提供するサービスクラス
 */
@Service
public class CourseService {

  private final CourseRepository courseRepository;

  /**
   * リポジトリを受け取るコンストラクタ
   *
   * @param courseRepository コース情報リポジトリ
   */
  @Autowired
  public CourseService(CourseRepository courseRepository) {
    this.courseRepository = courseRepository;
  }


  /**
   * 全コース情報を取得するサービスソッド
   *
   * @return 全コース情報のリスト
   */
  public List<Course> getAllCourses() {
    return courseRepository.getAllCourses();
  }


  /**
   * 指定されたコース名でコース情報を取得するサービスメソッド
   *
   * @param sortDto コース名などの検索条件
   * @return 指定されたコース名に合致するコース情報のリスト
   */
  public List<Course> searchCourseBySubject(StudentsSortDto sortDto) {
    return courseRepository.searchCourseBySubject(sortDto.getCourseName());
  }


  /*
-------------------------------------
CREATE系
-------------------------------------
 */

  /// 新規登録された生徒の受講コースをあわせて登録するサービスメソッド
  public void registerCourse(int studentId, Course course) {
    courseRepository.registerCourse(studentId, course.getCourseName(), course.getCourseStartDate());
  }

}
