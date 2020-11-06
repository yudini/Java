package 실습8_2;

public class ShapePanel {
	private Shape shapes[]; // Shape 객체 배열 shape 선언
	private int numOfShape; // 배열에 저장된 Shape 객체의 수

	public ShapePanel() {
		numOfShape = 0;
		shapes = new Shape[10]; // Shape객체 배열 초기화
	}

	public void add(Shape s) { // 매개변수로 받은 Shape객체를 Shape 객체배열에 저장하는 함수
		boolean b = false;
		for (int i = 0; i < numOfShape; i++) {
			if (shapes[i].equals(s)) {
				b = true;
				break; // 반복문 탈출
			}
		}

		if (!b) {
			shapes[numOfShape++] = s;// shapes에 s 저장 후 numOfShape 증가
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

	public void display() {// 배열에 저장된 모든 정보를 출력하는 함수
		System.out.println("-------------Shapes-----------");
		for (int i = 0; i < numOfShape; i++)
			System.out.println(shapes[i].toString());
	}
}
