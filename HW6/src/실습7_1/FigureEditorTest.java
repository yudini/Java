package 실습7_1;

public class FigureEditorTest {
	public static void main(String[] args) {
		FigureEditor editor = new FigureEditor(); // FigureEditor 객체 editor선언 및 초기화
		Rectangle r1 = new Rectangle(1, 2, 3, 4); // Rectangle 객체 r1 선언 및 초기화
		Rectangle r2 = new Rectangle(2, 3, 4, 5); // Rectangle 객체 r2 선언 및 초기화
		Circle c1 = new Circle(3, 4, 5); // Circle 객체 c1 선언 및 초기화
		Circle c2 = new Circle(4, 5, 6);// Circle 객체 c2 선언 및 초기화
		editor.add(r1); // r1을 인자로 전달하여 add함수 호출
		editor.add(r2);// r2을 인자로 전달하여 add함수 호출
		editor.add(c1);// c1을 인자로 전달하여 add함수 호출
		editor.add(c2); // c2을 인자로 전달하여 add함수 호출
		editor.display(); // display함수 호출
		Rectangle r3 = new Rectangle(2, 3, 4, 5);
		editor.add(r3); // r2와 동일한 Rectangle 객체 추가 시도
		editor.display();// display함수 호출
		r3.setX(1);// r3의 x값을 1로 설정
		editor.add(r3); // (x=1, y=3, width=4, height=5) 추가
		Circle c3 = new Circle(4, 5, 6);
		editor.add(c3); // c2와 동일한 Circle 객체 추가 시도
		editor.display();// display함수 호출
	}
}
