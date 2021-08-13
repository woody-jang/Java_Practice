import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
문제
N*M크기의 직사각형이 있다. 각 칸은 한 자리 숫자가 적혀 있다.
이 직사각형에서 꼭짓점에 쓰여 있는 수가 모두 같은 가장 큰 정사각형을 찾는 프로그램을 작성하시오.
이때, 정사각형은 행 또는 열에 평행해야 한다.

입력
첫째 줄에 N과 M이 주어진다. N과 M은 50보다 작거나 같은 자연수이다.
둘째 줄부터 N개의 줄에 수가 주어진다.

출력
첫째 줄에 정답 정사각형의 크기를 출력한다.
 */

/*
예제 입력 1 
3 5
42101
22100
22101
예제 출력 1 
9
 */
public class _1051_FindSquare {
	static int row;
	static int column;
	private static int[][] numbers;
	private static int[] countEachNumber;
	private static int maxArea = 1; // 숫자 하나가 한칸이기때문에 최소값은 1

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		row = Integer.parseInt(st.nextToken());
		column = Integer.parseInt(st.nextToken());

		inputNumbers(br);

		findSquare();

		System.out.println(maxArea);
		
		br.close();
	}

	private static void inputNumbers(BufferedReader br) throws IOException {
		numbers = new int[row][column];
		countEachNumber = new int[10]; // 같은 숫자가 몇개 있는지 저장할 배열
		for (int i = 0; i < row; i++) {
			String[] line = br.readLine().split("");
			for (int j = 0; j < column; j++) {
				int currentNumber = Integer.parseInt(line[j]);
				numbers[i][j] = currentNumber;
				countEachNumber[currentNumber]++;
			}
		}
	}

	private static void findSquare() {
		for (int number = 0; number < 10; number++) {
			if (countEachNumber[number] > 3) { // 같은숫자가 4개 이상이라면
				getSquareVertex(number); // 일단 사각형의 조건을 갖췄으므로 함수 호출
			}
		}
	}

	private static void getSquareVertex(int currentNumber) {
		List<int[]> vertexCoordinate = new ArrayList<int[]>();

		for (int i = 0; i < numbers.length; i++) {
			for (int j = 0; j < numbers[i].length; j++) {
				if (numbers[i][j] == currentNumber) {
					vertexCoordinate.add(new int[] { i, j });
				} // 4개 이상의 갯수를 가진 숫자의 좌표를 저장
			}
		} // 좌표를 넘겨주면서 함수 호출
		getSquareArea(vertexCoordinate);
	}

	private static void getSquareArea(List<int[]> vertexCoordinate) {
		for (int i = 0; i < vertexCoordinate.size() - 1; i++) {
			for (int j = i + 1; j < vertexCoordinate.size(); j++) {
				int x1 = vertexCoordinate.get(i)[0]; // 첫번째 점의 row 좌표
				int y1 = vertexCoordinate.get(i)[1]; // 첫번째 점의 column 좌표
				int x2 = vertexCoordinate.get(j)[0]; // 두번째 점의 row 좌표
				int y2 = vertexCoordinate.get(j)[1]; // 두번째 점의 column 좌표

				if (x1 == x2) {
					int length = y2 - y1; // x의 좌표가 같으면 길이 구함

					if (length > row || length > column || x1 + length >= row)
						break; // 길이가 row나 column보다 클 수 없음(정사각형)

					if (numbers[x1][y1] == numbers[x1 + length][y1]) { // 정사각형을 이루는 4곳의 값이
						if (numbers[x2][y2] == numbers[x2 + length][y2]) { // 모두 똑같다면
							int currentArea = (length + 1) * (length + 1); // 면적을 구함
							if (currentArea > maxArea)
								maxArea = currentArea;
						}
					}
				} else
					break;
			}
		}
	}
}
