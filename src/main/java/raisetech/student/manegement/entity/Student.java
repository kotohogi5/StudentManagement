package raisetech.student.manegement.entity;

import lombok.Getter;
import lombok.AllArgsConstructor;

/**
 * 生徒情報を保持するエンティティクラス
 */

@Getter
@AllArgsConstructor
public class Student {

  private int id;
  private String fullName;
  private String rubyText;
  private String nickname;
  private String email;
  private String area;
  private Integer age;
  private String gender;
  private String remark; //備考欄
  private boolean isDeleted; //自動的にfalse(0)がマッピング

  /**
   * 出力用コンストラクタ（全フィールド）
   *
   * @AllArgsConstructorで自動生成
   **/


  /**
   * 登録用コンストラクタ
   *
   * @param fullName フルネーム
   * @param rubyText 　フルネームのルビ
   * @param nickname 　ニックネーム
   * @param email    　メールアドレス
   * @param area     　住んでいる地域
   * @param age      　年齢
   * @param gender   　性別
   * @param remark   　補足
   */
  public Student(String fullName, String rubyText, String nickname, String email,
      String area, Integer age, String gender, String remark) {
    this(0, fullName, rubyText, nickname, email, area, age, gender, remark, false);
  }

}

