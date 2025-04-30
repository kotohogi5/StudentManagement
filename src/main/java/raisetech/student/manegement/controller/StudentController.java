package raisetech.student.manegement.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import raisetech.student.manegement.controller.converter.StudentConverter;
import raisetech.student.manegement.data.Course;
import raisetech.student.manegement.data.Student;
import raisetech.student.manegement.domain.StudentDetail;
import raisetech.student.manegement.service.CourseService;
import raisetech.student.manegement.service.StudentService;

@RestController
public class StudentController {

  private final StudentService studentService;
  private final CourseService courseService;
  private final StudentConverter converter;

  @Autowired
  public StudentController(StudentService studentService,CourseService courseService, StudentConverter converter) {
    this.studentService = studentService;
    this.courseService = courseService;
    this.converter = converter;
  }

  //生徒情報+受講コース情報を出力するようリクエスト/レスポンスする
  @GetMapping("/students")
  public List<StudentDetail> searchStudents(@RequestParam(name="minAge",required = false) Integer minAge,
      @RequestParam(name="maxAge",required = false) Integer maxAge){

    //条件に応じた生徒情報を格納するリスト
    List<Student> students = studentService.searchStudentsByAge(minAge,maxAge);
    //全コース情報を格納するリスト
    List<Course> courses = courseService.searchAllCourses();

    //生徒情報とコース情報のコンバートへ
    return converter.getStudentDetails(students, courses);
  }

}
