import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/*
문제
카지노에서 제일 인기 있는 게임 블랙잭의 규칙은 상당히 쉽다.
카드의 합이 21을 넘지 않는 한도 내에서, 카드의 합을 최대한 크게 만드는 게임이다.
블랙잭은 카지노마다 다양한 규정이 있다.

한국 최고의 블랙잭 고수 김정인은 새로운 블랙잭 규칙을 만들어 상근, 창영이와 게임하려고 한다.

김정인 버전의 블랙잭에서 각 카드에는 양의 정수가 쓰여 있다.
그 다음, 딜러는 N장의 카드를 모두 숫자가 보이도록 바닥에 놓는다. 그런 후에 딜러는 숫자 M을 크게 외친다.

이제 플레이어는 제한된 시간 안에 N장의 카드 중에서 3장의 카드를 골라야 한다.
블랙잭 변형 게임이기 때문에, 플레이어가 고른 카드의 합은 M을 넘지 않으면서 M과 최대한 가깝게 만들어야 한다.

N장의 카드에 써져 있는 숫자가 주어졌을 때, M을 넘지 않으면서 M에 최대한 가까운 카드 3장의 합을 구해 출력하시오.

입력
첫째 줄에 카드의 개수 N(3 ≤ N ≤ 100)과 M(10 ≤ M ≤ 300,000)이 주어진다.
둘째 줄에는 카드에 쓰여 있는 수가 주어지며, 이 값은 100,000을 넘지 않는 양의 정수이다.

합이 M을 넘지 않는 카드 3장을 찾을 수 있는 경우만 입력으로 주어진다.

출력
첫째 줄에 M을 넘지 않으면서 M에 최대한 가까운 카드 3장의 합을 출력한다.
 */

/*
예제 입력 1 
5 21
5 6 7 8 9
예제 출력 1 
21

예제 입력 2 
10 500
93 181 245 214 315 36 185 138 216 295
예제 출력 2 
497
 */

// 완전탐색으로 접근
// 시간이 오래 걸리더라도 bubble sort 방식으로 완전탐색하면
// 답이 나옴

public class BlackJack2798 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int cnt = Integer.parseInt(st.nextToken()); // 입력받을 갯수
		int m = Integer.parseInt(st.nextToken()); // 블랙잭 선택 값

		st = new StringTokenizer(br.readLine());
		List<Integer> list = new ArrayList<Integer>(cnt); // 받은 숫자들을 저장할 용도
		int max = 0; // 최대값 저장용

		for (int i = 0; i < cnt; i++) { // 우선 숫자를 받아 list에 저장
			list.add(Integer.parseInt(st.nextToken()));
		}

		Collections.sort(list); // 반복을 줄이기 위해 정렬

		for (int i = 0; i < list.size() - 2; i++) {
			if (list.get(i) > m) // i가 m보다 크게되면 조건 탈락이므로 바로 탈출
				break;
			if (max == m) // max와 m이 같으면 최대이므로 바로 탈출
				break;
			for (int j = i + 1; j < list.size() - 1; j++) {
				int sum = list.get(i) + list.get(j);
				if (sum > m) { // i + j가 m보다 크게되면 조건 탈락이므로 바로 종료
					System.out.println(max);
					System.exit(0);
				}
				for (int k = j + 1; k < list.size(); k++) {
					if (sum + list.get(k) > m) // 3개의 합이 m보다 크면 뒤는 자동으로 조건 탈락
						break;
					if (sum + list.get(k) > max) // i + j + k가 max보다 크면 max 값 변경
						max = sum + list.get(k);
				}
			}
		}
		System.out.println(max); // 탈출조건에 안걸리고 끝나는 경우 출력
	}
}
