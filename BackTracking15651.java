import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
문제
자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.

1부터 N까지 자연수 중에서 M개를 고른 수열
같은 수를 여러 번 골라도 된다.
입력
첫째 줄에 자연수 N과 M이 주어진다. (1 ≤ M ≤ N ≤ 7)

출력
한 줄에 하나씩 문제의 조건을 만족하는 수열을 출력한다.
중복되는 수열을 여러 번 출력하면 안되며, 각 수열은 공백으로 구분해서 출력해야 한다.

수열은 사전 순으로 증가하는 순서로 출력해야 한다.
 */

/*
예제 입력 1 
3 1
예제 출력 1 
1
2
3
예제 입력 3 
3 3
예제 출력 3 
1 1 1
1 1 2
1 1 3
1 2 1
1 2 2
1 2 3
1 3 1
1 3 2
1 3 3
2 1 1
2 1 2
2 1 3
2 2 1
2 2 2
2 2 3
2 3 1
2 3 2
2 3 3
3 1 1
3 1 2
3 1 3
3 2 1
3 2 2
3 2 3
3 3 1
3 3 2
3 3 3
 */

// 백준 15649, 15650문제와 비슷하지만
// 앞에 나온 숫자와 중복되도 상관 없음
// 중복 체크만 없애면 15649와 똑같음

public class BackTracking15651 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuffer sb = new StringBuffer();

		int n = Integer.parseInt(st.nextToken()); // 숫자 범위 받음
		int m = Integer.parseInt(st.nextToken()); // 반복 횟수 받음

		List<Integer> postNumbers = new ArrayList<>(); // 재귀시 앞의 숫자들을 담을 리스트 생성
		
		getNumbers(n, m, m, postNumbers, sb); // 숫자범위, 반복횟수, 출력조건용 갯수, 앞 숫자들 리스트를 넣어서 넘겨줌

		System.out.println(sb);
	}

	private static void getNumbers(int n, int m, int cnt, List<Integer> postNumbers, StringBuffer sb) {
		if (m > 0) { // 반복횟수가 0보다 크면 반복
			for (int i = 1; i <= n; i++) {
				postNumbers.add(i); // list에 현재 숫자 추가
				getNumbers(n, m - 1, cnt, postNumbers, sb); // 재귀 시작
				if (postNumbers.size() == cnt) { // 만약 리스트의 숫자갯수와 반복횟수가 일치한다면
					for (int j = 0; j < postNumbers.size(); j++) { // stringbuffer에 숫자 추가
						sb.append(postNumbers.get(j) + " ");
					}
					sb.append("\n"); // 횟수만큼 추가후 개행
				}
				postNumbers.remove(postNumbers.size() - 1); // 다시 반복을 돌기때문에 마지막에 추가한 숫자 제거
			}
		}
	}
}
