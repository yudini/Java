package �ǽ�8_2;


public class Circle extends Shape {// ShapeŬ������ ��ӹ޴� Circle Ŭ����
	private int radius;

	public Circle(int x, int y, int radius) {// x,y,radius�� �Ű������� �޴� ������
		super(x, y); // x�� y�� ���ڷ� �����Ͽ� ����Ŭ������ ������ ȣ��
		this.radius = radius;
	}

	public String toString() {// x,y,radius ���� ���ڿ��� �ٲ��ִ� �Լ�
		return "[Circle ��ü]x=" + getX() + ", y=" + getY() + ", radius=" + getRadius();
	}
	
	public void display() {
		System.out.println("[Circle ��ü]"+this.toString());
	}

	public boolean equals(Shape s) {// �Ű������� ���� c��ü�� ���簴ü�� �������� ���ϴ� �Լ�
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

	public int getRadius() {// radius�� ��ȯ�ϴ� �Լ�
		return radius;
	}

	public void setRadius(int radius) {// radius�� �����ϴ� �Լ�
		this.radius = radius;
	}

}
