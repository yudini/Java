package 실습12_1;
import java.io.*;

public class Student implements Serializable { //직렬화 조건
	String id;
	String name;
	String department;
	int age;
	
	public Student(String id, String name, String department, int age) {
		super();
		this.id = id;
		this.name = name;
		this.department = department;
		this.age = age;
	}
	
}
