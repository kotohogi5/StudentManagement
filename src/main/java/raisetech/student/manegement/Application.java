package raisetech.student.manegement;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Application {

	@Autowired
	private StudentRepository repository;

	public static void main(String[] args)
	{
		SpringApplication.run(Application.class, args);
	}


	//【第20回課題】すべての生徒情報を表示する
	@GetMapping("/student")
	public List<Student> searchAllStudentInfo(){
		return repository.searchAllStudentInfo();
}


	//生徒情報の登録する
	@PostMapping("/student")
	public void registerStudentInfo(String name,int age){
		repository.registerStudentInfo(name,age);
	}

	
	//生徒の年齢を修正する
	@PatchMapping("/student")
	public void updateStudentAge(String name , int age){
		repository.updateStudentAge(name,age);
	}


	//生徒情報を削除する
	@DeleteMapping("/student")
	public void deleteStudentInfo(String name){
		repository.deleteStudentInfo(name);
	}


}
