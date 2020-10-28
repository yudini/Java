package �ǽ�8_2;

public class ShapePanel {
	private Shape shapes[]; // Shape ��ü �迭 shape ����
	private int numOfShape; // �迭�� ����� Shape ��ü�� ��

	public ShapePanel() {
		numOfShape = 0;
		shapes = new Shape[10]; // Shape��ü �迭 �ʱ�ȭ
	}

	public void add(Shape s) { // �Ű������� ���� Shape��ü�� Shape ��ü�迭�� �����ϴ� �Լ�
		boolean b = false;
		for (int i = 0; i < numOfShape; i++) {
			if (shapes[i].equals(s)) {
				b = true;
				break; // �ݺ��� Ż��
			}
		}

		if (!b) {
			shapes[numOfShape++] = s;// shapes�� s ���� �� numOfShape ����
		}
	}

	public void delete(Shape s) {
		boolean b = false;
		int count = 0;
		for (int i = 0; i < numOfShape; i++) {
			if (shapes[i].equals(s)) {
				count = i;
				numOfShape = numOfShape - 1;
				break;
			}
		}
		if (!b) {
			for (int i = count; i < numOfShape; i++)
				shapes[i] = shapes[i + 1];
		}
	}

	public void display() {// �迭�� ����� ��� ������ ����ϴ� �Լ�
		System.out.println("-------------Shapes-----------");
		for (int i = 0; i < numOfShape; i++)
			System.out.println(shapes[i].toString());
	}
}
