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
 * 生徒情報の検索と画面表示を担当するコントローラークラス
 * 概要：検索条件に応じた生徒情報＋コース情報を取得し、Thymeleafテンプレートへ渡す
 */

@Controller
public class StudentController {

  private final StudentDetailService studentDetailService;

  /**
   * コンストラクタ
   * 概要：コンストラクタで、統合サービス（生徒詳細情報サービス）を受け取る
   * @param studentDetailService 生徒詳細情報サービス（生徒情報＋受講コース情報）
   */
  @Autowired
  public StudentController(StudentDetailService studentDetailService) {
    this.studentDetailService = studentDetailService;
  }


  /**
   * リクエストに応じた生徒詳細情報（加工済み）を取得し、テンプレートへ渡すコントローラーメソッド
   * 概要：検索条件（年齢やコース名など）がある場合は、StudentsSortDtoオブジェクトで受け取る
   * 概要：条件指定がない場合は、全件を出力する
   * @param sortDto 検索条件（年齢範囲・コース名など）
   * @param model Thymeleafに渡すモデル
   * @return 生徒情報一覧ページのビュー名（students.html）
   */
  @GetMapping("/students")
  public String searchStudentsByAge(StudentsSortDto sortDto, Model model){

    //任意の絞り込み検索された生徒の詳細情報を受け取る
    List<StudentDetail> convertStudentAndCourses = studentDetailService.getStudentsDetails(sortDto);

    //modelにコンバートしたデータをセットし、Thymeleafテンプレへ引き渡す
    model.addAttribute("students", convertStudentAndCourses) ;

    //表示するビュー名を返す
    return "students";
  }
}
