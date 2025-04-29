package raisetech.student.manegement.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import raisetech.student.manegement.data.Student;
import raisetech.student.manegement.repository.StudentRepository;

@Service
public class StudentService {

  private final StudentRepository studentRepository;

  @Autowired
  public StudentService(StudentRepository studentRepository) {
    this.studentRepository = studentRepository;
  }

  //全生徒情報をコントローラーへ返す
  public List<Student> searchAllStudents() {
    return studentRepository.searchAllStudents();
  }

  //パラメータに年齢指定がある場合は条件検索を、なければ全件検索を行い、生徒情報リストをコントローラーへ返す
  public List<Student> searchStudentsByAge(Integer minAge, Integer maxAge) {
    if (minAge != null && maxAge != null) {
      return studentRepository.searchStudentByAge(minAge, maxAge);
    }
    return searchAllStudents();
  }
}
