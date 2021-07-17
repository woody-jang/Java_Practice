import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
문제
지원이에게 2진 수열을 가르쳐 주기 위해,
지원이 아버지는 그에게 타일들을 선물해주셨다.
그리고 이 각각의 타일들은 0 또는 1이 쓰여 있는 낱장의 타일들이다.

어느 날 짓궂은 동주가 지원이의 공부를 방해하기 위해
0이 쓰여진 낱장의 타일들을 붙여서 한 쌍으로 이루어진 00 타일들을 만들었다.
결국 현재 1 하나만으로 이루어진 타일
또는 0타일을 두 개 붙인 한 쌍의 00타일들만이 남게 되었다.

그러므로 지원이는 타일로 더 이상 크기가 N인 모든 2진 수열을 만들 수 없게 되었다.
예를 들어, N=1일 때 1만 만들 수 있고, N=2일 때는 00, 11을 만들 수 있다.
(01, 10은 만들 수 없게 되었다.)
또한 N=4일 때는 0011, 0000, 1001, 1100, 1111 등 총 5개의 2진 수열을 만들 수 있다.

우리의 목표는 N이 주어졌을 때 지원이가 만들 수 있는 모든 가짓수를 세는 것이다.
단 타일들은 무한히 많은 것으로 가정하자.
 */

/*
입력
첫 번째 줄에 자연수 N이 주어진다. (1 ≤ N ≤ 1,000,000)

출력
첫 번째 줄에 지원이가 만들 수 있는 길이가 N인
모든 2진 수열의 개수를 15746으로 나눈 나머지를 출력한다.
 */

/*
예제 입력 1 
4
예제 출력 1 
5
 */

// 1 1
// 2 2
// 3 3
// 4 5
// 5 8
// 6 13
// 직접 계산해보니 피보나치 수열갯수로 증가함
// 하지만 n의 범위때문에 StackOverFlow에러가 뜸
// 배열에 담는 방법으로 우회해서 적용

public class BinaryTile1904 {
	
	public static void main(String[] args) {
		int[] fibo = new int[1000000]; // 피보나치 수열을 담을 배열 생성
		fibo[0] = 1; // 처음 2개 미리 값 넣음
		fibo[1] = 2;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			int n = Integer.parseInt(br.readLine());
			getFibo(fibo, n); // 입력받은 n 까지 피보나치 수열을 구함
			System.out.println(fibo[n - 1] % 15746); // 1부터 시작했으므로 -1
			br.close();
		} catch (IOException e) {
		}
	}

	private static void getFibo(int[] fibo, int n) {
		for (int i = 2; i < n; i++) { // n까지 피보나치수열을 배열에 저장함
			fibo[i] = fibo[i - 1] % 15746 + fibo[i - 2] % 15746;
		}
	}
}
