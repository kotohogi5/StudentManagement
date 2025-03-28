package raisetech.student.manegement;


import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
//データベースを操作するクラス
public interface StudentRepository {

  /*指定した生徒情報を１件取得
  @Select("SELECT * FROM student WHERE name = #{name}")
  Student searchByName(String name);
  */

  //【第20回課題】の解答
  @Select("SELECT name, age FROM student")
  List<Student> searchAllStudentInfo();

  @Insert("INSERT student values(#{name},#{age})")
  void registerStudentInfo(String name,int age);

  @Update("UPDATE student SET age=#{age} WHERE name = #{name}")
  void updateStudentAge(String name , int age);

  @Delete("DELETE FROM student WHERE name = #{name}")
  void deleteStudentInfo(String name);

}
