import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

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
	 JLabel la;  // 전역변수로 선언된 JLabel

	A() {
		setBackground(Color.YELLOW); // 배경을 yellow로 설정
		la = new JLabel("사각"); // "사각"이라고 적힌 라벨 달기
		add(la);
		addMouseListener(new MyMouseListener());// MouseListener 리스너 등록
		addMouseMotionListener(new MyMouseListener());// MouseMotionListener 리스너 등록
	}

	// Mouse 리스너와 MouseMoiton리스너를 모두 가진 리스너 작성
	private class MyMouseListener implements MouseListener, MouseMotionListener {
		// MouseListener의 5개 메소드 구현
		public void mousePressed(MouseEvent e) { // 마우스가 눌러진 위치(x,y)점 출력
			la.setLocation(e.getX(), e.getY());
		}

		public void mouseReleased(MouseEvent e) {// 마우스가 떼어진 위치(x,y)점 출력
			la.setLocation(e.getX(), e.getY());
		}

		public void mouseClicked(MouseEvent e) { // 마우스가 클릭된 순간 위치 (x,y)점 출력
			la.setLocation(e.getX(), e.getY());
		}

		public void mouseEntered(MouseEvent e) {
		}

		public void mouseExited(MouseEvent e) {
		}

		// MouseMotionListener의 2개 메소드 구현
		public void mouseDragged(MouseEvent e) { // 마우스가 드래깅되는 동안 호출
			la.setLocation(e.getX(), e.getY());
		}

		public void mouseMoved(MouseEvent e) {
		}

	}

}

class B extends JPanel { // JPanel을 상속받는 B클래스
	A a=new A();    //A클래스 객체 a 선언 및 생성
	B(A a) {   //A클래스를 파라미터로 받는 B생성자
		this.a=a;
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
			a.la.setText(e.getActionCommand());//버튼의 text값으로 라벨의 값을 설정
		}
	}
}

class C extends JPanel { // JPanel을 상속받는 C클래스
	C(A a) { //A클래스를 파라미터로 받는 C생성자
		add(new B(a));
	}
}
