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
    return new Student(
        dto.getFullName(),
        dto.getRubyText(),
        dto.getNickname(),
        dto.getEmail(),
        dto.getArea(),
        dto.getAge(),
        dto.getGender(),
        dto.getRemark()
    );
  }

}
