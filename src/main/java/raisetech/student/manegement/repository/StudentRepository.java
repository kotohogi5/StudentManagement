package raisetech.student.manegement.repository;


import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import raisetech.student.manegement.data.Course;
import raisetech.student.manegement.data.Student;

@Mapper
//データベースを操作するクラス
public interface StudentRepository {

  @Select("SELECT * FROM students")
  List<Student> seachStudents();

  @Select("SELECT * FROM students_courses")
  List<Course> seachCourses();


}
