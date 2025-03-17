package raisetech.student.manegement;

import java.util.HashMap;
import java.util.Map;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Application {

	private String name = "Goto Miyako";
	private String age = "20";
	//name,age
	private Map<String,String> studentMap;

 //コンストラクタ
	public Application(){
		this.name = name;
		this.age = age;
		this.studentMap = new HashMap<>();
	}

	public static void main(String[] args)
	{
		SpringApplication.run(Application.class, args);
	}

	//生徒情報の表示
	@GetMapping("/displayStudentInfo")
	public String getName(){
		return name + " " + age + "歳";
	}

	@GetMapping("/displayStudentInfoMap")
	public Map<String,String> displayStudentInfo(){
		return this.studentMap;
	}

	//生徒情報の登録
	@PostMapping("/setStudentInfo")
	public void setStudentInfo(String name,String age){
		this.name = name;
		this.age = age;
	}

	@PostMapping("/setStudentInfoMap")
	public void setStudentInfoMap(String name,String age){
		this.studentMap.put(name,age);
	}

	//生徒情報の一部修正
	@PostMapping("/updateStudentName")
	public void updateStudentName(String name){
		this.name = name;
	}

	@PostMapping("/updateStudentAge")
	public void updateStudentAge(String age){
		this.name = age;
	}

	@PostMapping("/updateStudentNameMap")
	public void updateStudentNameMap(String oldName,String newName){
		if(this.studentMap.containsKey(oldName)){

			//年齢情報を取得
			String age = this.studentMap.get(oldName);

			//最新情報（newName,age)に更新
			this.studentMap.put(newName,age);

			//古い情報（oldName,age)を削除
			this.studentMap.remove(oldName);

		}
	}
	@PostMapping("/updateStudentAgeMap")
	public void updateStudentAgeMap(String name,String newAge){
		if(this.studentMap.containsKey(name)){
			this.studentMap.put(name,newAge);
		}
	}



}
