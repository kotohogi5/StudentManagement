package raisetech.student.manegement.repository;


import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import raisetech.student.manegement.entity.Student;

/**
 * 生徒情報に関するデータアクセスを提供するリポジトリインターフェース
 */
//生徒情報用リポジトリ
@Mapper
public interface StudentRepository {

  /*
-------------------------------------
READ系
-------------------------------------
 */

  /**
   * すべての生徒情報を取得するリポジトリメソッド
   *
   * @return 全生徒情報のリスト
   */
  @Select("SELECT * FROM students")
  List<Student> getAllStudents();

  /**
   * 指定した年齢範囲で生徒情報を取得するリポジトリメソッド
   *
   * @param minAge 最小年齢（を含む）
   * @param maxAge 最大年齢（を含む）
   * @return 指定年齢範囲に該当する生徒情報のリスト
   */
  @Select("SELECT * FROM students WHERE age BETWEEN #{minAge} AND #{maxAge}")
  List<Student> searchStudentsByAge(@Param("minAge") Integer minAge,
      @Param("maxAge") Integer maxAge);


  /*
-------------------------------------
CREATE系
-------------------------------------
 */

  /**
   * 生徒情報を新規登録するリポジトリメソッド
   *
   * @param student 登録する生徒情報のエンティティ（idプロパティは自動採番される）
   */
  @Insert(
      "INSERT INTO students (full_name, ruby_text, nickname, email, area, age, gender, remark) " +
          "VALUES (#{fullName}, #{rubyText}, #{nickname}, #{email}, #{area}, #{age}, #{gender}, #{remark})")
  @Options(useGeneratedKeys = true, keyProperty = "id")
  void registerStudent(Student student);


}
