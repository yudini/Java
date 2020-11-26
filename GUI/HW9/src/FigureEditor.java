import javax.swing.*;
import java.awt.*;

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
	A() {
		setBackground(Color.YELLOW); // 배경을 yellow로 설정
		add(new JLabel("여기가 그래픽 객체를 그리는 곳입니다.")); // 텍스트 달기
	}

}

class B extends JPanel { // JPanel을 상속받는 B클래스
	B() {
		setBackground(Color.BLUE); // 배경을 blue로 설정
		setLayout(new GridLayout(3, 1, 5, 5)); // 배치관리자 생성
		add(new JButton("사각")); // 버튼 달기
		add(new JButton("직선")); // 버튼 달기
		add(new JButton("타원"));// 버튼 달기
	}
}

class C extends JPanel { // JPanel을 상속받는 C클래스
	C() {
		add(new B());
	}
}