import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/*
문제
온라인 저지에 가입한 사람들의 나이와 이름이 가입한 순서대로 주어진다.
이때, 회원들을 나이가 증가하는 순으로,
나이가 같으면 먼저 가입한 사람이 앞에 오는 순서로 정렬하는 프로그램을 작성하시오.

입력
첫째 줄에 온라인 저지 회원의 수 N이 주어진다. (1 ≤ N ≤ 100,000)

둘째 줄부터 N개의 줄에는 각 회원의 나이와 이름이 공백으로 구분되어 주어진다.
나이는 1보다 크거나 같으며, 200보다 작거나 같은 정수이고,
이름은 알파벳 대소문자로 이루어져 있고, 길이가 100보다 작거나 같은 문자열이다.
입력은 가입한 순서로 주어진다.

출력
첫째 줄부터 총 N개의 줄에 걸쳐 온라인 저지 회원을 나이 순,
나이가 같으면 가입한 순으로 한 줄에 한 명씩 나이와 이름을 공백으로 구분해 출력한다.
 */

/*
예제 입력 1 
3
21 Junkyu
21 Dohyun
20 Sunyoung

예제 출력 1 
20 Sunyoung
21 Junkyu
21 Dohyun
 */

// Comparable을 implements 하는 클래스를 생성해서
// 필드에 순서를 저장할 변수와 이름 나이를 생성
// 객체끼리 비교하기

class Member implements Comparable<Member> {
	int num;
	int age;
	String name;

	public Member(int num, int age, String name) {
		this.num = num;
		this.age = age;
		this.name = name;
	}

	@Override
	public String toString() { // 문제에서 지정한 방식으로 toString override
		return age + " " + name;
	}

	@Override
	public int compareTo(Member o) {
		if (this.age == o.age) // 나이가 같다면
			return this.num - o.num; // 회원가입 순서대로 정렬
		else
			return this.age - o.age; // 나이가 다르다면 나이순으로 정렬
	}
}

public class StableSort10814 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int count = Integer.parseInt(br.readLine());
		List<Member> inputMembers = new ArrayList<>(); // 회원들을 받을 list 생성

		// list에 입력받은 회원정보를 저장
		getMembers(inputMembers, count, br);

		// class에 지정한 compareTo를 이용하여 정렬함
		Collections.sort(inputMembers);
		
		for (Member mem : inputMembers) {
			bw.write(mem + "\n"); // 출력
		}
		
		bw.flush();
	}

	private static void getMembers(List<Member> inputMembers, int count, BufferedReader br) throws IOException {
		StringTokenizer st; // 공백으로 구분해서 값을 저장하기 위함
		for (int i = 0; i < count; i++) {
			st = new StringTokenizer(br.readLine());
			int age = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			inputMembers.add(new Member(i, age, name)); // 순번, 나이, 이름으로 만든 객체 저장
		}
	}

}
