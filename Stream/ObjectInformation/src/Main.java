package 실습12_1;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		ArrayList<Student> students = new ArrayList<Student>();

		students.add(new UnderGraduate("100", "Lee", "사물인터넷", 21, "테니스"));
		students.add(new UnderGraduate("101", "Kim", "지능시스템", 21, "요가"));
		students.add(new UnderGraduate("102", "Park", "사이버보안", 24, "댄스"));
		students.add(new UnderGraduate("103", "Kim", "ICT융합엔터테인먼트", 21, "야구"));
		students.add(new Graduate("G100", "Jung", "정보시스템", 26, "석사", "인공지능"));
		students.add(new Graduate("G101", "Lee", "정보시스템", 26, "석사", "보안"));
		students.add(new Graduate("G200", "Han", "정보컴퓨터공학", 28, "박사", "임베디드시스템"));

		saveDataToFile(students, "output.dat");
		System.out.println(loadDataFromFile("output.dat"));

		saveObjectToFile(students, "output.dat");
		System.out.println(loadObjectFromFile("output.dat"));

	}

//ArrayList와 파일이름을 파라미터로 받아 파일에 데이터로 저장하는 함수
	public static void saveDataToFile(ArrayList<Student> students, String fileName) {
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(fileName));
			for (int i = 0; i < students.size(); i++) {
				String str = students.get(i).getClass().getSimpleName(); // students에 저장된 객체 타입을 저장
				str = str.concat(" ");
				str = str.concat(students.get(i).toString());
				out.write(str); // str을 파일에 작성
				out.flush();
			}
			out.close();
		} catch (IOException e) { // 예외 발생시
			System.out.println("error");
		}
	}

	// 파일이름을 파라미터로 받아서 파일을 읽고 데이터 정보를 ArrayList<student>로 저장하여 반환하는 함수
	public static ArrayList<Student> loadDataFromFile(String fileName) {
		ArrayList<Student> students = new ArrayList<Student>();
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "UTF-8"));
			String l;
			while ((l = in.readLine()) != null) { // 한줄씩 읽어들임
				StringTokenizer st = new StringTokenizer(l, " "); // l을 공백을 기준으로 나눔
				String[] arr = new String[st.countTokens()]; // st의 토큰만큼 문자배열 생성
				int i = 0;
				while (st.hasMoreElements()) {
					arr[i] = st.nextToken(); // arr[i]에 나눈 문자들을 저장
					i++;
				}
				int age = Integer.parseInt(arr[4]); // age[4]의 문자열을 정수로 바꿔서 저장
				if (arr[0].equals("UnderGraduate")) // arr[0]의 값이 undergraduate이면
					students.add(new UnderGraduate(arr[1], arr[2], arr[3], age, arr[5])); // Undergraduate객체로 저장
				else
					students.add(new Graduate(arr[1], arr[2], arr[3], age, arr[5], arr[6])); // Graduate객체로 저장
			}
			in.close();
		} catch (IOException e) { // IO예외처리

		}
		return students; // students 반환
	}

//ArrayList와 파일이름을 파라미터로 받아 파일에 객체를 저장하는 함수
	public static void saveObjectToFile(ArrayList<Student> students, String fileName) {
		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName)); // 직렬화 과정
			out.writeObject(students); // 파일에 객체 작성
			out.close();
		} catch (IOException e) { // IO예외처리
			System.out.println("error");
		}
	}

	// 파일이름을 파라미터로 받아 파일로부터 객체정보를 가져와 ArrayList에 저장하여 반환하는 함수
	public static ArrayList<Student> loadObjectFromFile(String fileName) {
		ArrayList<Student> readObject;
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName)); // 역직렬화 과정
			readObject = (ArrayList<Student>) in.readObject(); // 객체를 읽어와 ArrayList<Student>로 다운 캐스팅
			in.close();
			return readObject; // readObject반환
		} catch (ClassNotFoundException e) { // 클래스를 못찾는 예외처리
			return null;
		} catch (IOException e) { // IO예외처리
			return null;
		}
	}
}
/*
 * public static void saveDataToFile(ArrayList<Student> students, String
 * fileName) { try { DataOutputStream out = new DataOutputStream(new
 * FileOutputStream(fileName)); //BufferedWriter out = new BufferedWriter(new
 * FileWriter(fileName)); for (int i = 0; i < students.size(); i++) { String str
 * = students.get(i).getClass().getSimpleName(); str = str.concat(" "); str =
 * str.concat(students.get(i).toString()); //out.write(str); //out.flush();
 * out.writeUTF(str); }
 * 
 * } catch (IOException e) { System.out.println("error"); } } 5UnderGraduate 100
 * Lee 사물인터넷 21 테니스 2UnderGraduate 101 Kim 지능시스템 21 요가 3UnderGraduate 102 Park
 * 사이버보안 24 댄스 >UnderGraduate 103 Kim ICT융합엔터테인먼트 21 야구 <Graduate G100 Jung
 * 정보시스템 26 석사 인공지능 5Graduate G101 Lee 정보시스템 26 석사 보안 JGraduate G200 Han 정보컴퓨터공학
 * 28 박사 임베디드시스템
 */
