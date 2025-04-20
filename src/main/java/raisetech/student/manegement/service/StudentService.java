package raisetech.student.manegement.service;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
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
  public List<Student> searchStudentList(){
    return repository.seachStudentList();
  }

  //全コース情報をコントローラーへ返す
  public List<Course> searchCourseList(){
    return repository.seachCourseList();
  }

  //指定した年齢範囲の生徒情報だけをフィルタリングしてコントローラーへ返す
  public Map<String,Student> searchStudentAge(int minAge,int maxAge){

    //全生徒情報をリポジトリ層（DB）から取得する
    List<Student> studentList = repository.seachStudentList();

    //指定した年齢範囲の生徒情報をフィルタリングして返す
    return studentList.stream()
        .filter(student -> student.getAge() >= minAge && student.getAge() <= maxAge)
        .collect(Collectors.toMap(Student::getId,Function.identity()));
  }
}
