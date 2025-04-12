package raisetech.student.manegement;

import java.util.List;
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

  @GetMapping("/studentList")
  public List<Student> searchStudentList(){
    return service.searchStudentList();
  }

  @GetMapping("/courseList")
  public List<Course> searchCourseList(){
    return service.searchCourseList();
  }


}
