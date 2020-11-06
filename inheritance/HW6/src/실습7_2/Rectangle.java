package �ǽ�7_2;

public class Rectangle extends Shape { // Shape Ŭ������ ��ӹ޴� Rectangle Ŭ����
	private int width, height;

	public Rectangle(int x, int y, int width, int height) {// x,y,width,height�� �Ű������� �޴� ������
		super(x, y); // x�� y�� ���ڷ� �����Ͽ� ����Ŭ������ ������ ȣ��
		this.width = width;
		this.height = height;
	}

	public String toString() {// x,y,width,height�� ���ڿ��� �ٲ��ִ� �Լ�
		return "x=" + getX() + ", y=" + getY() + ", width=" + getWidth() + ", height=" + getHeight();
	}

	public boolean equals(Rectangle r) {// �Ű������� ���� ��ü�� ���� ��ü�� �������� ���ϴ� �Լ�
		if (getX() == r.getX() && getY() == r.getY() && width == r.width && height == r.height)
			return true;
		else
			return false;
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
