package �ǽ�6_1;

import java.util.*;
import java.util.Iterator;

public class PhoneManager {
	private ArrayList<Phone> aList ;// Phone��ü�� �ٷ�� ArrayList aList

	public PhoneManager(int num) { // num�� �Ű������� �޴� ������
	    aList= new ArrayList<Phone>(num); // �ʱ�뷮�� num�� ArrayList 
	}

	public void add(Phone phone) { // phone��ü�� �Ű������ι޾� aList ArrayList�� �����ϴ� �Լ�
		aList.add(phone);
	}

	public Iterator<Phone> getPhoneIterator() {  //alist�� Iterator ��ü�� ��� �Լ�
		return aList.iterator();  
	}

	public void searchByName(String name) { // �̸��� ���� ��ȣ�� ã�� �Լ�
		int count = 0;
		Iterator<Phone> iterator = getPhoneIterator(); //alist��  Iterator ��ü ����
		Phone person = new Phone();
		while (iterator.hasNext()) { // ���� ������ �� ���� �� ����
			person = iterator.next(); // person�� �� ����
			if (person.getName().equals(name)) { // person�� �̸��� name���� ������
				System.out.println(person.getName() + "�� ��ȣ�� " + person.getTel() + "�Դϴ�.");
				count++; // count����
			}
		}
		if (count == 0) // ��ġ�ϴ� �̸��� ������
			System.out.println("�̸��� �����ϴ�.");
	}
	
	public void display() {   //Phone��ü�� ���� ����ϴ� �Լ�
		System.out.println("��ȭ��ȣ�� "+aList.toString());
	}
}


