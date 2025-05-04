package raisetech.student.manegement.service;

import dto.StudentsSortDto;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import raisetech.student.manegement.data.Course;
import raisetech.student.manegement.domain.StudentDetail;
import raisetech.student.manegement.repository.CourseRepository;

/**
 * コース情報に関するビジネスロジックを提供するサービスクラス
 */
@Service
public class CourseService {
  private final CourseRepository courseRepository;

  /**
   * 初期化
   * 概要：コンストラクでリポジトリを受け取る
   * @param courseRepository コース情報リポジトリ
   */
  @Autowired
  public CourseService(CourseRepository courseRepository) {
    this.courseRepository = courseRepository;
  }


  /**
   * 全コース情報を取得するサービスソッド
   * @return 全コース情報のリスト
   */
  public List<Course> searchAllCourses() {
    return courseRepository.searchAllCourses();
  }


  /**
   * 指定されたコース名でコース情報を取得するサービスメソッド
   * @param sortDto コース名などの検索条件
   * @return 指定されたコース名に合致するコース情報のリスト
   */
  public  List<Course> searchCourseBySubject(StudentsSortDto sortDto){
    return courseRepository.searchCourseBySubject(sortDto.getCourseName());
  }

}
