import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
문제
        7
      3   8
    8   1   0
  2   7   4   4
4   5   2   6   5
위 그림은 크기가 5인 정수 삼각형의 한 모습이다.

맨 위층 7부터 시작해서 아래에 있는 수 중 하나를 선택하여 아래층으로 내려올 때,
이제까지 선택된 수의 합이 최대가 되는 경로를 구하는 프로그램을 작성하라.
아래층에 있는 수는 현재 층에서 선택된 수의 대각선 왼쪽 또는 대각선 오른쪽에 있는 것 중에서만 선택할 수 있다.

삼각형의 크기는 1 이상 500 이하이다. 삼각형을 이루고 있는 각 수는 모두 정수이며, 범위는 0 이상 9999 이하이다.
 */

/*
입력
첫째 줄에 삼각형의 크기 n(1 ≤ n ≤ 500)이 주어지고, 둘째 줄부터 n+1번째 줄까지 정수 삼각형이 주어진다.

출력
첫째 줄에 합이 최대가 되는 경로에 있는 수의 합을 출력한다.
 */

/*
예제 입력 1 
    7
   3 8
  8 1 0
 2 7 4 4
4 5 2 6 5

5
7
3 8
8 1 0
2 7 4 4
4 5 2 6 5
예제 출력 1 
30
 */

public class IntegerTriangle1932 {
	static int[][] triangleNums; // 입력받을 정수 삼각형 배열
	static int[][] maxPath; // 경로까지의 최대 합을 담을 배열

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		try {
			int n = Integer.parseInt(br.readLine());
			triangleNums = new int[n][n];
			maxPath = new int[n][n];
			for (int i = 0; i < n; i++) { // 정수 삼각형 배열에 입력
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j <= i; j++) { // j의 인덱스는 i까지만 존재해야함
					triangleNums[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			maxPath[0][0] = triangleNums[0][0]; // 0번째는 삼각형 배열의 값을 넣어줌(앞이 없으므로)
			int max = 0; // 정답을 담을 변수 선언
			for (int i = 0; i < n; i++) {
				int tmp = getMaxPath(n - 1, i); // 임시 변수에 담아서 max와 비교후
				if (tmp > max) // max보다 크면 max에 대입
					max = tmp;
			}
			System.out.println(max); // 정답 출력
		} catch (IOException e) {
		}
	}

	private static int getMaxPath(int n, int idx) { // 경로상의 합을 저장한 배열이 비어있고
		if (maxPath[n][idx] == 0 && n >= idx && n > 0) { // idx는 n보다 크면 안되기 때문에 조건 설정
			if (idx == 0) { // idx가 0이라면 직전 경로의 idx는 무조건 0이 됨
				maxPath[n][idx] = getMaxPath(n - 1, idx) + triangleNums[n][idx];
			} else { // 아니라면 두가지 선택지중에 큰값과 현재 위치의 숫자를 더해서 저장
				maxPath[n][idx] = Math.max(getMaxPath(n - 1, idx), getMaxPath(n - 1, idx - 1)) + triangleNums[n][idx];
			}
		}
		return maxPath[n][idx]; // 경로상의 합이 구해져 있다면 바로 리턴
	}
}
