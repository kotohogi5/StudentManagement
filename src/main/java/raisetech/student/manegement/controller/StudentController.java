package raisetech.student.manegement.controller;

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
  @GetMapping("/students")
  public List<StudentDetail> searchStudents(@RequestParam(name="minAge",required = false) Integer minAge,
      @RequestParam(name="maxAge",required = false) Integer maxAge){

    //生徒情報を格納するリスト
    List<Student> students;

    //パラメータに年齢指定がある場合は条件検索を、なければ全件検索を行い、生徒情報リストに格納する
    if(minAge != null && maxAge != null){
      students = service.searchStudentsByAge(minAge,maxAge);
    }else{
      students = service.searchStudents();
    }
    //全コース情報をリストに取得
    List<Course> courses = service.searchCourses();
    //生徒情報とコース情報のコンバート処理へ
    return converter.getStudentDetails(students, courses);
  }

}
