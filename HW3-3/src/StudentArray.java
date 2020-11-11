import java.util.Scanner;

public class StudentArray {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("�л� �� �Է�:");
		int num = sc.nextInt(); // �л��� �Է¹ޱ�
		Student student[] = new Student[num]; // ��ü �迭 ���� �� �ʱ�ȭ
		for (int i = 0; i < num; i++) { // i�� 0���� num�̸����� �ݺ�
			System.out.print(i + "��° �л� �̸��� ������ �Է��Ͻÿ�(�̸��� ������ ��ĭ���� ����):");
			String name = sc.next(); // �̸� �Է¹ޱ�
			int score = sc.nextInt(); // ���� �Է¹ޱ�
			student[i] = new Student(name, score); // ���ο� Student ��ü ���� �� student[i]�� ����
		}

		System.out.printf("%s%12s%13s%15s \n", "�б�", "�й�", "�̸�", "����");
		for (int i = 0; i < student.length; i++) {
			student[i].printStudent(); // student[i]�� printStudent�Լ� ȣ��
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
		this.name = name; // setName�Լ� ȣ��
		this.score = score; // setScore�Լ� ȣ��
		this.school = "�Ѽ����б�"; // �б��� �Ѽ����б��� �ʱ�ȭ
		this.number = count++; // �й��� count �������� ��
	}

	public String getName() { // �̸��� ��ȯ�ϴ� �Լ�
		return name;
	}

	public void setName(String name) { // �̸��� �����ϴ� �Լ�
		this.name = name;
	}

	public int getScore() { // ������ ��ȯ�ϴ� �Լ�
		return score;
	}

	public void setScore(int score) { // ������ �����ϴ� �Լ�
		this.score = score;
	}

	public void printStudent() { // ��ü���� ������ ����ϴ� �Լ�
		System.out.printf("%s%5d%10s%15d \n", school, number, getName(), getScore());
	}
}
