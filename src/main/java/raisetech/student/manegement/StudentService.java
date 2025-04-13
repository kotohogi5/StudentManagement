package raisetech.student.manegement;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import raisetech.student.manegement.repository.StudentRepository;

@Service
public class StudentService {

  private StudentRepository repository;

  @Autowired
  public StudentService(StudentRepository repository) {
    this.repository = repository;
  }

  //全生徒情報を出力する
  public List<Student> searchStudentList(){
    return repository.seachStudentList();
  }

  //全コース情報を出力する
  public List<Course> searchCourseList(){
    return repository.seachCourseList();
  }

  //【課題24】30代の生徒情報だけをフィルタリングしてコントローラーへ返す
  public Map<String,Student> searchStudentAge30To39(){

    //全生徒情報をリポジトリ層（DB）から取得する
    List<Student> studentList = repository.seachStudentList();

    //フィルタリングした30代の生徒情報を返す
    return studentList.stream()
        .filter(student -> student.getAge() >= 30 && student.getAge() < 40)
        .collect(Collectors.toMap(Student::getId,Function.identity()));
  }
}
