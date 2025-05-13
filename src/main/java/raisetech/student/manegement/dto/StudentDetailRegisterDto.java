package raisetech.student.manegement.dto;

import java.sql.Timestamp;
import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

/**
 * 新規登録のためのinput用（Request系）DTOクラス
 **/

@Getter
@Setter
public class StudentDetailRegisterDto {

  private String fullName;
  private String rubyText;
  private String nickname;
  private String email;
  private String area;
  private Integer age;
  private String gender;
  private String remark;
  private String courseName;
  private LocalDate courseStartDate;
}
