package �ǽ�7_3;

public class FigureEditor {
	private Shape shapes[]; // Shape ��ü �迭 shape ����
	private int numOfShape; // �迭�� ����� Shape ��ü�� ��
	private int count;

	public FigureEditor() {
		count = 0;
		shapes = new Shape[10]; // Shape��ü �迭 �ʱ�ȭ
	}

	public void add(Shape s) { // �Ű������� ���� Shape��ü�� Shape ��ü�迭�� �����ϴ� �Լ�
		boolean b = false;
		if (s instanceof Rectangle) // s��ü�� Rectangle�̸�
			for (int i = 0; i < count; i++) {
				if (shapes[i] instanceof Rectangle) { // shapes[i]��ü�� Rectangle�̸�
					if (((Rectangle) shapes[i]).equals((Rectangle) s)) { // �ٿ�ĳ���õ� shapes[i]�� �ٿ�ĳ���õ�s�� �����ϸ�
						b = true;
						break; // �ݺ��� Ż��
					}
				}
			}
		else {
			for (int i = 0; i < count; i++) {// s��ü�� Circle�̸�
				if (shapes[i] instanceof Circle)// shapes[i]��ü�� Circle�̸�
					if (((Circle) shapes[i]).equals((Circle) s)) {// �ٿ�ĳ���õ� shapes[i]�� �ٿ�ĳ���õ�s�� �����ϸ�
						b = true;
						break;// �ݺ��� Ż��
					}
			}
		}

		if (!b) {
			shapes[count++] = s;// shapes�� s ���� �� count ����
			numOfShape = count;// shapes�迭�� ����� ��ü ��
		}
	}

	public void display() {// �迭�� ����� ��� ������ ����ϴ� �Լ�
		System.out.println("-------------Shapes-----------");
		for (int i = 0; i < numOfShape; i++)
			System.out.println(shapes[i].toString());
	}
}
