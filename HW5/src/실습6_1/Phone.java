package 실습6_1;

public class Phone {
	private String name;
	private String tel;

	public Phone() { // 기본생성자
		name = "None";
		tel = "None";
	}

	public Phone(String name, String tel) { // 이름과 전화번호를 매개변수로 받는 생성자
		this.name = name;
		this.tel = tel;
	}

	public String getName() { // 이름을 반환하는 함수
		return name;
	}

	public void setName(String name) { // 이름을 설정하는 함수
		this.name = name;
	}

	public String getTel() { // 전화번호를 반환하는 함수
		return tel;
	}

	public void setTel(String tel) { // 전화번호를 설정하는 함수
		this.tel = tel;
	}

	public String toString() {    //Phone 객체의 내용
		return "(" + name + "," + tel + ")";
	}

}
