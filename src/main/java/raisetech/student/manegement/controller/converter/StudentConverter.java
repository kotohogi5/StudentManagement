package raisetech.student.manegement.controller.converter;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;
import raisetech.student.manegement.data.Course;
import raisetech.student.manegement.data.Student;
import raisetech.student.manegement.domain.StudentDetail;

@Component
public class StudentConverter {

  public List<StudentDetail> getStudentDetails(List<Student> students, List<Course> courses) {

    //コンバート用（生徒情報とコース情報の紐づけ）リストのインスタンスを用意
    List<StudentDetail> studentDetails = new ArrayList<>();

    //studentDetailsインスタンスに、生徒情報を代入する
    for(Student student : students){
      StudentDetail studentDetail = new StudentDetail();
      studentDetail.setStudent(student);

      //convertCoursesインスタンスに、生徒情報と一致するコース情報を代入する
      List<Course> convertCourses = new ArrayList<>();
      for (Course course : courses){
        //「生徒情報」と「コース」の外部キーが一致したら
        if(student.getId().equals(course.getStudentInfoId())){
          convertCourses.add(course);
        }
      }
      //生徒情報と、それに紐づくコース情報一覧をマージする
      studentDetail.setCourses(convertCourses);
      //コンバート用リストに、マージした生徒情報＋コースを追加する
      studentDetails.add(studentDetail);
    }

    return studentDetails;
  }

}
