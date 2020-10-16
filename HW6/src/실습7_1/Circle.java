package �ǽ�7_1;

public class Circle {
	private int x, y, radius;

	public Circle(int x, int y, int radius) { // x,y,radius�� �Ű������� �޴� ������
		this.x = x;
		this.y = y;
		this.radius = radius;
	}

	public String toString() { // x,y,radius ���� ���ڿ��� �ٲ��ִ� �Լ�
		return "x=" + getX() + ", y=" + getY() + ", radius=" + getRadius();
	}

	public boolean equals(Circle c) { // �Ű������� ���� c��ü�� ���簴ü�� �������� ���ϴ� �Լ�
		if (x == c.x && y == c.y && radius == c.radius)
			return true;
		else
			return false;
	}

	public int getX() { // x�� ��ȯ�ϴ� �Լ�
		return x;
	}

	public void setX(int x) {// x�� �����ϴ� �Լ�
		this.x = x;
	}

	public int getY() {// y�� ��ȯ�ϴ� �Լ�
		return y;
	}

	public void setY(int y) {// y�� �����ϴ� �Լ�
		this.y = y;
	}

	public int getRadius() {// radius�� ��ȯ�ϴ� �Լ�
		return radius;
	}

	public void setRadius(int radius) { // radius�� �����ϴ� �Լ�
		this.radius = radius;
	}

}
