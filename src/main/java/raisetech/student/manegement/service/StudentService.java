package raisetech.student.manegement.service;

import org.springframework.transaction.annotation.Transactional;
import raisetech.student.manegement.dto.StudentsSortDto;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import raisetech.student.manegement.entity.Student;
import raisetech.student.manegement.repository.StudentRepository;


/**
 * 生徒情報に関するビジネスロジックを提供するサービスクラス
 */
@Service
@Transactional(readOnly = true)
public class StudentService {

  private final StudentRepository studentRepository;

  /**
   * 生徒情報リポジトリを受け取るコンストラクタ
   *
   * @param studentRepository 生徒情報リポジトリ
   */
  @Autowired
  public StudentService(StudentRepository studentRepository) {
    this.studentRepository = studentRepository;
  }


  /*
-------------------------------------
READ系
-------------------------------------
 */

  /**
   * 全生徒情報を取得するサービスメソッド
   *
   * @return 全生徒情報のリスト
   */
  public List<Student> getAllStudents() {
    return studentRepository.getAllStudents();
  }


  /**
   * 指定された年齢範囲で生徒情報を取得するサービスメソッド
   *
   * @param sortDto 年齢範囲などの検索条件
   * @return 年齢範囲の条件に合致する生徒情報のリスト
   */
  public List<Student> searchStudentsByAge(StudentsSortDto sortDto) {
    return studentRepository.searchStudentsByAge(sortDto.getMinAge(), sortDto.getMaxAge());
  }


  /*
-------------------------------------
CREATE系
-------------------------------------
 */

  /**
   * 生徒情報を新規登録するサービスメソッド
   *
   * @param student 生徒情報
   */
  @Transactional
  public void registerStudent(Student student) {
    studentRepository.registerStudent(student);
  }

}
