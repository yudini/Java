import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class FigureEditor extends JFrame {

	FigureEditor() {
		setTitle("MyFrame");
		A panelA = new A();
		C panelC = new C(panelA);
		Container con = getContentPane(); // 컨텐츠팬 알아내기
		con.setLayout(new BorderLayout()); // 컨탠츠팬에 배치관리자 생성

		con.add(panelA, BorderLayout.CENTER); // panel1을 center에 달기
		con.add(panelC, BorderLayout.WEST); // panel2를 west에 달기

		setSize(600, 300); // 프레임 크기 설정
		setVisible(true); // 화면에 프레임 출력
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new FigureEditor();
	}

}

class A extends JPanel { // JPanel을 상속받는 A클래스
	private Point start = null, end = null;
	String str = "";

	ArrayList<Shape> shapes = new ArrayList<Shape>(); // shape타입만 다루는 ArrayList인 shapes생성

	A() {
		setBackground(Color.YELLOW); // 배경을 yellow로 설정
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
			int x = Math.min(start.x, end.x); // 둘 중 더 작은 값을 x에 저장
			int y = Math.min(start.y, end.y); // 둘 중 더 작은 값을 y에 저장
			int width = Math.abs(start.x - end.x); // start.x에서 end.x를 뺀값의 절댓값 저장
			int height = Math.abs(start.y - end.y); // start.y에서 end.y를 뺀값의 절댓값 저장

			if (str.equals("사각")) {
				Shape s = new Rectangle(x, y, width, height); // 업캐스팅
				shapes.add(s); // shapes에 s 추가
			} else if (str.equals("직선")) {
				Shape s = new Line(start.x, start.y, end.x, end.y); // 업캐스팅
				shapes.add(s); // shapes에 s 추가
			} else if (str.equals("타원")) {
				Shape s = new Circle(x, y, width, height); // 업캐스팅
				shapes.add(s); // shapes에 s 추가
			}

		}

	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (start == null)
			return;
		g.setColor(Color.BLUE);
		int x = Math.min(start.x, end.x); // 둘 중 더 작은 값을 x에 저장
		int y = Math.min(start.y, end.y); // 둘 중 더 작은 값을 y에 저장
		int width = Math.abs(start.x - end.x); // start.x에서 end.x를 뺀값의 절댓값 저장
		int height = Math.abs(start.y - end.y); // start.y에서 end.y를 뺀값의 절댓값 저장
		if (str.equals("사각"))
			g.drawRect(x, y, width, height);
		else if (str.equals("직선"))
			g.drawLine(start.x, start.y, end.x, end.y);
		else if (str.equals("타원"))
			g.drawOval(x, y, width, height);

		for (int i = 0; i < shapes.size(); i++) {
			if (shapes.get(i) instanceof Rectangle) { // shapes.get(i)가 Rectangle객체이면
				Rectangle r = (Rectangle) shapes.get(i); // shapes.get(i)다운캐스팅
				x = r.x;
				y = r.y;
				width = r.width;
				height = r.height;
				g.drawRect(x, y, width, height); // 사각형 그리기
			} else if (shapes.get(i) instanceof Line) { // shapes.get(i)가Line객체이면
				Line l = (Line) shapes.get(i); // shapes.get(i)다운캐스팅
				x = l.x;
				y = l.y;
				int x2 = l.x2;
				int y2 = l.y2;
				g.drawLine(x, y, x2, y2); // 직선 그리기

			} else {
				Circle c = (Circle) shapes.get(i); // shapes.get(i)다운캐스팅
				x = c.x;
				y = c.y;
				width = c.width;
				height = c.height;
				g.drawOval(x, y, width, height); // 타원 그리기
			}
		}

	}

}

class Shape {
	int x, y;
}

class Rectangle extends Shape { // Shape클래스를 상속받는 Rectangle 클래스
	int width, height;

	Rectangle(int x, int y, int width, int height) { // Rectangle 생성자
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
}

class Line extends Shape { // Shape클래스를 상속받는 Line 클래스
	int x2, y2;

	Line(int x, int y, int x2, int y2) {
		this.x = x;
		this.y = y;
		this.x2 = x2;
		this.y2 = y2;
	}
}

class Circle extends Shape { // Shape클래스를 상속받는 Circle 클래스
	int width, height;

	Circle(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

}

class B extends JPanel { // JPanel을 상속받는 B클래스
	A a = new A();

	B(A a) { // A클래스를 파라미터로 받는 B생성자
		this.a = a;
		setBackground(Color.BLUE); // 배경을 blue로 설정
		setLayout(new GridLayout(3, 1, 5, 5)); // 배치관리자 생성
		JButton square = new JButton("사각"); // JButton square생성
		JButton straight = new JButton("직선"); // JButton straight생성
		JButton circle = new JButton("타원"); // JButton circle생성
		square.addActionListener(new MyActionListener()); // square에 ActionListener달기
		straight.addActionListener(new MyActionListener());// straight에 ActionListener달기
		circle.addActionListener(new MyActionListener());// circle에 ActionListener달기

		add(square); // square 버튼 달기
		add(straight); // straight 버튼 달기
		add(circle); // circle 버튼 달기

	}

	// ActionListener 구현
	private class MyActionListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			a.str = e.getActionCommand();// 버튼의 text값으로 a의 str을 설정
		}
	}
}

class C extends JPanel { // JPanel을 상속받는 C클래스
	C(A a) { // A클래스를 파라미터로 받는 C생성자
		add(new B(a));
	}
}
