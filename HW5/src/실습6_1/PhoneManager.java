package 실습6_1;

import java.util.*;
import java.util.Iterator;

public class PhoneManager {
	private ArrayList<Phone> aList ;// Phone객체만 다루는 ArrayList aList

	public PhoneManager(int num) { // num을 매개변수로 받는 생성자
	    aList= new ArrayList<Phone>(num); // 초기용량이 num인 ArrayList 
	}

	public void add(Phone phone) { // phone객체를 매개변수로받아 aList ArrayList에 저장하는 함수
		aList.add(phone);
	}

	public Iterator<Phone> getPhoneIterator() {  //alist의 Iterator 객체를 얻는 함수
		return aList.iterator();  
	}

	public void searchByName(String name) { // 이름에 따라 번호를 찾는 함수
		int count = 0;
		Iterator<Phone> iterator = getPhoneIterator(); //alist의  Iterator 객체 생성
		Phone person = new Phone();
		while (iterator.hasNext()) { // 값을 가져올 수 있을 때 까지
			person = iterator.next(); // person에 값 저장
			if (person.getName().equals(name)) { // person의 이름과 name값이 같으면
				System.out.println(person.getName() + "의 번호는 " + person.getTel() + "입니다.");
				count++; // count증가
			}
		}
		if (count == 0) // 일치하는 이름이 없으면
			System.out.println("이름이 없습니다.");
	}
	
	public void display() {   //Phone객체의 내용 출력하는 함수
		System.out.println("전화번호부 "+aList.toString());
	}
}


