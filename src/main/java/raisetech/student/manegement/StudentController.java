package raisetech.student.manegement;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

  //【課題24】生徒情報を年齢でフィルタリングしてから出力するようリクエスト/レスポンスする
  @GetMapping("/studentAge")
  public Map<String,Student> searchStudentAge(@RequestParam(name="minAge") int minAge,@RequestParam(name="maxAge") int maxAge){
    return service.searchStudentAge(minAge,maxAge);
  }

}
