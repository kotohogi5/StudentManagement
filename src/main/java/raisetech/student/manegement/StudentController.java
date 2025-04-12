package raisetech.student.manegement;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import raisetech.student.manegement.repository.StudentRepository;

@RestController
public class StudentController {

  private StudentService service;

  @Autowired
  public StudentController(StudentService service) {
    this.service = service;
  }

  //全生徒情報を出力するようリクエスト/レスポンスする
  @GetMapping("/studentList")
  public List<Student> searchStudentList(){
    return service.searchStudentList();
  }

  //全コース情報を出力するようリクエスト/レスポンスする
  @GetMapping("/courseList")
  public List<Course> searchCourseList(){
    return service.searchCourseList();
  }

  //【課題24】30代の生徒情報をフィルタリングしてから出力するようリクエスト/レスポンスする
  @GetMapping("/studentAge30To39")
  public Map<String,Student> searchStudentAge30To39(){
    return service.searchStudentAge30To39();
  }

}
