package �ǽ�7_2;

public class FigureEditor {
	private Rectangle rectangles[]; // Rectangle ��ü�迭 rectangles ����
	private Circle circles[];// Circle ��ü�迭 circles ����
	private int numOfRec, numOfCircle; // �迭�� ����� Rectangle ��ü�� ��, �迭�� ����� Circle��ü�� ��

	public FigureEditor() {
		numOfRec=numOfCircle= 0;
		rectangles = new Rectangle[10]; // Rectangle ��ü �迭 �ʱ�ȭ
		circles = new Circle[10]; // Circle��ü �迭 �ʱ�ȭ
	}

	public void add(Rectangle r) { // �Ű������� ���� Rectangle��ü�� Circle ��ü�迭�� �����ϴ� �Լ�
		boolean b = false;
		for (int i = 0; i < numOfRec; i++) {
			if (rectangles[i].equals(r)) { // rectangles[i]�� r�� �����ϸ�
				b = true; // b�� true��
				break; // �ݺ��� Ż��
			}
		}

		if (!b) {
			rectangles[numOfRec++] = r; // rectangles�� r ���� �� numOfRec ����
		}
	}

	public void add(Circle c) { // �Ű������� ���� Circle ��ü�� Circle ��ü�迭�� �����ϴ� �Լ�
		boolean b = false;
		for (int i = 0; i < numOfCircle; i++) {
			if (circles[i].equals(c)) { // circles[i]�� c�� �����ϸ�
				b = true;
				break; // �ݺ��� Ż��
			}
		}

		if (!b) {
			circles[numOfCircle++] = c; // circles�� c ���� �� numOfCircle ����
		}
	}

	public void display() { // �迭�� ����� ��� ������ ����ϴ� �Լ�
		System.out.println("-------------Rectangles-----------");
		for (int i = 0; i < numOfRec; i++)
			System.out.println(rectangles[i].toString());
		System.out.println("--------------Circles-------------");
		for (int i = 0; i < numOfCircle; i++)
			System.out.println(circles[i].toString());
	}
}
