package �ǽ�6_1;

public class Phone {
	private String name;
	private String tel;

	public Phone() { // �⺻������
		name = "None";
		tel = "None";
	}

	public Phone(String name, String tel) { // �̸��� ��ȭ��ȣ�� �Ű������� �޴� ������
		this.name = name;
		this.tel = tel;
	}

	public String getName() { // �̸��� ��ȯ�ϴ� �Լ�
		return name;
	}

	public void setName(String name) { // �̸��� �����ϴ� �Լ�
		this.name = name;
	}

	public String getTel() { // ��ȭ��ȣ�� ��ȯ�ϴ� �Լ�
		return tel;
	}

	public void setTel(String tel) { // ��ȭ��ȣ�� �����ϴ� �Լ�
		this.tel = tel;
	}

	public String toString() {    //Phone ��ü�� ����
		return "(" + name + "," + tel + ")";
	}

}
