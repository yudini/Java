package 실습7_1;

public class Circle {
	private int x, y, radius;

	public Circle(int x, int y, int radius) { // x,y,radius를 매개변수로 받는 생성자
		this.x = x;
		this.y = y;
		this.radius = radius;
	}

	public String toString() { // x,y,radius 값을 문자열로 바꿔주는 함수
		return "x=" + getX() + ", y=" + getY() + ", radius=" + getRadius();
	}

	public boolean equals(Circle c) { // 매개변수로 받은 c객체와 현재객체가 동일한지 비교하는 함수
		if (x == c.x && y == c.y && radius == c.radius)
			return true;
		else
			return false;
	}

	public int getX() { // x를 반환하는 함수
		return x;
	}

	public void setX(int x) {// x를 설정하는 함수
		this.x = x;
	}

	public int getY() {// y를 반환하는 함수
		return y;
	}

	public void setY(int y) {// y를 설정하는 함수
		this.y = y;
	}

	public int getRadius() {// radius를 반환하는 함수
		return radius;
	}

	public void setRadius(int radius) { // radius를 설정하는 함수
		this.radius = radius;
	}

}
