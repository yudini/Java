package 실습7_2;

public class Shape {
	private int x, y;

	public Shape() {

	}

	public Shape(int x, int y) {// x와 y를 매개변수로 받는 생성자
		this.x = x;
		this.y = y;
	}

	public int getX() { // x를 반환하는 함수
		return x;
	}

	public void setX(int x) { // x를 설정하는 함수
		this.x = x;
	}

	public int getY() {// y를 반환하는 함수
		return y;
	}

	public void setY(int y) {// y를 설정하는 함수
		this.y = y;
	}
}
