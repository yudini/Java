package 실습12_1;

public class UnderGraduate extends Student {  //Student클래스를 상속받음
	String club;

	public UnderGraduate(String id, String name, String department, int age, String club) {
		super(id, name, department, age); //슈퍼클래스 생성자 호출
		this.club = club;
	}

	//객체를 문자열로 바꿔서 반환해주는 함수
	public String toString() {
		return String.format("%s %s %s %d %s %n", id, name, department, age, club);
	}
}
