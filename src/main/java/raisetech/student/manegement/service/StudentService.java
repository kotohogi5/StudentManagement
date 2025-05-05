package raisetech.student.manegement.service;

import dto.StudentsSortDto;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import raisetech.student.manegement.data.Student;
import raisetech.student.manegement.repository.StudentRepository;

/**
 * 生徒情報に関するビジネスロジックを提供するサービスクラス
 */
@Service
public class StudentService {

  private final StudentRepository studentRepository;

  /**
   * コンストラクタで生徒情報リポジトリを受け取るコンストラクタ
   *
   * @param studentRepository 生徒情報リポジトリ
   */
  @Autowired
  public StudentService(StudentRepository studentRepository) {
    this.studentRepository = studentRepository;
  }


  /**
   * 全生徒情報を取得するサービスメソッド
   *
   * @return 全生徒情報のリスト
   */
  public List<Student> searchAllStudents() {
    return studentRepository.searchAllStudents();
  }


  /**
   * 指定された年齢範囲で生徒情報を取得するサービスメソッド
   *
   * @param sortDto 年齢範囲などの検索条件
   * @return 年齢範囲の条件に合致する生徒情報のリスト
   */
  public List<Student> searchStudentsByAge(StudentsSortDto sortDto) {
    return studentRepository.searchStudentByAge(sortDto.getMinAge(), sortDto.getMaxAge());
  }
}
