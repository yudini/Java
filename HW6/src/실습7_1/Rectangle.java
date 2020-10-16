package 실습7_1;

public class Rectangle {
	private int x, y, width, height;

	public Rectangle(int x, int y, int width, int height) { // x,y,width,height를 매개변수로 받는 생성자
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	public String toString() { // x,y,width,height를 문자열로 바꿔주는 함수
		return "x=" + getX() + ", y=" + getY() + ", width=" + getWidth() + ", height=" + getHeight();
	}

	public boolean equals(Rectangle r) { // 매개변수로 받은 객체와 현재 객체가 동일한지 비교하는 함수
		if (x == r.x && y == r.y && width == r.width && height == r.height)
			return true;
		else
			return false;
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

	public int getWidth() {// width를 반환하는 함수
		return width;
	}

	public void setWidth(int width) {// width를 설정하는 함수
		this.width = width;
	}

	public int getHeight() {// height를 반환하는 함수
		return height;
	}

	public void setHeight(int height) {// height를 설정하는 함수
		this.height = height;
	}

}
