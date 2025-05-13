package raisetech.student.manegement.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * 検索条件（年齢やコース名など）を受け取るための、入力用・条件指定用DTOクラス
 **/

@Getter
@Setter
public class StudentsSortDto {

  //年齢指定
  private Integer minAge;
  private Integer maxAge;
  //コース名指定
  private String courseName;

}
