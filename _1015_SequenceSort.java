import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
문제
P[0], P[1], ...., P[N-1]은 0부터 N-1까지(포함)의 수를 한 번씩 포함하고 있는 수열이다.
수열 P를 길이가 N인 배열 A에 적용하면 길이가 N인 배열 B가 된다. 적용하는 방법은 B[P[i]] = A[i]이다.

배열 A가 주어졌을 때, 수열 P를 적용한 결과가 비내림차순이 되는 수열을 찾는 프로그램을 작성하시오.
비내림차순이란, 각각의 원소가 바로 앞에 있는 원소보다 크거나 같을 경우를 말한다.
만약 그러한 수열이 여러개라면 사전순으로 앞서는 것을 출력한다.

입력
첫째 줄에 배열 A의 크기 N이 주어진다. 둘째 줄에는 배열 A의 원소가 0번부터 차례대로 주어진다.
N은 50보다 작거나 같은 자연수이고, 배열의 원소는 1,000보다 작거나 같은 자연수이다.

출력
첫째 줄에 비내림차순으로 만드는 수열 P를 출력한다.
 */

/*
예제 입력 1 
3
2 3 1
예제 출력 1 
1 2 0
 */

public class _1015_SequenceSort {
	static List<Number> numbers;

	public static void main(String[] args) throws IOException {

		inputNumber();

		// 입력받은 숫자로 오름차순 정렬
		Collections.sort(numbers, new Comparator<Number>() {
			@Override
			public int compare(Number o1, Number o2) {
				return o1.num - o2.num;
			}
		});

		// 처음에 입력받은 0번째 값이 정렬한 리스트의 몇번째 값인지 확인
		System.out.println(getFirstIndex());
	}

	// 숫자를 입력받아 기존 인덱스와 함께 저장하는 작업
	private static void inputNumber() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int count = Integer.parseInt(br.readLine());

		numbers = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < count; i++) {
			int num = Integer.parseInt(st.nextToken());
			numbers.add(new Number(num, i));
		}
		br.close();
	}

	// 처음에 입력받은 0번째 값이 정렬한 리스트의 몇번째 값인지 확인
	private static String getFirstIndex() {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < numbers.size(); i++) {
			for (int j = 0; j < numbers.size(); j++) {
				if (numbers.get(j).idx == i) {
					sb.append(j + " ");
					break;
				}
			}
		}
		return sb.toString();
	}
}

class Number { // 숫자와 기존의 인덱스를 담을 클래스
	int num;
	int idx;

	public Number(int num, int idx) {
		this.num = num;
		this.idx = idx;
	}
}