package raisetech.student.manegement.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import raisetech.student.manegement.data.Course;
import raisetech.student.manegement.repository.CourseRepository;

@Service
public class CourseService {
  private final CourseRepository courseRepository;

  @Autowired
  public CourseService(CourseRepository courseRepository) {
    this.courseRepository = courseRepository;
  }

  //全コース情報をコントローラーへ返す
  public List<Course> searchAllCourses() {
    return courseRepository.searchAllCourses();
  }

}
