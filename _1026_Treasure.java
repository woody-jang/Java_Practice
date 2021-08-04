import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/*
문제
옛날 옛적에 수학이 항상 큰 골칫거리였던 나라가 있었다.
이 나라의 국왕 김지민은 다음과 같은 문제를 내고 큰 상금을 걸었다.

길이가 N인 정수 배열 A와 B가 있다. 다음과 같이 함수 S를 정의하자.

S = A[0]×B[0] + ... + A[N-1]×B[N-1]

S의 값을 가장 작게 만들기 위해 A의 수를 재배열하자. 단, B에 있는 수는 재배열하면 안 된다.

S의 최솟값을 출력하는 프로그램을 작성하시오.

입력
첫째 줄에 N이 주어진다. 둘째 줄에는 A에 있는 N개의 수가 순서대로 주어지고,
셋째 줄에는 B에 있는 수가 순서대로 주어진다. N은 50보다 작거나 같은 자연수이고,
A와 B의 각 원소는 100보다 작거나 같은 음이 아닌 정수이다.

출력
첫째 줄에 S의 최솟값을 출력한다.
 */

/*
예제 입력 1 
5
1 1 1 6 0
2 7 8 3 1
예제 출력 1 
18
 */

public class _1026_Treasure {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int count = Integer.parseInt(br.readLine());

		int[] arrayA = new int[count]; // A 숫자들을 받을 배열
		Integer[] arrayB = new Integer[count]; // B 숫자들을 받을 배열

		// 숫자 받는 메서드
		inputNumbers(arrayA, arrayB, br);

		// 배열 정렬 메서드
		sortArrays(arrayA, arrayB);

		int sum = 0;
		for (int i = 0; i < arrayA.length; i++) {
			sum += arrayA[i] * arrayB[i];
		}

		System.out.println(sum);
	}

	// 배열 정렬 메서드
	private static void sortArrays(int[] arrayA, Integer[] arrayB) {
		// A배열 오름차순 정렬
		Arrays.sort(arrayA);

		// B배열 내림차순 정렬(B의 큰숫자에 A의 작은 숫자들을 매칭하기위해)
		Arrays.sort(arrayB, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		});
	}

	// 숫자 받는 메서드
	private static void inputNumbers(int[] arrayA1, Integer[] arrayB, BufferedReader br) throws IOException {
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		for (int i = 0; i < arrayA1.length; i++) {
			arrayA1[i] = Integer.parseInt(st1.nextToken());
			arrayB[i] = Integer.parseInt(st2.nextToken());
		}
	}
}