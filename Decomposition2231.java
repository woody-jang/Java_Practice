import java.util.Scanner;

/*
문제
어떤 자연수 N이 있을 때, 그 자연수 N의 분해합은 N과 N을 이루는 각 자리수의 합을 의미한다.
어떤 자연수 M의 분해합이 N인 경우, M을 N의 생성자라 한다. 예를 들어, 245의 분해합은 256(=245+2+4+5)이 된다.
따라서 245는 256의 생성자가 된다. 물론, 어떤 자연수의 경우에는 생성자가 없을 수도 있다.
반대로, 생성자가 여러 개인 자연수도 있을 수 있다.

자연수 N이 주어졌을 때, N의 가장 작은 생성자를 구해내는 프로그램을 작성하시오.

입력
첫째 줄에 자연수 N(1 ≤ N ≤ 1,000,000)이 주어진다.

출력
첫째 줄에 답을 출력한다. 생성자가 없는 경우에는 0을 출력한다.
 */

/*
예제 입력 1 
216
예제 출력 1 
198
 */

// 123의 분해합은 129
// 99의 분해합은 117
// 100의 분해합은 101
// 각 자리의 최대는 9이기 때문에
// 9 * 자릿수 를 빼면 최소값이 된다
// 결국 생성자의 범위는
// 자기자신 - 자릿수 * 9 <= 생성자 < 자기자신
public class Decomposition2231 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String sn = sc.nextLine(); // 자릿수를 알기위해 String으로 받음
		int in = Integer.parseInt(sn); // 계산하기 위해 다시 int로 변환
		int i = in - (sn.length() * 9); // for문에 들어갈 i를 사용하기위해 밖에서 선언&초기화
										// 위에서 계산한대로 시작값은 in - 자릿수 * 9
		for (; i < in; i++) {  // 자기 자신보다 작을때까지 반복
			int sum = 0;
			int num = i; // 자릿수 더하기 위해 copy
			while (num != 0) { // 각 자릿수 더하는 구간
				sum += num % 10;
				num /= 10;
			}
			if (sum + i == in) // 자릿수를 더한값과 i를 더해서 in이면 종료
				break;		   // 최소값이기 때문에 바로 종료, 모두 구하려면 list추가해서 담기
		}
		System.out.println((i == in) ? 0 : i); // i와 in이 같다면 생성자가 없기때문에 0
		sc.close();
	}
}
