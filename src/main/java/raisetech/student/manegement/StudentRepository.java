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

  @Select("SELECT * FROM students")
  List<Student> searchAllStudentInfo();
}
