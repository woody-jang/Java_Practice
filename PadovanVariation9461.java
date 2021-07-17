import java.io.*;

/*
문제
오른쪽 그림과 같이 삼각형이 나선 모양으로 놓여져 있다.
첫 삼각형은 정삼각형으로 변의 길이는 1이다.
그 다음에는 다음과 같은 과정으로 정삼각형을 계속 추가한다.
나선에서 가장 긴 변의 길이를 k라 했을 때, 그 변에 길이가 k인 정삼각형을 추가한다.

파도반 수열 P(N)은 나선에 있는 정삼각형의 변의 길이이다.
P(1)부터 P(10)까지 첫 10개 숫자는 1, 1, 1, 2, 2, 3, 4, 5, 7, 9이다.

N이 주어졌을 때, P(N)을 구하는 프로그램을 작성하시오.
 */

/*
입력
첫째 줄에 테스트 케이스의 개수 T가 주어진다.
각 테스트 케이스는 한 줄로 이루어져 있고, N이 주어진다. (1 ≤ N ≤ 100)

출력
각 테스트 케이스마다 P(N)을 출력한다.
 */

/*
예제 입력 1 
2
6
12
예제 출력 1 
3
16
 */

// 파도반 수열
// P(n) = P(n - 2) + P(n - 3)
// P(0) = P(1) = P(2) = 1

// 위의 수식으로 재귀대신 배열에 저장해서
// 해당되는 값을 하나씩 꺼내씀

public class PadovanVariation9461 {

	public static void main(String[] args) {
		long[] padovan = new long[100]; // 파도반수열을 담을 배열 생성
		padovan[0] = padovan[1] = padovan[2] = 1; // 배열에 초기값 담아줌

		getPadovan(padovan); // 파도반 수열 생성

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		try {
			int t = Integer.parseInt(br.readLine());

			for (int i = 0; i < t; i++) {
				int input = Integer.parseInt(br.readLine());
				bw.write(padovan[input - 1] + "\n"); // 입력받은 숫자번째의 파도반 수열 출력
			}
			bw.flush();
			br.close();
			bw.close();
		} catch (IOException e) {
		}
	}

	private static void getPadovan(long[] padovan) {
		for (int i = 3; i < padovan.length; i++) { // 파도반수열 배열에 저장
			padovan[i] = padovan[i - 2] + padovan[i - 3];
		}
	}

}
