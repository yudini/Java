import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

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
	 static JLabel la; // static���� ����� JLabel

	A() {
		setBackground(Color.YELLOW); // ����� yellow�� ����
		la = new JLabel("�簢"); // "�簢"�̶�� ���� �� �ޱ�
		add(la);
		addMouseListener(new MyMouseListener());// MouseListener ������ ���
		addMouseMotionListener(new MyMouseListener());// MouseMotionListener ������ ���
	}

	// Mouse �����ʿ� MouseMoiton�����ʸ� ��� ���� ������ �ۼ�
	class MyMouseListener implements MouseListener, MouseMotionListener {
		// MouseListener�� 5�� �޼ҵ� ����
		public void mousePressed(MouseEvent e) { // ���콺�� ������ ��ġ(x,y)�� ���
			la.setLocation(e.getX(), e.getY());
		}

		public void mouseReleased(MouseEvent e) {// ���콺�� ������ ��ġ(x,y)�� ���
			la.setLocation(e.getX(), e.getY());
		}

		public void mouseClicked(MouseEvent e) { // ���콺�� Ŭ���� ���� ��ġ (x,y)�� ���
			la.setLocation(e.getX(), e.getY());
		}

		public void mouseEntered(MouseEvent e) {
		}

		public void mouseExited(MouseEvent e) {
		}

		// MouseMotionListener�� 2�� �޼ҵ� ����
		public void mouseDragged(MouseEvent e) { // ���콺�� �巡��Ǵ� ���� ȣ��
			la.setLocation(e.getX(), e.getY());
		}

		public void mouseMoved(MouseEvent e) {
		}

	}

}

class B extends JPanel { // JPanel�� ��ӹ޴� BŬ����
	B() {
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
	public class MyActionListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton) e.getSource();
			if (b.getText().equals("�簢")) // ��ư�� �ؽ�Ʈ ���� '�簢'�϶�
				A.la.setText("�簢"); // AŬ������ la�� �ؽ�Ʈ ���� '�簢'���� ����
			else if (b.getText().equals("����")) // ��ư�� �ؽ�Ʈ ���� '����'�϶�
				A.la.setText("����"); // AŬ������ la�� �ؽ�Ʈ ���� '����'���� ����
			else
				A.la.setText("Ÿ��");// AŬ������ la�� �ؽ�Ʈ ���� 'Ÿ��'���� ����

		}
	}
}

class C extends JPanel { // JPanel�� ��ӹ޴� CŬ����
	C() {
		add(new B());
	}
}