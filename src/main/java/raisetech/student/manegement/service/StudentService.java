package raisetech.student.manegement.service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import raisetech.student.manegement.data.Course;
import raisetech.student.manegement.data.Student;
import raisetech.student.manegement.repository.StudentRepository;

@Service
public class StudentService {

  private StudentRepository repository;

  @Autowired
  public StudentService(StudentRepository repository) {
    this.repository = repository;
  }

  //全生徒情報をコントローラーへ返す
  public List<Student> searchAllStudents() {
    return repository.seachStudents();
  }

  //全コース情報をコントローラーへ返す
  public List<Course> searchAllCourses() {
    return repository.seachCourses();
  }

  //パラメータに年齢指定がある場合は条件検索を、なければ全件検索を行い、生徒情報リストをコントローラーへ返す
  public List<Student> searchStudentsByAge(Integer minAge, Integer maxAge) {

    //生徒情報の格納リスト
    List<Student> students;

    //リクエストが条件検索か全件検索か
    if (minAge != null && maxAge != null) {
      students = repository.seachStudents().stream()
          .filter(student -> student.getAge() >= minAge && student.getAge() <= maxAge)
          .collect(Collectors.toList());
    } else {
      students = searchAllStudents();
    }
    return students;
  }
}
