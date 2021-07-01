import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
문제
수를 처리하는 것은 통계학에서 상당히 중요한 일이다.
통계학에서 N개의 수를 대표하는 기본 통계값에는 다음과 같은 것들이 있다.
단, N은 홀수라고 가정하자.

산술평균 : N개의 수들의 합을 N으로 나눈 값
중앙값 : N개의 수들을 증가하는 순서로 나열했을 경우 그 중앙에 위치하는 값
최빈값 : N개의 수들 중 가장 많이 나타나는 값
범위 : N개의 수들 중 최댓값과 최솟값의 차이
N개의 수가 주어졌을 때, 네 가지 기본 통계값을 구하는 프로그램을 작성하시오.

입력
첫째 줄에 수의 개수 N(1 ≤ N ≤ 500,000)이 주어진다.
단, N은 홀수이다. 그 다음 N개의 줄에는 정수들이 주어진다.
입력되는 정수의 절댓값은 4,000을 넘지 않는다.

출력
첫째 줄에는 산술평균을 출력한다. 소수점 이하 첫째 자리에서 반올림한 값을 출력한다.

둘째 줄에는 중앙값을 출력한다.

셋째 줄에는 최빈값을 출력한다. 여러 개 있을 때에는 최빈값 중 두 번째로 작은 값을 출력한다.

넷째 줄에는 범위를 출력한다.
 */

/*
예제 입력 1 	예제 출력 1 
5				2
1				2
3				1
8				10
-2
2

예제 입력 2 	예제 출력 2 
1				4000
4000			4000
				4000
				0

예제 입력 3 	예제 출력 3 
5				-2
-1				-2
-2				-1
-3				2
-1
-2
 */

// 갯수는 무조건 홀수이므로
// 중앙값의 index는 size / 2 임
// 평균은 처음에 값을 받으면서 sum해서 더하면 될거같음
// 범위도 값을 받을때 max와 min을 미리 받아서 설정하던지
// collection에 있는 기능 사용하거나 정렬후 0번값과 size-1번 값
// 두번째로 작은값은..... if를 써서 min이랑 비교해서 저장

public class Statistics2108 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int count = Integer.parseInt(br.readLine()); // 총 받을 갯수

		List<Integer> inputNumbers = new ArrayList<>(count); // 받은 숫자들을 저장할 list 생성
		int[] countNumbers = new int[8001]; // 받은 숫자별 등장 횟수 카운팅용
											// -4000 ~ 4000이기때문에 총 8001개를 저장할 수 있어야 함
		int avg = getNumbers(inputNumbers, count, countNumbers, br); // 숫자들을 받아 list에 저장 & 평균값 받음

		Collections.sort(inputNumbers); // 정렬 한 후에
		int midValue = inputNumbers.get(count / 2); // 중간값을 구함

		int max = inputNumbers.get(count - 1);
		int min = inputNumbers.get(0);
		int mostCountNumber = getMostCountNumber(countNumbers, max, min); // 제일 많이 나온 수 구하기
		
		int range = max - min; // 숫자들의 범위
		
		bw.write(avg + "\n" + midValue + "\n" + mostCountNumber + "\n" + range);
		bw.flush();
	}

	private static int getMostCountNumber(int[] countNumbers, int max, int min) {
		int maxValue = 0;
		int maxValueCount = 0;
		for (int i = min + 4000; i <= max + 4000; i++) { // min과 max 범위를 벗어난 부분은 체크하지 않아도 됨
			if (countNumbers[i] > maxValueCount) {
				maxValueCount = countNumbers[i];
				maxValue = i;
			}
		}
		int count = 0; // 최대 출현 횟수가 같은 숫자 카운팅용
		for (int i = min + 4000; i <= max + 4000; i++) {
			if (maxValueCount == countNumbers[i])
				count++;
			if (count == 2) { // 1보다 크다면 바로 탈출 하면서 조건문에 들어온 i가 두번째로 작은값이므로 반환
				maxValue = i; // 1보다 크지않다면 위에있는 for문에서 이미 찾았으므로 알아서 걸러짐
				break;
			}
		}
		return maxValue - 4000; // 4000을 더해서 카운팅했으므로 다시 -4000 해줌
	}

	private static int getNumbers(List<Integer> inputNumbers, int count, int[] countNumbers, BufferedReader br) throws IOException {
		double avg = 0; // 평균을 구하기위한 변수
		for (int i = 0; i < count; i++) {
			int tmp = Integer.parseInt(br.readLine());
			inputNumbers.add(tmp);
			avg += tmp; // 평균을 구하기위해 더해줌
			countNumbers[tmp + 4000]++; // -4000 ~ 4000 이기때문에 4000을 더해서 카운팅함
		}
		avg /= count; // 평균구함								  // 평균이 0보다 작으면 -0.5를해서 int로 변환
		return (avg > 0) ? (int) (avg + 0.5) : (int) (avg - 0.5); // 소수점 첫째자리에서 반올림후 int로 변환
	}															  // 음수에  +0.5를 하면 값이 틀어짐
}
