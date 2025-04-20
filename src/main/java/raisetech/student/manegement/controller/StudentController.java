package raisetech.student.manegement.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import raisetech.student.manegement.controller.converter.StudentConverter;
import raisetech.student.manegement.data.Course;
import raisetech.student.manegement.data.Student;
import raisetech.student.manegement.domain.StudentDetail;
import raisetech.student.manegement.service.StudentService;

@RestController
public class StudentController {

  private StudentService service;
  private StudentConverter converter;

  @Autowired
  public StudentController(StudentService service,StudentConverter converter) {
    this.service = service;
    this.converter = converter;
  }

  //全生徒情報を出力するようリクエスト/レスポンスする
  @GetMapping("/studentList")
  public List<StudentDetail> searchStudentList(){
    //全生徒情報をリストに取得
    List<Student> students = service.searchStudentList();
    //全コース情報をリストに取得
    List<Course> courses = service.searchCourseList();

    return converter.getStudentDetails(students, courses);
  }

  //全コース情報を出力するようリクエスト/レスポンスする
  @GetMapping("/courseList")
  public List<Course> searchCourseList(){
    return service.searchCourseList();
  }

  //生徒情報を年齢でフィルタリングしてから出力するようリクエスト/レスポンスする
  @GetMapping("/studentAge")
  public Map<String,Student> searchStudentAge(@RequestParam(name="minAge") int minAge,
      @RequestParam(name="maxAge") int maxAge){
    return service.searchStudentAge(minAge,maxAge);
  }

}
