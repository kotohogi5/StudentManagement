package raisetech.student.manegement.data;

import lombok.Getter;
import lombok.Setter;

/**
 * 生徒情報を保持するエンティティクラス
 */

@Getter
@Setter
public class Student {

  private String id;
  private String fullName;
  private String rubyText;
  private String nickName;
  private String email;
  private String area;
  private int age;
  private String gender;
  private String remark; //備考欄
  private boolean isDeleted; //自動的にfalse(0)がマッピング
}

