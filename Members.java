import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/*
회원 : 이름, 나이, 전화번호

콘솔 프로그램. (입/출력)

회원등록 - 이미 등록된 회원은 x, 전화번호!!!
회원 목록
회원 삭제
회원 정보 수정
 */

class Member {
	private String name;
	private int age;
	private String phoneNumber;

	public Member(String name, int age, String phoneNumber) {
		this.name = name;
		this.age = age;
		this.phoneNumber = phoneNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Member other = (Member) obj;
		if (phoneNumber == null) {
			if (other.phoneNumber != null)
				return false;
		} else if (!phoneNumber.equals(other.phoneNumber))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "이름:" + name + " / 나이:" + age + " / 전화번호:" + phoneNumber;
	}

}

public class Members {
	static Scanner sc = new Scanner(System.in);

	static void menu() {
		System.out.println("\n\n\n\n ***회원 관리 프로그램***\n" + "    1. 회원 등록\n" + "    2. 회원 목록\n" + "    3. 회원 삭제\n"
				+ "    4. 회원 정보 수정\n" + "    5. 회원 검색\n" + "    0. 종료\n");
	}

	public static void main(String[] args) {
		Set<Member> memberList = new HashSet<>();
		int select = -1;
		boolean check = false;
		while (select != 0) {
			menu();
			if (check) {
				System.out.println("잘못입력했습니다.");
				check = false;
			}
			System.out.println("메뉴를 선택하세요:");
			select = sc.nextInt();
			if (select < 0 || select > 5) {
				check = true;
				continue;
			}
			switch (select) {
			case 1:
				addMember(memberList);
				break;
			case 2:
				showMembers(memberList);
				break;
			case 3:
				delMember(memberList);
				break;
			case 4:
				modMember(memberList);
				break;
			case 5:
				searchMember(memberList);
				break;
			case 0:
				powerOff();
			}
		}
	}

	private static void addMember(Set<Member> memberList) {
		System.out.println("\n\n");
		System.out.println("1. 회원 등록 메뉴");
		sc.nextLine();
		System.out.println("* 이름 입력 : ");
		String name = sc.nextLine();
		System.out.println("* 나이 입력 : ");
		int age = sc.nextInt();
		sc.nextLine();
		System.out.println("* 전화번호 입력 : ");
		String phoneNumber = sc.nextLine();
		phoneNumber = changePhoneNumber(phoneNumber);
		Member new1 = new Member(name, age, phoneNumber);
		if (!memberList.add(new1))
			System.out.println("중복된 회원입니다.\n저장 하지 않습니다.");
	}

	private static String changePhoneNumber(String phoneNumber) {
		StringBuffer sb = new StringBuffer();
		if (phoneNumber.length() <= 11) {
			String[] tmp = phoneNumber.split("");
			for (int i = 0; i < tmp.length; i++) {
				if (i == 3 || i == 7)
					sb.append("-");
				sb.append(tmp[i]);
			}
		}
		return sb.toString();
	}

	private static void showMembers(Set<Member> memberList) {
		System.out.println("\n\n");
		System.out.println("2. 회원 목록 메뉴");
		if (memberList.isEmpty())
			System.out.println("저장된 회원이 없습니다.");
		else {
			for (Member member : memberList) {
				System.out.println(member);
			}
		}
	}

	private static void delMember(Set<Member> memberList) {
		System.out.println("\n\n");
		System.out.println("3. 회원 삭제 메뉴");
		Set<Member> searchList = searchMember(memberList);
		if (searchList.size() > 1) {
			System.out.println("중복된 이름의 회원이 있습니다.\n전화번호를 입력하세요");
			String delNumber = sc.nextLine();
			delNumber = changePhoneNumber(delNumber);
			String name = "";
			boolean chk = false;
			for (Member member : searchList) {
				if (member.getPhoneNumber().equals(delNumber)) {
					chk = true;
					name = member.getName();
					memberList.remove(member);
				}
			}
			if (chk)
				System.out.println(name + " / " + delNumber + "회원의 정보가 삭제되었습니다.");
			else
				System.out.println("잘못 입력하였습니다.\n처음부터 다시 진행하세요");
		} else if (searchList.size() == 1) {
			String name = "";
			for (Member member : searchList) {
				name = member.getName();
				memberList.remove(member);
			}
			System.out.println(name + " 회원의 정보가 삭제되었습니다.");
		}
	}

	private static void modMember(Set<Member> memberList) {
		System.out.println("\n\n");
		System.out.println("4. 회원 정보 수정 메뉴");
		Set<Member> searchList = searchMember(memberList);
		String name = "";
		if (searchList.size() == 1) {
			for (Member member : searchList) {
				name = member.getName();
				modmemb(member);
			}
			System.out.println(name + " 회원의 정보가 수정되었습니다.");
		} else if (searchList.size() > 1) {
			System.out.println("중복된 이름의 회원이 있습니다.\n전화번호를 입력하세요");
			String phoneNumber = sc.nextLine();
			phoneNumber = changePhoneNumber(phoneNumber);
			boolean check = false;
			for (Member member : searchList) {
				if (member.getPhoneNumber().equals(phoneNumber)) {
					name = member.getName();
					modmemb(member);
					check = true;
				}
			}
			if (check)
				System.out.println(name + " / " + phoneNumber + "회원의 정보가 수정되었습니다.");
		}
	}

	private static void modmemb(Member modMemb) {
		System.out.println("(다른 정보만 바꾸고싶으면 유지할 정보의 입력칸은 엔터를 치세요)");
		System.out.println("이름 입력 : ");
		String name = sc.nextLine();
		if (!name.equals("")) {
			modMemb.setName(name);
		}
		System.out.println("나이 입력 : ");
		String age = sc.nextLine();
		if (!age.equals("")) {
			modMemb.setAge(Integer.parseInt(age));
		}
		System.out.println("전화번호 입력 : ");
		String phoneNumber = sc.nextLine();
		if (!age.equals("")) {
			phoneNumber = changePhoneNumber(phoneNumber);
			modMemb.setPhoneNumber(phoneNumber);
		}
	}

	private static Set<Member> searchMember(Set<Member> memberList) {
		System.out.println("\n\n");
		System.out.println("회원명으로 검색합니다.\n이름 입력 : ");
		sc.nextLine();
		String name = sc.nextLine();
		Set<Member> searchList = new HashSet<>();
		int i = 1;
		Iterator<Member> iter = memberList.iterator();
		while (iter.hasNext()) {
			Member temp = iter.next();
			if (temp.getName().equals(name)) {
				System.out.println((i++) + ". " + temp.toString());
				searchList.add(temp);
			}
		}
		return searchList;
	}

	private static void powerOff() {
		System.exit(0);
	}
}
