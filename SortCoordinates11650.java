import java.io.*;
import java.util.*;

/*
문제
2차원 평면 위의 점 N개가 주어진다. 좌표를 x좌표가 증가하는 순으로,
x좌표가 같으면 y좌표가 증가하는 순서로 정렬한 다음 출력하는 프로그램을 작성하시오.

입력
첫째 줄에 점의 개수 N (1 ≤ N ≤ 100,000)이 주어진다.
둘째 줄부터 N개의 줄에는 i번점의 위치 xi와 yi가 주어진다.
(-100,000 ≤ xi, yi ≤ 100,000) 좌표는 항상 정수이고, 위치가 같은 두 점은 없다.

출력
첫째 줄부터 N개의 줄에 점을 정렬한 결과를 출력한다.
 */

/*
예제 입력 1 
5
3 4
1 1
1 -1
2 2
3 3
예제 출력 1 
1 -1
1 1
2 2
3 3
3 4
 */

// 각 좌표를 배열로 받아 배열들을 list에 저장해서 
// comparator를 직접 지정해서 정렬할 예정

public class SortCoordinates11650 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int count = Integer.parseInt(br.readLine());
		List<int[]> inputNumbers = new ArrayList<>();

		getNumbers(inputNumbers, count, br); // 받은 좌표를 list에 저장해줌
		
		// 정렬 작업
		Collections.sort(inputNumbers, new Comparator<int[]>() {
			@Override
			public int compare(int[] arg0, int[] arg1) {
				if (arg0[0] == arg1[0]) // 만약 x좌표가 같다면
					return arg0[1] - arg1[1]; // y 좌표로 정렬하고
				else
					return arg0[0] - arg1[0]; // 다르다면 x좌표로 오름차순 정렬
			}
		});
		
		// 출력 작업
		for (int[] arr : inputNumbers) {
			bw.write(arr[0] + " " + arr[1] + "\n");
		}
		
		bw.flush();
	}

	private static void getNumbers(List<int[]> inputNumbers, int count, BufferedReader br) throws IOException {
		StringTokenizer st; // 공백으로 구분해서 받으려고 선언
		for (int i = 0; i < count; i++) {
			st = new StringTokenizer(br.readLine()); // 한줄을 stringtokenizer에 담아서
			int first = Integer.parseInt(st.nextToken()); // x 좌표를 저장하고
			int second = Integer.parseInt(st.nextToken()); // y 좌표를 저장해서
			int[] temp = { first, second }; // 배열로 만들어
			inputNumbers.add(temp); // list에 추가

		}
	}

}
