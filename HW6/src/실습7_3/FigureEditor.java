package 실습7_3;

public class FigureEditor {
	private Shape shapes[]; // Shape 객체 배열 shape 선언
	private int numOfShape; // 배열에 저장된 Shape 객체의 수
	private int count;

	public FigureEditor() {
		count = 0;
		shapes = new Shape[10]; // Shape객체 배열 초기화
	}

	public void add(Shape s) { // 매개변수로 받은 Shape객체를 Shape 객체배열에 저장하는 함수
		boolean b = false;
		if (s instanceof Rectangle) // s객체가 Rectangle이면
			for (int i = 0; i < count; i++) {
				if (shapes[i] instanceof Rectangle) { // shapes[i]객체가 Rectangle이면
					if (((Rectangle) shapes[i]).equals((Rectangle) s)) { // 다운캐스팅된 shapes[i]와 다운캐스팅된s가 동일하면
						b = true;
						break; // 반복문 탈출
					}
				}
			}
		else {
			for (int i = 0; i < count; i++) {// s객체가 Circle이면
				if (shapes[i] instanceof Circle)// shapes[i]객체가 Circle이면
					if (((Circle) shapes[i]).equals((Circle) s)) {// 다운캐스팅된 shapes[i]와 다운캐스팅된s가 동일하면
						b = true;
						break;// 반복문 탈출
					}
			}
		}

		if (!b) {
			shapes[count++] = s;// shapes에 s 저장 후 count 증가
			numOfShape = count;// shapes배열에 저장된 객체 수
		}
	}

	public void display() {// 배열에 저장된 모든 정보를 출력하는 함수
		System.out.println("-------------Shapes-----------");
		for (int i = 0; i < numOfShape; i++)
			System.out.println(shapes[i].toString());
	}
}
