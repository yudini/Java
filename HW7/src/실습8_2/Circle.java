package 실습8_2;


public class Circle extends Shape {// Shape클래스를 상속받는 Circle 클래스
	private int radius;

	public Circle(int x, int y, int radius) {// x,y,radius를 매개변수로 받는 생성자
		super(x, y); // x와 y를 인자로 전달하여 슈퍼클래스의 생성자 호출
		this.radius = radius;
	}

	public String toString() {// x,y,radius 값을 문자열로 바꿔주는 함수
		return "[Circle 객체]x=" + getX() + ", y=" + getY() + ", radius=" + getRadius();
	}
	
	public void display() {
		System.out.println("[Circle 객체]"+this.toString());
	}

	public boolean equals(Shape s) {// 매개변수로 받은 c객체와 현재객체가 동일한지 비교하는 함수
		if(s instanceof Circle) {
			Circle c=(Circle)s;
			if (getX() == c.getX() && getY() == c.getY() && radius == c.radius)
				return true;
			else
				return false;
		}
		else 
			return false;
	}

	public int getRadius() {// radius를 반환하는 함수
		return radius;
	}

	public void setRadius(int radius) {// radius를 설정하는 함수
		this.radius = radius;
	}

}
