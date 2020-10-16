package �ǽ�6_1;

import java.util.Scanner;

public class PhoneManagerTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("�ο���>>");
		int num = sc.nextInt(); // num�� �ο��� ����
		PhoneManager phonemanager = new PhoneManager(num); // phonemanager��ü ���� �� �ʱ�ȭ
		setPhone(phonemanager, num, sc); // setPhone�Լ� ȣ��
		searchName(phonemanager, sc); // searchName�Լ� ȣ��
		phonemanager.display();       //phonemanager�� display �Լ� ȣ��
		sc.close();
	}

	public static void setPhone(PhoneManager phonemanager, int num, Scanner sc) {// �̸��� ��ȭ��ȣ�� �����ϴ� �Լ�
		for (int i = 0; i < num; i++) {
			System.out.print("�̸��� ��ȭ��ȣ(��ȣ�� ���������� �Է�)>>");
			String name = sc.next(); // �̸��� �Է¹޾Ƽ� ����
			String tel = sc.next(); // ��ȭ��ȣ�� �Է¹޾Ƽ� ����
			Phone phone = new Phone(name, tel); // name�� tel�� ���ڷ� �����ϴ� phone��ü ���� �� �ʱ�ȭ
			phonemanager.add(phone); // phone�� ���ڷ� �����Ͽ� phonemanager�� add�Լ� ȣ��
		}
	}

	public static void searchName(PhoneManager phonemanager, Scanner sc) { // �̸��� �˻��ϴ� �Լ�
		while (true) {
			System.out.print("�˻��� �̸�>>");
			String name = sc.next();
			if (name.equals("exit")) // name���� exit��
				break; // �ݺ��� ���� //�ݺ��� Ż��
			else {
				phonemanager.searchByName(name); // phonemanager�� searchByName�Լ� ȣ��
			}
		}
	}

}
