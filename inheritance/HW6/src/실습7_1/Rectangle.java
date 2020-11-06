package �ǽ�7_1;

public class Rectangle {
	private int x, y, width, height;

	public Rectangle(int x, int y, int width, int height) { // x,y,width,height�� �Ű������� �޴� ������
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	public String toString() { // x,y,width,height�� ���ڿ��� �ٲ��ִ� �Լ�
		return "x=" + getX() + ", y=" + getY() + ", width=" + getWidth() + ", height=" + getHeight();
	}

	public boolean equals(Rectangle r) { // �Ű������� ���� ��ü�� ���� ��ü�� �������� ���ϴ� �Լ�
		if (x == r.x && y == r.y && width == r.width && height == r.height)
			return true;
		else
			return false;
	}

	public int getX() { // x�� ��ȯ�ϴ� �Լ�
		return x;
	}

	public void setX(int x) { // x�� �����ϴ� �Լ�
		this.x = x;
	}

	public int getY() {// y�� ��ȯ�ϴ� �Լ�
		return y;
	}

	public void setY(int y) {// y�� �����ϴ� �Լ�
		this.y = y;
	}

	public int getWidth() {// width�� ��ȯ�ϴ� �Լ�
		return width;
	}

	public void setWidth(int width) {// width�� �����ϴ� �Լ�
		this.width = width;
	}

	public int getHeight() {// height�� ��ȯ�ϴ� �Լ�
		return height;
	}

	public void setHeight(int height) {// height�� �����ϴ� �Լ�
		this.height = height;
	}

}
