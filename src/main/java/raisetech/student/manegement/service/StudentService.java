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
  public List<Student> searchStudents(){
    return repository.seachStudents();
  }

  //全コース情報をコントローラーへ返す
  public List<Course> searchCourses(){
    return repository.seachCourses();
  }

  //指定した年齢範囲の生徒情報だけをフィルタリングしてコントローラーへ返す
  public List<Student> searchStudentsByAge(Integer minAge,Integer maxAge){

    //全生徒情報をリポジトリ層（DB）から取得する
    return repository.seachStudents().stream()
        .filter(student -> student.getAge() >= minAge && student.getAge() <= maxAge)
        .collect(Collectors.toList());
  }
}
