import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
문제
양수 A가 N의 진짜 약수가 되려면, N이 A의 배수이고, A가 1과 N이 아니어야 한다.
어떤 수 N의 진짜 약수가 모두 주어질 때, N을 구하는 프로그램을 작성하시오.

입력
첫째 줄에 N의 진짜 약수의 개수가 주어진다. 이 개수는 50보다 작거나 같은 자연수이다.
둘째 줄에는 N의 진짜 약수가 주어진다. 1,000,000보다 작거나 같고, 2보다 크거나 같은 자연수이고, 중복되지 않는다.

출력
첫째 줄에 N을 출력한다. N은 항상 32비트 부호있는 정수로 표현할 수 있다.
 */

/*
예제 입력 1 
2
4 2
예제 출력 1 
8
 */

public class _1307_Divisor {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int count = Integer.parseInt(br.readLine());

		// 정렬때문에 오래 걸림
//		int[] inputNumbers = new int[count];
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		for (int i = 0; i < count; i++) {
//			inputNumbers[i] = Integer.parseInt(st.nextToken());
//		}
//		Arrays.sort(inputNumbers);
//		System.out.println(inputNumbers[0] * inputNumbers[count - 1]);

		int max = 1; // 최소값 -1
		int min = 1000001; // 최대값 + 1
		StringTokenizer st = new StringTokenizer(br.readLine());

		while (count-- > 0) {
			int nowNumber = Integer.parseInt(st.nextToken());
			if (nowNumber > max)
				max = nowNumber;
			if (nowNumber < min)
				min = nowNumber;
		}

		// 약수이기때문에 최소값 * 최대값 하면 숫자 나옴
		System.out.println(max * min);
	}
}
