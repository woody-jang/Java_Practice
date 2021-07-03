import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/*
문제
수직선 위에 N개의 좌표 X1, X2, ..., XN이 있다. 이 좌표에 좌표 압축을 적용하려고 한다.

Xi를 좌표 압축한 결과 X'i의 값은 Xi > Xj를 만족하는 서로 다른 좌표의 개수와 같아야 한다.

X1, X2, ..., XN에 좌표 압축을 적용한 결과 X'1, X'2, ..., X'N를 출력해보자.

입력
첫째 줄에 N이 주어진다.

둘째 줄에는 공백 한 칸으로 구분된 X1, X2, ..., XN이 주어진다.

출력
첫째 줄에 X'1, X'2, ..., X'N을 공백 한 칸으로 구분해서 출력한다.

제한
1 ≤ N ≤ 1,000,000
-10^9 ≤ Xi ≤ 10^9
 */

/*
예제 입력 1 
5
2 4 -10 4 -9
예제 출력 1 
2 3 0 3 1

예제 입력 2 
6
1000 999 1000 999 1000 999
예제 출력 2 
1 0 1 0 1 0
 */

// 모든 숫자를 오름차순으로 0부터 순번을 메김
// 인덱스를 활용하면 0부터 순번을 메길 수 있음
// 중복을 제거하고 정렬한 리스트에 기존 숫자의
// 인덱스를 찾아서 출력하면 됨
// 시간초과...

// 배열로 받아서 배열을 복제한 후 정렬
// map에 key로 숫자 value로 index 저장

public class CompressCoordinates18870 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int count = Integer.parseInt(br.readLine()); // 횟수를 담을 변수
		int[] inputNumbers = new int[count]; // 숫자를 받을 배열 생성

		getNumbers(inputNumbers, br); // 리스트에 숫자 추가

		int[] withoutDuplicate = inputNumbers.clone(); // 정렬할 배열 생성

		Arrays.sort(withoutDuplicate); // 배열 정렬

		Map<Integer, Integer> indexOfNumbers = new HashMap<>(); // index 저장할 map 생성

		getIndexNum(withoutDuplicate, indexOfNumbers); // 중복값은 건너뛰면서 map에 index 저장

		for (int temp : inputNumbers) {
			bw.write(indexOfNumbers.get(temp) + " "); // index 출력
		}
		bw.flush();
		/*
		 * for (int i : inputNumbers) { // 받은 숫자를 하나씩 꺼내서
		 * bw.write(withoutDuplicate.indexOf(i) + " "); // 중복을 제거한 리스트에 해당 숫자의 index를 출력
		 * } bw.flush();
		 */
	}

	private static void getIndexNum(int[] withoutDuplicate, Map<Integer, Integer> indexOfNumbers) {
		int index = 0; // index 저장용
		for (int temp : withoutDuplicate) {
			if (!indexOfNumbers.containsKey(temp)) { // map에 현재 key값이 없다면(중복 제거)
				indexOfNumbers.put(temp, index); // 현재 key값의 인덱스 저장
				index++; // 인덱스 ++
			}
		}
	}

	private static void getNumbers(int[] inputNumbers, BufferedReader br) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < inputNumbers.length; i++) {
			int temp = Integer.parseInt(st.nextToken());
			inputNumbers[i] = temp; // 숫자를 받아 저장
		}
	}
}
