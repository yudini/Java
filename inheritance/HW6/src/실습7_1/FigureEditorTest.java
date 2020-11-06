package �ǽ�7_1;

public class FigureEditorTest {
	public static void main(String[] args) {
		FigureEditor editor = new FigureEditor(); // FigureEditor ��ü editor���� �� �ʱ�ȭ
		Rectangle r1 = new Rectangle(1, 2, 3, 4); // Rectangle ��ü r1 ���� �� �ʱ�ȭ
		Rectangle r2 = new Rectangle(2, 3, 4, 5); // Rectangle ��ü r2 ���� �� �ʱ�ȭ
		Circle c1 = new Circle(3, 4, 5); // Circle ��ü c1 ���� �� �ʱ�ȭ
		Circle c2 = new Circle(4, 5, 6);// Circle ��ü c2 ���� �� �ʱ�ȭ
		editor.add(r1); // r1�� ���ڷ� �����Ͽ� add�Լ� ȣ��
		editor.add(r2);// r2�� ���ڷ� �����Ͽ� add�Լ� ȣ��
		editor.add(c1);// c1�� ���ڷ� �����Ͽ� add�Լ� ȣ��
		editor.add(c2); // c2�� ���ڷ� �����Ͽ� add�Լ� ȣ��
		editor.display(); // display�Լ� ȣ��
		Rectangle r3 = new Rectangle(2, 3, 4, 5);
		editor.add(r3); // r2�� ������ Rectangle ��ü �߰� �õ�
		editor.display();// display�Լ� ȣ��
		r3.setX(1);// r3�� x���� 1�� ����
		editor.add(r3); // (x=1, y=3, width=4, height=5) �߰�
		Circle c3 = new Circle(4, 5, 6);
		editor.add(c3); // c2�� ������ Circle ��ü �߰� �õ�
		editor.display();// display�Լ� ȣ��
	}
}
