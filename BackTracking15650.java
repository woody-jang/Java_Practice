import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
문제
자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.

1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
고른 수열은 오름차순이어야 한다.
입력
첫째 줄에 자연수 N과 M이 주어진다. (1 ≤ M ≤ N ≤ 8)

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
예제 입력 2 
4 2
예제 출력 2 
1 2
1 3
1 4
2 3
2 4
3 4
예제 입력 3 
4 4
예제 출력 3 
1 2 3 4
 */

// 백준 15649문제와 비슷하지만
// 무조건 앞의 숫자가 뒤의 숫자보다 작아야함
// for문 시작지점만 바꾸면 15649와 똑같아짐

public class BackTracking15650 {
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
			// 이전에 숫자가 없다면 1부터 반복을 시작하고 있다면 그 숫자에 +1부터 반복시작
			int i = (postNumbers.size() == 0) ? 1 : postNumbers.get(postNumbers.size() - 1) + 1;
			for (; i <= n; i++) {
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
