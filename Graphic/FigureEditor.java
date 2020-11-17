import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class FigureEditor extends JFrame {

	FigureEditor() {
		setTitle("MyFrame");
		A panelA = new A();
		C panelC = new C(panelA);
		Container con = getContentPane(); // �������� �˾Ƴ���
		con.setLayout(new BorderLayout()); // �������ҿ� ��ġ������ ����

		con.add(panelA, BorderLayout.CENTER); // panel1�� center�� �ޱ�
		con.add(panelC, BorderLayout.WEST); // panel2�� west�� �ޱ�

		setSize(600, 300); // ������ ũ�� ����
		setVisible(true); // ȭ�鿡 ������ ���
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new FigureEditor();
	}

}

class A extends JPanel { // JPanel�� ��ӹ޴� AŬ����
	private Point start = null, end = null;
	String str = "";

	ArrayList<Shape> shapes = new ArrayList<Shape>(); // shapeŸ�Ը� �ٷ�� ArrayList�� shapes����

	A() {
		setBackground(Color.YELLOW); // ����� yellow�� ����
		MyMouseListener listener = new MyMouseListener();

		addMouseListener(listener);
		addMouseMotionListener(listener);
	}

	class MyMouseListener extends MouseAdapter {
		public void mousePressed(MouseEvent e) {
			start = e.getPoint();
		}

		public void mouseDragged(MouseEvent e) {
			end = e.getPoint();
			repaint();
		}

		public void mouseReleased(MouseEvent e) {
			end = e.getPoint();
			int x = Math.min(start.x, end.x); // �� �� �� ���� ���� x�� ����
			int y = Math.min(start.y, end.y); // �� �� �� ���� ���� y�� ����
			int width = Math.abs(start.x - end.x); // start.x���� end.x�� ������ ���� ����
			int height = Math.abs(start.y - end.y); // start.y���� end.y�� ������ ���� ����

			if (str.equals("�簢")) {
				Shape s = new Rectangle(x, y, width, height); // ��ĳ����
				shapes.add(s); // shapes�� s �߰�
			} else if (str.equals("����")) {
				Shape s = new Line(start.x, start.y, end.x, end.y); // ��ĳ����
				shapes.add(s); // shapes�� s �߰�
			} else if (str.equals("Ÿ��")) {
				Shape s = new Circle(x, y, width, height); // ��ĳ����
				shapes.add(s); // shapes�� s �߰�
			}

		}

	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (start == null)
			return;
		g.setColor(Color.BLUE);
		int x = Math.min(start.x, end.x); // �� �� �� ���� ���� x�� ����
		int y = Math.min(start.y, end.y); // �� �� �� ���� ���� y�� ����
		int width = Math.abs(start.x - end.x); // start.x���� end.x�� ������ ���� ����
		int height = Math.abs(start.y - end.y); // start.y���� end.y�� ������ ���� ����
		if (str.equals("�簢"))
			g.drawRect(x, y, width, height);
		else if (str.equals("����"))
			g.drawLine(start.x, start.y, end.x, end.y);
		else if (str.equals("Ÿ��"))
			g.drawOval(x, y, width, height);

		for (int i = 0; i < shapes.size(); i++) {
			if (shapes.get(i) instanceof Rectangle) { // shapes.get(i)�� Rectangle��ü�̸�
				Rectangle r = (Rectangle) shapes.get(i); // shapes.get(i)�ٿ�ĳ����
				x = r.x;
				y = r.y;
				width = r.width;
				height = r.height;
				g.drawRect(x, y, width, height); // �簢�� �׸���
			} else if (shapes.get(i) instanceof Line) { // shapes.get(i)��Line��ü�̸�
				Line l = (Line) shapes.get(i); // shapes.get(i)�ٿ�ĳ����
				x = l.x;
				y = l.y;
				int x2 = l.x2;
				int y2 = l.y2;
				g.drawLine(x, y, x2, y2); // ���� �׸���

			} else {
				Circle c = (Circle) shapes.get(i); // shapes.get(i)�ٿ�ĳ����
				x = c.x;
				y = c.y;
				width = c.width;
				height = c.height;
				g.drawOval(x, y, width, height); // Ÿ�� �׸���
			}
		}

	}

}

class Shape {
	int x, y;
}

class Rectangle extends Shape { // ShapeŬ������ ��ӹ޴� Rectangle Ŭ����
	int width, height;

	Rectangle(int x, int y, int width, int height) { // Rectangle ������
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
}

class Line extends Shape { // ShapeŬ������ ��ӹ޴� Line Ŭ����
	int x2, y2;

	Line(int x, int y, int x2, int y2) {
		this.x = x;
		this.y = y;
		this.x2 = x2;
		this.y2 = y2;
	}
}

class Circle extends Shape { // ShapeŬ������ ��ӹ޴� Circle Ŭ����
	int width, height;

	Circle(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

}

class B extends JPanel { // JPanel�� ��ӹ޴� BŬ����
	A a = new A();

	B(A a) { // AŬ������ �Ķ���ͷ� �޴� B������
		this.a = a;
		setBackground(Color.BLUE); // ����� blue�� ����
		setLayout(new GridLayout(3, 1, 5, 5)); // ��ġ������ ����
		JButton square = new JButton("�簢"); // JButton square����
		JButton straight = new JButton("����"); // JButton straight����
		JButton circle = new JButton("Ÿ��"); // JButton circle����
		square.addActionListener(new MyActionListener()); // square�� ActionListener�ޱ�
		straight.addActionListener(new MyActionListener());// straight�� ActionListener�ޱ�
		circle.addActionListener(new MyActionListener());// circle�� ActionListener�ޱ�

		add(square); // square ��ư �ޱ�
		add(straight); // straight ��ư �ޱ�
		add(circle); // circle ��ư �ޱ�

	}

	// ActionListener ����
	private class MyActionListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			a.str = e.getActionCommand();// ��ư�� text������ a�� str�� ����
		}
	}
}

class C extends JPanel { // JPanel�� ��ӹ޴� CŬ����
	C(A a) { // AŬ������ �Ķ���ͷ� �޴� C������
		add(new B(a));
	}
}
