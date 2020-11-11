import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FigureEditor extends JFrame {

	FigureEditor() {
		setTitle("MyFrame");
		A panel1 = new A();
		C panel2 = new C();
		Container con = getContentPane(); // 컨텐츠팬 알아내기
		con.setLayout(new BorderLayout()); // 컨탠츠팬에 배치관리자 생성

		con.add(panel1, BorderLayout.CENTER); // panel1을 center에 달기
		con.add(panel2, BorderLayout.WEST); // panel2를 west에 달기

		setSize(600, 300); // 프레임 크기 설정
		setVisible(true); // 화면에 프레임 출력
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new FigureEditor();
	}

}

class A extends JPanel { // JPanel을 상속받는 A클래스
	 static JLabel la; // static으로 선언된 JLabel

	A() {
		setBackground(Color.YELLOW); // 배경을 yellow로 설정
		la = new JLabel("사각"); // "사각"이라고 적힌 라벨 달기
		add(la);
		addMouseListener(new MyMouseListener());// MouseListener 리스너 등록
		addMouseMotionListener(new MyMouseListener());// MouseMotionListener 리스너 등록
	}

	// Mouse 리스너와 MouseMoiton리스너를 모두 가진 리스너 작성
	class MyMouseListener implements MouseListener, MouseMotionListener {
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
	B() {
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
	public class MyActionListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton) e.getSource();
			if (b.getText().equals("사각")) // 버튼의 텍스트 값이 '사각'일때
				A.la.setText("사각"); // A클래스의 la의 텍스트 값을 '사각'으로 설정
			else if (b.getText().equals("직선")) // 버튼의 텍스트 값이 '직선'일때
				A.la.setText("직선"); // A클래스의 la의 텍스트 값을 '직선'으로 설정
			else
				A.la.setText("타원");// A클래스의 la의 텍스트 값을 '타원'으로 설정

		}
	}
}

class C extends JPanel { // JPanel을 상속받는 C클래스
	C() {
		add(new B());
	}
}