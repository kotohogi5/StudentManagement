package raisetech.student.manegement.repository;

import java.time.LocalDate;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import raisetech.student.manegement.entity.Course;

/**
 * コース情報に関するデータアクセスを提供するリポジトリインターフェース
 */
@Mapper
public interface CourseRepository {


  /*
-------------------------------------
READ系
-------------------------------------
 */

  /**
   * すべてのコース情報を取得するリポジトリメソッド
   *
   * @return 全コース情報のリスト
   */
  @Select("SELECT * FROM students_courses")
  List<Course> getAllCourses();


  /**
   * 指定したコース名でコース情報を取得するリポジトリメソッド
   *
   * @param courseName コース名
   * @return 指定されたコース名に該当する、コース情報のリスト
   */
  @Select("SELECT * FROM students_courses WHERE course_name = #{courseName}")
  List<Course> searchCourseBySubject(@Param("courseName") String courseName);


  /*
-------------------------------------
CREATE系
-------------------------------------
 */

  /**
   * 受講コース情報を新規登録するリポジトリメソッド
   *
   * @param studentId       生徒ID（studentsテーブルのidを参照する）
   * @param courseName      登録するコース名
   * @param courseStartDate 登録日
   */
  @Insert("INSERT INTO students_courses (student_id, course_name,course_start_date) " +
      "VALUES (#{studentId}, #{courseName}, #{courseStartDate})")
  void registerCourse(
      @Param("studentId") int studentId,
      @Param("courseName") String courseName,
      @Param("courseStartDate") LocalDate courseStartDate);

}
