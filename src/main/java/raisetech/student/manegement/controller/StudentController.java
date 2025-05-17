package raisetech.student.manegement.controller;

import raisetech.student.manegement.dto.StudentDetailRegisterDto;
import raisetech.student.manegement.dto.StudentsSortDto;
import org.springframework.ui.Model;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import raisetech.student.manegement.dto.StudentDetailResponseDto;
import raisetech.student.manegement.service.StudentDetailService;

/**
 * 生徒詳細情報（生徒情報＋コース情報）の検索と画面表示を担当するコントローラークラス
 */
@Controller
public class StudentController {

  private final StudentDetailService studentDetailService;

  /**
   * 統合サービス（生徒詳細情報サービス）を受け取るコンストラクタ
   *
   * @param studentDetailService 生徒詳細情報サービス（生徒情報＋受講コース情報）
   */
  @Autowired
  public StudentController(StudentDetailService studentDetailService) {
    this.studentDetailService = studentDetailService;
  }

  /*
-------------------------------------
READ系
-------------------------------------
 */

  /**
   * リクエストに応じた生徒詳細情報（加工済み）を取得し、テンプレートへ渡すコントローラーメソッド
   *
   * @param sortDto 検索条件（年齢範囲・コース名など）
   * @param model   Thymeleafに渡すモデル
   * @return 生徒情報一覧ページのビュー名（students.html）
   */
  @GetMapping("/studentDetails")
  public String searchStudentDetails(StudentsSortDto sortDto, Model model) {

    //任意の絞り込み検索された生徒の詳細情報を受け取る
    List<StudentDetailResponseDto> studentDetail = studentDetailService.getStudentsDetails(sortDto);

    //modelにコンバートしたデータをセットし、Thymeleafテンプレへ引き渡す
    model.addAttribute("studentDetails", studentDetail);

    //表示するビュー名を返す
    return "studentDetails";
  }


  /*
-------------------------------------
CREATE系
-------------------------------------
 */

  /**
   * 新規生徒登録画面を表示するコントローラーメソッド
   *
   * @param model 登録フォームにバインドするためのModelオブジェクト
   * @return 生徒登録画面のビュー名（"registerStudent"）
   */
  @GetMapping("/newStudent")
  public String newStudent(Model model) {
    model.addAttribute("studentDetailRegisterDto", new StudentDetailRegisterDto());
    return "registerStudent";
  }


  /**
   * 生徒情報を登録するコントローラーメソッド
   *
   * @param dto    フォームから送信された生徒情報を格納したDTO
   * @param result バリデーション結果を保持するBindingResult
   * @return エラー時は生徒登録画面のビュー名（"registerStudent"）、正常時は生徒一覧画面へのリダイレクト
   */
  @PostMapping("/registerStudent")
  public String registerStudent(@ModelAttribute StudentDetailRegisterDto dto,
      BindingResult result) {
    if (result.hasErrors()) {
      System.out.println("【エラー】フォームから送信された生徒情報の処理に失敗しました。");
      return "registerStudent";
    }
    studentDetailService.registerStudentDetails(dto);

    return "redirect:/studentDetails";
  }
}
