package 실습7_2;

public class Rectangle extends Shape { // Shape 클래스를 상속받는 Rectangle 클래스
	private int width, height;

	public Rectangle(int x, int y, int width, int height) {// x,y,width,height를 매개변수로 받는 생성자
		super(x, y); // x와 y를 인자로 전달하여 슈퍼클래스의 생성자 호출
		this.width = width;
		this.height = height;
	}

	public String toString() {// x,y,width,height를 문자열로 바꿔주는 함수
		return "x=" + getX() + ", y=" + getY() + ", width=" + getWidth() + ", height=" + getHeight();
	}

	public boolean equals(Rectangle r) {// 매개변수로 받은 객체와 현재 객체가 동일한지 비교하는 함수
		if (getX() == r.getX() && getY() == r.getY() && width == r.width && height == r.height)
			return true;
		else
			return false;
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
