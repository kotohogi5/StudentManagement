package raisetech.student.manegement.repository;


import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import raisetech.student.manegement.Course;
import raisetech.student.manegement.Student;

@Mapper
//データベースを操作するクラス
public interface StudentRepository {

  @Select("SELECT * FROM students")
  List<Student> seachStudentList();

  @Select("SELECT * FROM students_courses")
  List<Course> seachCourseList();


}
