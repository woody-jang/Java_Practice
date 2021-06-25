import java.util.*;

/*
 * 학생 : 이름, 나이
 * 학급 : 학생이 여러명
 * 		0. 학생을 추가, 삭제 가능
 * 		1. 이름 순으로 학생목록을 콘솔창에 출력가능.
 * 		2. 나이 순으로 학생목록을 콘솔창에 출력가능.
 * 		3. 나이의 평균을 콘솔창에 출력가능.
 */

class Student {
	private String name;
	private int age;

	public Student(String name, int age) {
		this.name = name;
		this.age = age;
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

	@Override
	public String toString() {
		return "이름-나이: " + name + "-" + age + "";
	}

}

class _Class {
	private List<Student> students;

	public _Class() {
		students = new ArrayList<Student>();
	}

	public void addStudent(Student stu) {
		Iterator<Student> iter = students.iterator();
		while (iter.hasNext()) {
			Student tmp = iter.next();
			if (tmp.getName().equals(stu.getName()) && tmp.getAge() == stu.getAge()) {
				System.out.println("중복된 정보입니다!");
				return;
			}
		}
		System.out.printf("--%s, %d살 입력 완료--\n", stu.getName(), stu.getAge());
		students.add(stu);
	}

	public List<Student> getStudents() {
		return students;
	}

	public void sortName() {
		Collections.sort(students, new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				return o1.getName().compareTo(o2.getName());
			}
		});
//		for (int i = 0; i < students.size() - 1; i++) {
//			for (int j = i + 1; j < students.size(); j++) {
//				if (students.get(i).getName().compareTo(students.get(j).getName()) > 0) {
//					Student tmp = students.get(i);
//					students.set(i, students.get(j));
//					students.set(j, tmp);
//				}
//			}
//		}
	}

	public void sortAge() {
		Collections.sort(students, new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				return o1.getAge() - o2.getAge();
			}
		});
//		for (int i = 0; i < students.size() - 1; i++) {
//			for (int j = i + 1; j < students.size(); j++) {
//				if (students.get(i).getAge() > students.get(j).getAge()) {
//					Student tmp = students.get(i);
//					students.set(i, students.get(j));
//					students.set(j, tmp);
//				}
//			}
//		}
	}

	public double getAvgOfAge() {
		double avg = 0.0;
		for (Student stu : students) {
			avg += stu.getAge();
		}
		avg /= students.size();
		return avg;
	}
	
	public void delStudent(String name) {
		Iterator<Student> iter = this.students.iterator();
		boolean chk = true;
		while(iter.hasNext()) {
			Student tmp = iter.next();
			if (tmp.getName().equals(name)) {
				iter.remove();
				System.out.printf("%s 학생이 삭제되었습니다\n", name);
				chk = false;
				break;
			}
		}
		if (chk)
			System.out.println(name + "학생은 명단에 없습니다");
	}
}

public class StudentListManagement {

	static Scanner sc = new Scanner(System.in);
	static _Class sunflower = new _Class();

	public static void addStudent() {
		System.out.println("입력할 인원 수 :");
		int cnt = sc.nextInt();
		for (int i = 0; i < cnt; i++) {
			sc.nextLine(); // 버퍼 초기화
			System.out.println("이름 입력 :");
			String name = sc.nextLine();
			System.out.println("나이 입력 :");
			int age = sc.nextInt();
			sunflower.addStudent(new Student(name, age));
		}
	}

	public static void printList() {
		for (Student stu : sunflower.getStudents()) {
			System.out.println(stu);
		}
	}
	
	public static void delStudent() {
		System.out.println("삭제할 학생명 입력 :");
		sc.nextLine();
		String name = sc.nextLine();
		sunflower.delStudent(name);
	}

	public static void main(String[] args) {
		while (true) {
			System.out.println("\n\n학생 관리 프로그램\n1. 학생추가\n2. 학생목록 확인\n3. 이름순 정렬\n4. 나이순 정렬\n5. 학생 삭제\n6. 종료");
			System.out.println("메뉴를 선택하세요 :");
			int select = sc.nextInt();
			switch (select) {
			case 1:
				addStudent();
				break;
			case 2:
				printList();
				break;
			case 3:
				sunflower.sortName();
				printList();
				break;
			case 4:
				sunflower.sortAge();
				printList();
				break;
			case 5:
				delStudent();
				printList();
				break;
			case 6:
				System.exit(0);
			}
		}
/*
		System.out.println("\n    **정렬전**");
		for (Student stu : sunflower.getStudents()) {
			System.out.println(stu);
		}
		System.out.println("---------------------");

		System.out.println("    **이름정렬**");
		sunflower.sortName();
		for (Student stu : sunflower.getStudents()) {
			System.out.println(stu);
		}
		System.out.println("---------------------");
		System.out.println("    **나이정렬**");
		sunflower.sortAge();
		for (Student stu : sunflower.getStudents()) {
			System.out.println(stu);
		}

		System.out.println("---------------------");
		System.out.printf("평균나이 : %.2f살", sunflower.getAvgOfAge());
*/
	}
}
