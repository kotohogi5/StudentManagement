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
    return new Course(
        dto.getCourseName(),
        dto.getCourseStartDate()
    );
  }

}
