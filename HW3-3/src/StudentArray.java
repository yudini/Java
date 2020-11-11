import java.util.Scanner;

public class StudentArray {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("학생 수 입력:");
		int num = sc.nextInt(); // 학생수 입력받기
		Student student[] = new Student[num]; // 객체 배열 생성 및 초기화
		for (int i = 0; i < num; i++) { // i는 0부터 num미만까지 반복
			System.out.print(i + "번째 학생 이름과 성적을 입력하시오(이름과 성적은 빈칸으로 구분):");
			String name = sc.next(); // 이름 입력받기
			int score = sc.nextInt(); // 성적 입력받기
			student[i] = new Student(name, score); // 새로운 Student 객체 생성 후 student[i]에 저장
		}

		System.out.printf("%s%12s%13s%15s \n", "학교", "학번", "이름", "성적");
		for (int i = 0; i < student.length; i++) {
			student[i].printStudent(); // student[i]의 printStudent함수 호출
		}

		sc.close();
	}

}

class Student {
	private String name;
	private int score;
	private String school;
	private int number;
	private static int count = 0;

	public Student(String name, int score) {
		this.name = name; // setName함수 호출
		this.score = score; // setScore함수 호출
		this.school = "한성대학교"; // 학교는 한성대학교로 초기화
		this.number = count++; // 학번은 count 후위증가 값
	}

	public String getName() { // 이름을 반환하는 함수
		return name;
	}

	public void setName(String name) { // 이름을 설정하는 함수
		this.name = name;
	}

	public int getScore() { // 성적을 반환하는 함수
		return score;
	}

	public void setScore(int score) { // 성적을 설정하는 함수
		this.score = score;
	}

	public void printStudent() { // 객체들의 정보를 출력하는 함수
		System.out.printf("%s%5d%10s%15d \n", school, number, getName(), getScore());
	}
}
