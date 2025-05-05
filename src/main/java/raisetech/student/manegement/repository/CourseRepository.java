package raisetech.student.manegement.repository;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import raisetech.student.manegement.data.Course;
import raisetech.student.manegement.domain.StudentDetail;

/**
 * コース情報に関するデータアクセスを提供するリポジトリインターフェース
 */
@Mapper
public interface CourseRepository {

  /**
   * すべてのコース情報を取得するリポジトリメソッド
   *
   * @return 全コース情報のリスト
   */
  @Select("SELECT * FROM students_courses")
  List<Course> searchAllCourses();


  /**
   * 指定したコース名でコース情報を取得するリポジトリメソッド
   *
   * @param courseName コース名
   * @return 指定されたコース名に該当する、コース情報のリスト
   */
  @Select("SELECT * FROM students_courses WHERE course_name = #{courseName}")
  List<Course> searchCourseBySubject(@Param("courseName") String courseName);


}
