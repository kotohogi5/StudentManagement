package raisetech.student.manegement.repository;


import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import raisetech.student.manegement.data.Student;

@Mapper
//データベースを操作するクラス
public interface StudentRepository {

  //すべての生徒情報を取得
  @Select("SELECT * FROM students")
  List<Student> searchAllStudents();

  //指定した年齢範囲の生徒情報を取得
  @Select("SELECT * FROM students WHERE age BETWEEN #{minAge} AND #{maxAge}")
  List<Student> searchStudentByAge(@Param("minAge") Integer minAge,@Param("maxAge") Integer maxAge);


}
