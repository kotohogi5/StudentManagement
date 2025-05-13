package raisetech.student.manegement.service.converter;

import raisetech.student.manegement.dto.StudentDetailRegisterDto;
import org.springframework.stereotype.Component;
import raisetech.student.manegement.entity.Course;

/**
 * 入力用のRequest系コンバータークラス
 */


@Component
public class CourseInputConverter {

  //DTOからSQL用のcourseエンティティにコンバートする
  public Course convertDtoToCourse(StudentDetailRegisterDto dto) {
    Course course = new Course();
    course.setCourseName(dto.getCourseName());
    course.setCourseStartDate(dto.getCourseStartDate());
    return course;
  }

}
