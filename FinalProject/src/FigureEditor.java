import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;
import java.util.*;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new FigureEditor();
	}

}

class A extends JPanel { // JPanel을 상속받는 A클래스
	private Point start = null, end = null;
	private int x3, y3;     //클릭했을 때의 좌표
	private boolean control_sw = false;    //컨트롤 포인터의 유무
	private int num = 0;           //도형이 저장된 순서
	String str = "";              //버튼의 종류

	Rectangle cp[] = new Rectangle[2];
	ArrayList<Shape> shapes = new ArrayList<Shape>(); // shape타입만 다루는 ArrayList인 shapes생성

	A() {
		setBackground(Color.YELLOW); // 배경을 yellow로 설정
		MyMouseListener listener = new MyMouseListener();

		addMouseListener(listener);
		addMouseMotionListener(listener);
		
	}

	class MyMouseListener extends MouseAdapter {
		public void mouseClicked(MouseEvent e) {  
			x3 = e.getX();
			y3 = e.getY();
		}

		public void mousePressed(MouseEvent e) {
			start = e.getPoint();
			x3 = e.getX();
			y3 = e.getY();
		}

		public void mouseDragged(MouseEvent e) {
			end = e.getPoint();
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
			repaint();
		}

	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (start == null)
			return;
		g.setColor(Color.BLACK);
		int x = Math.min(start.x, end.x); // 둘 중 더 작은 값을 x에 저장
		int y = Math.min(start.y, end.y); // 둘 중 더 작은 값을 y에 저장

		int width = Math.abs(start.x - end.x); // start.x에서 end.x를 뺀값의 절댓값 저장
		int height = Math.abs(start.y - end.y); // start.y에서 end.y를 뺀값의 절댓값 저장
		if (str.equals("사각")) {
			g.drawRect(x, y, width, height);
			control_sw = false;
		} else if (str.equals("직선")) {
			g.drawLine(start.x, start.y, end.x, end.y);
			control_sw = false;
		} else if (str.equals("타원")) {
			g.drawOval(x, y, width, height);
			control_sw = false;
		} else if (str.equals("불러오기")) {
			load();
		}

		for (int i = 0; i < shapes.size(); i++) {
			if (shapes.get(i).inside(x3, y3) == true) {  //i번째 도형 내부가 클릭되었을 때 
				if (str.equals("복사")) {           
					shapes.get(i).copy(g, shapes);   //i번째 도형 복사   
					control_sw = false;
				} else if (str.equals("삭제")) {
					shapes.remove(i);     //i번째 도형 삭제
					control_sw = false;
				} else {
					if (control_sw == true) {    //컨트롤 포인트가 있을때
						if (cp[0].inside(start.x, start.y)) { //마우스가 눌린 곳이 도형내부와 위쪽 컨트롤 포인트에 포함 될때 
							shapes.set(i, shapes.get(i).changeSize(g,end.x, end.y)); //크기 조절
						} else if (cp[1].inside(start.x, start.y)) { //마우스가 눌린 곳이 도형내부와 아래쪽 컨트롤 포인트에 포함 될때 
							shapes.set(i, shapes.get(i).changeSize2(g,end.x, end.y)); //크기 조절
						} else {  //마우스가 눌린 곳이 어느 컨트롤 포인트에도 포함되지 않을 때 
							int a = start.x - shapes.get(i).x; 
							int b = start.y - shapes.get(i).y;
							shapes.set(i, shapes.get(i).move(g,end.x, end.y, a, b));  //도형 이동
						}
						control_sw = false;   
					} else {     //컨트롤 포인트가 없을때 
						shapes.get(i).make_con(g, cp);  //도형에 컨트롤 포인트 생성    
						num = i + 1;               //컨트롤 포인트가 생성된 도형의 순서 저장(1~)
						control_sw = true;         //컨트롤 포인트 있음 
					}
				}
				break;
			} else {   //마우스가 눌린 곳이 도형내부가 아닐 때 
				if (num == i + 1) {    //컨트롤 포인트가 생성된 도형과  현재 도형이 일치할 때
					if (cp[0].inside(start.x, start.y)) {   //마우스가 눌린 곳이 위쪽 컨트롤 포인트에 포함 될때
						shapes.set(i, shapes.get(i).changeSize(g, end.x, end.y)); //크기 조절
					} else if (cp[1].inside(start.x, start.y)) { //마우스가 눌린 곳이  아래쪽 컨트롤 포인트에 포함 될때
						shapes.set(i, shapes.get(i).changeSize2(g,end.x, end.y)); //크기 조절
					}
					control_sw = false;
				}
			}
		}

		for (int i = 0; i < shapes.size(); i++)
			shapes.get(i).draw(g);    //저장된 도형 모두 그리기 

		str = "";   //눌린 버튼 초기화
	}
	
	public void save() {  //그림판을 저장하는 함수
		// TODO Auto-generated method stub
		ObjectOutputStream out = null;
		try {
			out = new ObjectOutputStream(new ObjectOutputStream(new FileOutputStream("data.dat")));
			out.writeObject(shapes); // shape 저장
			out.close();
			System.out.println("저장되었습니다.");
		} catch (FileNotFoundException e) {  //예외처리
			System.out.println("에러");
		} catch (IOException e) {   //예외처리
			System.out.println("error");
			e.printStackTrace();
		}
	}
	
	public void load() {  //저장된 그림판을 불러오는 함수
		// TODO Auto-generated method stub
		ObjectInputStream in = null;

		try {
			in = new ObjectInputStream(new ObjectInputStream(new FileInputStream("data.dat")));
			shapes = (ArrayList<Shape>) in.readObject(); //객체별로 읽어 들여 shapes에 저장
			in.close();
		} catch (IOException e) {   //예외처리 
			System.out.println("error");
		} catch (ClassNotFoundException e) { // 클래스를 못찾는 예외처리
			System.out.println("classNotFound");
		}
	}


}

abstract class Shape implements Serializable {  //직렬화된 Shape 추상화 클래스
	int x, y;

	abstract public void draw(Graphics g);  //도형그리는 함수

	abstract public boolean inside(int x3, int y3);  //클릭된 곳이 도형에 포함되는지 확인해 주는 함수

	abstract public void make_con(Graphics g, Rectangle cp[]);  //컨트롤 포인트를 만드는 함수

	abstract public void copy(Graphics g, ArrayList<Shape> shapes);  //도형을 복사하는 함수
	
	//도형을 이동하는 함수
	abstract public Shape move(Graphics g, int x, int y, int a, int b);

	//위쪽으로 도형 크기를 조절하는 함수
	abstract public Shape changeSize(Graphics g, int endX, int endY);

	//아래쪽으로 도형 크기를 조절하는 함수
	abstract public Shape changeSize2(Graphics g, int endX, int endY);
}

class Rectangle extends Shape { // Shape클래스를 상속받는 Rectangle 클래스
	int width, height;

	Rectangle(int x, int y, int width, int height) { // Rectangle 생성자
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	public void draw(Graphics g) {  //사각형 그리기
		g.drawRect(x, y, width, height); 
	}

	public void make_con(Graphics g, Rectangle cp[]) {  //컨트롤 포인트 그리기
		g.drawRect(x - 2, y - 2, 4, 4);     //왼쪽 위 모서리에 컨트롤 포인트 그리기
		g.drawRect(x + width - 2, y + height - 2, 4, 4); //오른쪽 아래 모서리에 컨트롤 포인트 그리기 
		cp[0] = new Rectangle(x - 2, y - 2, 10, 10);   //위쪽 컨트롤 포인트 저장
		cp[1] = new Rectangle(x + width - 2, y + height - 2, 4, 4);  //아래쪽 컨트롤 포인트 저장 
	}

	public boolean inside(int x3, int y3) {  //사각형 내부가 클릭됐는지 확인
		if (x3 > x && x3 < x + width && y3 > y && y3 < y + height)  //사각형 내부가 클릭되었으면
			return true;   //true 반환
		else
			return false;
	}

	public void copy(Graphics g, ArrayList<Shape> shapes) { //사각형 복사
		g.drawRect(x + 10, y + 10, width, height);   //현재 위치에 가로 10,세로10이동한 곳에 사각형 복사
		shapes.add(new Rectangle(x + 10, y + 10, width, height));  //shapes에 저장 
	}

	public Shape move(Graphics g, int x, int y, int a, int b) { //사각형 이동
		x = x - a;       //이동된 x위치 계산  
		y = y - a;     //이동된 y 위치 계산
		g.drawRect(x, y, width, height);
		return new Rectangle(x, y, width, height);
	}

	public Shape changeSize(Graphics g,int endX, int endY) { //위쪽으로 사각형 크기 조절
		width = width + x - endX;  //조절된 넓이 계산
		height = height + y - endY;  //조절된 높이 계산
		x = endX;      
		y = endY;
		g.drawRect(x, y, width, height); 
		return new Rectangle(x, y, width, height);
	}

	public Shape changeSize2(Graphics g,int endX, int endY) { //아래쪽으로 사각형 크기 조절
		width = endX - this.x;   //조절된 넓이 계산 
		height = endY - this.y;  //조절된 높이 계산
		g.drawRect(this.x, this.y, width, height);
		return new Rectangle(x, y, width, height);
	}
}

class Line extends Shape { // Shape클래스를 상속받는 Line 클래스
	int x2, y2;

	Line(int x, int y, int x2, int y2) {   //Line 생성자
		this.x = x;
		this.y = y;
		this.x2 = x2;
		this.y2 = y2;
	}

	public void draw(Graphics g) {  //직선 그리기 
		g.drawLine(x, y, x2, y2);
	}

	public boolean inside(int x3, int y3) { //도형의 내부가 클릭됐는지 확인
		if (x3 > Math.min(x, x2) && x3 < Math.max(x, x2) && y3 > Math.min(y, y2) && y3 < Math.max(y, y2))
			return true;
		else
			return false;
	}

	public void make_con(Graphics g, Rectangle cp[]) {  //컨트롤 포인트 생성
		g.drawRect(x - 2, y - 2, 4, 4);  //직선 시작점 위치에 컨트롤 포인트 그리기
		g.drawRect(x2 - 2, y2 - 2, 4, 4);  //직선 끝점 위치에 컨트롤 포인트 그리기
		cp[0] = new Rectangle(x - 2, y - 2, 4, 4); //시작점위치의 컨트롤 포인트 저장
		cp[1] = new Rectangle(x2 - 2, y2 - 2, 4, 4);   //끝점 위치의  컨트롤 포인트 저정
	}

	public void copy(Graphics g, ArrayList<Shape> shapes) {  //직선 복사
		g.drawLine(x + 10, y, x2 + 10, y2);    //현재 위치에서 가로 10만큼 이동한 곳에 직선 복사 
		shapes.add(new Line(x + 10, y, x2 + 10, y2));  //shapes에 저장
	}

	public Shape move(Graphics g, int x, int y, int a, int b) {  //직선 이동
		x = x - a;   //이동된 x 계산
		y = y - b;    //이동된 y계산
		x2 = x + x2 - this.x;
		y2 = y + y2 - this.y;
		g.drawLine(x, y, x2, y2);
		return new Line(x, y, x2, y2);
	}

	public Shape changeSize(Graphics g, int endX, int endY) {  //시작점에서부터 직선 크기 조절
		g.drawLine(endX, endY, x2, y2);
		return new Line(endX, endY, x2, y2);
	}

	public Shape changeSize2(Graphics g, int endX, int endY) { //끝점에서부터  직선 크기 조절
		g.drawLine(this.x, this.y, endX, endY);
		return new Line(x, y, endX, endY);
	}
}

class Circle extends Shape { // Shape클래스를 상속받는 Circle 클래스
	int width, height;

	Circle(int x, int y, int width, int height) {   //Circle생성자
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	public void draw(Graphics g) {  //원 그리기 
		g.drawOval(x, y, width, height);
	}

	public boolean inside(int x3, int y3) {  //원 내부가 클릭되었는지 확인
		if (x3 > x && x3 < x + width && y3 > y && y3 < y + height)  //원 내부가 클릭되었으면
			return true;  //true 반환
		else
			return false;  
	}

	public void make_con(Graphics g, Rectangle cp[]) {  //컨트롤 포인트 생성
		g.drawRect(x, y, 4, 4);     //왼쪽 위 모서리에 컨트롤 포인트 그리기
		g.drawRect(x + width - 4, y + height - 4, 4, 4); //오른쪽 아래 모서리에 컨트롤 포인트 그리기
		cp[0] = new Rectangle(x, y, 4, 4); //위쪽 컨트롤 포인트 저장
		cp[1] = new Rectangle(x + width - 4, y + height - 4, 4, 4);  //아래쪽 컨트롤 포인트 저장
	}

	public void copy(Graphics g, ArrayList<Shape> shapes) {   //원 복사
		g.drawOval(x + 10, y + 10, width, height);   //현재 위치에 가로 10,세로10이동한 곳에 사각형 복사
		shapes.add(new Circle(x + 10, y + 10, width, height)); //shapes에 저장
	}

	public Shape move(Graphics g,  int x, int y, int a, int b) { //원 이동
		x = x - a;
		y = y - a;
		g.drawOval(x, y, width, height);
		return new Circle(x, y, width, height);
	}

	public Shape changeSize(Graphics g, int endX, int endY) {  //위쪽으로 원 크기 조절
		width = width + x - endX;
		height = height + y - endY;
		x = endX;
		y = endY;
		g.drawOval(x, y, width, height);
		return new Circle(x, y, width, height);
	}

	public Shape changeSize2(Graphics g, int endX, int endY) {  //아래쪽으로 원 크기 조절
		width = endX - x;
		height = endY - y;
		g.drawOval(x, y, width, height);
		return new Circle(x, y, width, height);
	}

}

class B extends JPanel { // JPanel을 상속받는 B클래스
	A a = new A();

	B(A a) { // A클래스를 파라미터로 받는 B생성자
		this.a = a;
		setBackground(Color.BLUE); // 배경을 blue로 설정
		setLayout(new GridLayout(7, 1, 5, 5)); // 배치관리자 생성
		JButton square = new JButton("사각"); // JButton square생성
		JButton straight = new JButton("직선"); // JButton straight생성
		JButton circle = new JButton("타원"); // JButton circle생성
		JButton copy = new JButton("복사"); // JButton copy생성
		JButton delete = new JButton("삭제"); // JButton delete생성
		JButton save = new JButton("저장"); // JButton save생성
		JButton load = new JButton("불러오기"); // JButton load생성
		square.addActionListener(new MyActionListener()); // square에 ActionListener달기
		straight.addActionListener(new MyActionListener());// straight에 ActionListener달기
		circle.addActionListener(new MyActionListener());// circle에 ActionListener달기
		copy.addActionListener(new MyActionListener()); // copy에 ActionListener달기
		delete.addActionListener(new MyActionListener()); // delete에 ActionListener달기
		save.addActionListener(new MyActionListener()); // save에 ActionListener달기
		load.addActionListener(new MyActionListener()); // load에 ActionListener달기

		add(square); // square 버튼 달기
		add(straight); // straight 버튼 달기
		add(circle); // circle 버튼 달기
		add(copy);   //copy버튼 달기
		add(delete);  //delete 버튼 달기
		add(save);  //save버튼 달기
		add(load);   //load버튼 달기

	}

	// ActionListener 구현
	private class MyActionListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			if(e.getActionCommand().equals("저장"))
				a.save();
			a.str = e.getActionCommand();// 버튼의 text값으로 a의 str을 설정
		}
	}
}

class C extends JPanel { // JPanel을 상속받는 C클래스
	C(A a) { // A클래스를 파라미터로 받는 C생성자
		add(new B(a));
	}
}