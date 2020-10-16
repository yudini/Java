package 실습7_1;

public class FigureEditor {
	private Rectangle rectangles[]; // Rectangle 객체배열 rectangles 선언
	private Circle circles[];// Circle 객체배열 circles 선언
	private int numOfRec, numOfCircle; // 배열에 저장된 Rectangle 객체의 수, 배열에 저장된 Circle객체의 수
	private int count1, count2;

	public FigureEditor() {
		count1 = count2 = 0;
		rectangles = new Rectangle[10]; // Rectangle 객체 배열 초기화
		circles = new Circle[10]; // Circle객체 배열 초기화
	}

	public void add(Rectangle r) { // 매개변수로 받은 Rectangle객체를 Circle 객체배열에 저장하는 함수
		boolean b = false;
		for (int i = 0; i < count1; i++) {
			if (rectangles[i].equals(r)) { // rectangles[i]와 r이 동일하면
				b = true; // b는 true값
				break; // 반복문 탈출
			}
		}

		if (!b) {
			rectangles[count1++] = r; // rectangles에 r 저장 후 count 증가
			numOfRec = count1; // 배열에 저장된 객체 수
		}
	}

	public void add(Circle c) {// 매개변수로 받은 Circle 객체를 Circle 객체배열에 저장하는 함수
		boolean b = false;
		for (int i = 0; i < count2; i++) {
			if (circles[i].equals(c)) { // circles[i]와 c가 동일하면
				b = true;
				break; // 반복문 탈출
			}
		}

		if (!b) {
			circles[count2++] = c; // circles에 c 저장 후 count2 증가
			numOfCircle = count2; // Circle배열에 저장된 객체 수
		}
	}

	public void display() { // 배열에 저장된 모든 정보를 출력하는 함수
		System.out.println("-------------Rectangles-----------");
		for (int i = 0; i < numOfRec; i++)
			System.out.println(rectangles[i].toString());
		System.out.println("--------------Circles-------------");
		for (int i = 0; i < numOfCircle; i++)
			System.out.println(circles[i].toString());
	}
}
