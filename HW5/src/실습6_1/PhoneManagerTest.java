package 실습6_1;

import java.util.Scanner;

public class PhoneManagerTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("인원수>>");
		int num = sc.nextInt(); // num에 인원수 저장
		PhoneManager phonemanager = new PhoneManager(num); // phonemanager객체 생성 및 초기화
		setPhone(phonemanager, num, sc); // setPhone함수 호출
		searchName(phonemanager, sc); // searchName함수 호출
		phonemanager.display();       //phonemanager의 display 함수 호출
		sc.close();
	}

	public static void setPhone(PhoneManager phonemanager, int num, Scanner sc) {// 이름과 전화번호를 설정하는 함수
		for (int i = 0; i < num; i++) {
			System.out.print("이름과 전화번호(번호는 연속적으로 입력)>>");
			String name = sc.next(); // 이름을 입력받아서 저장
			String tel = sc.next(); // 전화번호를 입력받아서 저장
			Phone phone = new Phone(name, tel); // name과 tel을 인자로 전달하는 phone객체 생성 및 초기화
			phonemanager.add(phone); // phone을 인자로 전달하여 phonemanager의 add함수 호출
		}
	}

	public static void searchName(PhoneManager phonemanager, Scanner sc) { // 이름을 검색하는 함수
		while (true) {
			System.out.print("검색할 이름>>");
			String name = sc.next();
			if (name.equals("exit")) // name값이 exit면
				break; // 반복문 종료 //반복문 탈출
			else {
				phonemanager.searchByName(name); // phonemanager의 searchByName함수 호출
			}
		}
	}

}
