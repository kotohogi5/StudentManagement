package raisetech.student.manegement.repository;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import raisetech.student.manegement.data.Course;

@Mapper
public interface CourseRepository {
  //すべてのコース情報を取得
  @Select("SELECT * FROM students_courses")
  List<Course> searchAllCourses();


}
