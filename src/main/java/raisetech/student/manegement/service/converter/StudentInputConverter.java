package raisetech.student.manegement.service.converter;

import raisetech.student.manegement.dto.StudentDetailRegisterDto;
import org.springframework.stereotype.Component;
import raisetech.student.manegement.entity.Student;

/**
 * 入力用のRequest系コンバータークラス
 */
@Component
public class StudentInputConverter {

  //DTOからSQL用のStudentエンティティにコンバートする
  public Student convertDtoToStudent(StudentDetailRegisterDto dto) {
    Student student = new Student();
    student.setFullName(dto.getFullName());
    student.setRubyText(dto.getRubyText());
    student.setNickname(dto.getNickname());
    student.setEmail(dto.getEmail());
    student.setArea(dto.getArea());
    student.setAge(dto.getAge());
    student.setGender(dto.getGender());
    student.setRemark(dto.getRemark());
    return student;
  }

}
