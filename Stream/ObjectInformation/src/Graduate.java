package 실습12_1;

public class Graduate extends Student {  //Student클래스를 상속받음
	String degree;
	String major;

	public Graduate(String id, String name, String department, int age, String degree, String major) {
		super(id, name, department, age);  //슈퍼클래스 생성자 호출
		this.degree = degree;
		this.major = major;
	}
//객체를 문자열로 바꿔서 반환해주는 함수
	public String toString() {
		return String.format("%s %s %s %d %s %s %n", id, name, department, age, degree, major);
	}
}
