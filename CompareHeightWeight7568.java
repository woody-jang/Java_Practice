import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
문제
우리는 사람의 덩치를 키와 몸무게, 이 두 개의 값으로 표현하여 그 등수를 매겨보려고 한다.
어떤 사람의 몸무게가 x kg이고 키가 y cm라면 이 사람의 덩치는 (x, y)로 표시된다.
두 사람 A 와 B의 덩치가 각각 (x, y), (p, q)라고 할 때 x > p 그리고 y > q 이라면
우리는 A의 덩치가 B의 덩치보다 "더 크다"고 말한다. 예를 들어 어떤 A, B 두 사람의 덩치가
각각 (56, 177), (45, 165) 라고 한다면 A의 덩치가 B보다 큰 셈이 된다.
그런데 서로 다른 덩치끼리 크기를 정할 수 없는 경우도 있다.
예를 들어 두 사람 C와 D의 덩치가 각각 (45, 181), (55, 173)이라면 몸무게는 D가 C보다 더 무겁고,
키는 C가 더 크므로, "덩치"로만 볼 때 C와 D는 누구도 상대방보다 더 크다고 말할 수 없다.

N명의 집단에서 각 사람의 덩치 등수는 자신보다 더 "큰 덩치"의 사람의 수로 정해진다.
만일 자신보다 더 큰 덩치의 사람이 k명이라면 그 사람의 덩치 등수는 k+1이 된다.
이렇게 등수를 결정하면 같은 덩치 등수를 가진 사람은 여러 명도 가능하다.
아래는 5명으로 이루어진 집단에서 각 사람의 덩치와 그 등수가 표시된 표이다.

이름	(몸무게, 키)	덩치 등수
A		(55, 185)			2
B		(58, 183)			2
C		(88, 186)			1
D		(60, 175)			2
E		(46, 155)			5
위 표에서 C보다 더 큰 덩치의 사람이 없으므로 C는 1등이 된다.
그리고 A, B, D 각각의 덩치보다 큰 사람은 C뿐이므로 이들은 모두 2등이 된다.
그리고 E보다 큰 덩치는 A, B, C, D 이렇게 4명이므로 E의 덩치는 5등이 된다.
위 경우에 3등과 4등은 존재하지 않는다.
여러분은 학생 N명의 몸무게와 키가 담긴 입력을 읽어서 각 사람의 덩치 등수를 계산하여 출력해야 한다.

입력
첫 줄에는 전체 사람의 수 N이 주어진다.
그리고 이어지는 N개의 줄에는 각 사람의 몸무게와 키를 나타내는 양의 정수 x와 y가 하나의 공백을 두고 각각 나타난다.

출력
여러분은 입력에 나열된 사람의 덩치 등수를 구해서 그 순서대로 첫 줄에 출력해야 한다.
단, 각 덩치 등수는 공백문자로 분리되어야 한다.
 */

/*
예제 입력 1 
5
55 185
58 183
88 186
50 175
46 155
예제 출력 1 
2 2 1 4 5
 */

// class를 새로 만들어서 comparable을 implements함
// 비교조건이 2개이기때문에 오버라이드해서 문제 풀이
// 코드 적으면서 생각

class Human implements Comparable<Human> {
	int weight; // comparator를 직접 지정할거라 implements함
	int height;
	
	public Human() {}
	public Human(int weight, int height) {
		this.weight = weight;
		this.height = height;
	}

	@Override
	public int compareTo(Human arg0) {
		if (this.height < arg0.height && this.weight < arg0.weight)
			return -1; // 키와 몸무게 둘다 작으면 -1
		else
			return 0; // 어차피 둘다 크거나 비교불가면 같은 등수이기때문에
					  // 같은값을 return 해도 상관 없음
	}
}

public class CompareHeightWeight7568 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		List<Human> list = new ArrayList<>(); // 객체담을 list 생성
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int weight = Integer.parseInt(st.nextToken());
			int height = Integer.parseInt(st.nextToken());
			list.add(new Human(weight, height)); // list에 data 추가
		}
		for (int i = 0; i < n; i++) { // 완전탐색
			Human a = list.get(i); // 비교 위해 임시로 담을 변수
			int grade = 1; // 우선 1등으로 초기화
			for (int j = 0; j < n; j++) { // 브루트포트 알고리즘
				if (i == j) // 같은 객체면 다음으로 넘어감
					continue;
				Human b = list.get(j); // 두번째로 담을 변수(list.get()을 계속 쓰기 힘들어서 만듦)
				if (a.compareTo(b) < 0) // 직접 지정한 comparator로 비교해서 키와 몸무게
					grade++; // 둘다 작을 경우에 등수에 1 추가
			}
			bw.write(grade + " "); // 비교 완료 후 버퍼에 추가
		}
		bw.flush();
		br.close();
		bw.close();
	}

}
