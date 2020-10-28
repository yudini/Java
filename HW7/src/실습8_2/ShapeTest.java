package ½Ç½À8_2;

public class ShapeTest {
	public static void main(String[] args) {
		ShapePanel panel = new ShapePanel();
		
		panel.add(new Rectangle(20,20,3,4));
		panel.add(new Circle(10,10,10));
		panel.display();
		
		panel.add(new Rectangle(10,10,2,3));
		panel.add(new Rectangle(20,20,3,4));
		panel.display();
		
		panel.add(new Circle(100,100,2));
		panel.add(new Circle(10,10,10));
		panel.delete(new Circle(10,10,10));
		panel.display();
	}
}
