package raisetech.student.manegement.controller;

import dto.StudentsSortDto;
import org.springframework.ui.Model;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import raisetech.student.manegement.domain.StudentDetail;
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


  /**
   * リクエストに応じた生徒詳細情報（加工済み）を取得し、テンプレートへ渡すコントローラーメソッド
   *
   * @param sortDto 検索条件（年齢範囲・コース名など）
   * @param model   Thymeleafに渡すモデル
   * @return 生徒情報一覧ページのビュー名（students.html）
   */
  @GetMapping("/students")
  public String searchStudentDetails(StudentsSortDto sortDto, Model model) {

    //任意の絞り込み検索された生徒の詳細情報を受け取る
    List<StudentDetail> studentDetail = studentDetailService.getStudentsDetails(sortDto);

    //modelにコンバートしたデータをセットし、Thymeleafテンプレへ引き渡す
    model.addAttribute("students", studentDetail);

    //表示するビュー名を返す
    return "students";
  }
}
