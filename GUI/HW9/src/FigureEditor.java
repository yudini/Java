import javax.swing.*;
import java.awt.*;

public class FigureEditor extends JFrame {

	FigureEditor() {
		setTitle("MyFrame");
		A panel1 = new A();
		C panel2 = new C();
		Container con = getContentPane(); // �������� �˾Ƴ���
		con.setLayout(new BorderLayout()); // �������ҿ� ��ġ������ ����

		con.add(panel1, BorderLayout.CENTER); // panel1�� center�� �ޱ�
		con.add(panel2, BorderLayout.WEST); // panel2�� west�� �ޱ�

		setSize(600, 300); // ������ ũ�� ����
		setVisible(true); // ȭ�鿡 ������ ���
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new FigureEditor();
	}

}


class A extends JPanel { // JPanel�� ��ӹ޴� AŬ����
	A() {
		setBackground(Color.YELLOW); // ����� yellow�� ����
		add(new JLabel("���Ⱑ �׷��� ��ü�� �׸��� ���Դϴ�.")); // �ؽ�Ʈ �ޱ�
	}

}

class B extends JPanel { // JPanel�� ��ӹ޴� BŬ����
	B() {
		setBackground(Color.BLUE); // ����� blue�� ����
		setLayout(new GridLayout(3, 1, 5, 5)); // ��ġ������ ����
		add(new JButton("�簢")); // ��ư �ޱ�
		add(new JButton("����")); // ��ư �ޱ�
		add(new JButton("Ÿ��"));// ��ư �ޱ�
	}
}

class C extends JPanel { // JPanel�� ��ӹ޴� CŬ����
	C() {
		add(new B());
	}
}
