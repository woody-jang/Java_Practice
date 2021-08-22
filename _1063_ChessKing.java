import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
문제
8*8크기의 체스판에 왕이 하나 있다. 킹의 현재 위치가 주어진다.
체스판에서 말의 위치는 다음과 같이 주어진다. 알파벳 하나와 숫자 하나로 이루어져 있는데,
알파벳은 열을 상징하고, 숫자는 행을 상징한다.
열은 가장 왼쪽 열이 A이고, 가장 오른쪽 열이 H까지 이고, 행은 가장 아래가 1이고 가장 위가 8이다.
예를 들어, 왼쪽 아래 코너는 A1이고, 그 오른쪽 칸은 B1이다.

킹은 다음과 같이 움직일 수 있다.

R : 한 칸 오른쪽으로
L : 한 칸 왼쪽으로
B : 한 칸 아래로
T : 한 칸 위로
RT : 오른쪽 위 대각선으로
LT : 왼쪽 위 대각선으로
RB : 오른쪽 아래 대각선으로
LB : 왼쪽 아래 대각선으로
체스판에는 돌이 하나 있는데, 돌과 같은 곳으로 이동할 때는,
돌을 킹이 움직인 방향과 같은 방향으로 한 칸 이동시킨다. 아래 그림을 참고하자.

입력으로 킹이 어떻게 움직여야 하는지 주어진다.
입력으로 주어진 대로 움직여서 킹이나 돌이 체스판 밖으로 나갈 경우에는 그 이동은 건너 뛰고 다음 이동을 한다.

킹과 돌의 마지막 위치를 구하는 프로그램을 작성하시오.
 */

/*
입력
첫째 줄에 킹의 위치, 돌의 위치, 움직이는 횟수 N이 주어진다.
둘째 줄부터 N개의 줄에는 킹이 어떻게 움직여야 하는지 주어진다.
N은 50보다 작거나 같은 자연수이고, 움직이는 정보는 위에 쓰여 있는 8가지 중 하나이다.

출력
첫째 줄에 킹의 마지막 위치, 둘째 줄에 돌의 마지막 위치를 출력한다.
 */

/*
예제 입력 1 
A1 A2 5
B
L
LB
RB
LT
예제 출력 1 
A1
A2
 */
public class _1063_ChessKing {
	static BufferedReader br;
	static int count;
	static char[] kingPosition = new char[2];
	static char[] stonePosition = new char[2];

	public static void main(String[] args) throws IOException {
		inputData();
		moveKing();
		System.out.println(String.valueOf(kingPosition[0]) + String.valueOf(kingPosition[1]));
		System.out.println(String.valueOf(stonePosition[0]) + String.valueOf(stonePosition[1]));
	}

	private static void inputData() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		String firstKingPosition = st.nextToken();
		String firstStonePosotion = st.nextToken();
		count = Integer.parseInt(st.nextToken());

		kingPosition[0] = firstKingPosition.charAt(0);
		kingPosition[1] = firstKingPosition.charAt(1);
		stonePosition[0] = firstStonePosotion.charAt(0);
		stonePosition[1] = firstStonePosotion.charAt(1);
	}

	private static void moveKing() throws IOException {
		for (int i = 0; i < count; i++) {
			String nowMove = br.readLine();
			switch (nowMove) {
			case "R":
				moveToR();
				break;
			case "L":
				moveToL();
				break;
			case "B":
				moveToB();
				break;
			case "T":
				moveToT();
				break;
			case "RT":
				moveToRT();
//				moveToR();
//				moveToT();
				break;
			case "LT":
				moveToLT();
//				moveToL();
//				moveToT();
				break;
			case "RB":
				moveToRB();
//				moveToR();
//				moveToB();
				break;
			case "LB":
				moveToLB();
//				moveToL();
//				moveToB();
				break;
			}
		}
		br.close();
	}

	private static void moveToR() {
		if (kingPosition[0] + 1 <= 'H') {
			kingPosition[0] += 1;
			if (checkKingAndStonePosition()) {
				if (stonePosition[0] + 1 <= 'H') {
					stonePosition[0] += 1;
				} else {
					kingPosition[0] -= 1;
				}
			}
		}
	}

	private static void moveToL() {
		if (kingPosition[0] - 1 >= 'A') {
			kingPosition[0] -= 1;
			if (checkKingAndStonePosition()) {
				if (stonePosition[0] - 1 >= 'A') {
					stonePosition[0] -= 1;
				} else {
					kingPosition[0] += 1;
				}
			}
		}
	}

	private static void moveToB() {
		if (kingPosition[1] - 1 >= 49) { // ASCII 코드에서 1이 49
			kingPosition[1] -= 1;
			if (checkKingAndStonePosition()) {
				if (stonePosition[1] - 1 >= 49) {
					stonePosition[1] -= 1;
				} else {
					kingPosition[1] += 1;
				}
			}
		}
	}

	private static void moveToT() {
		if (kingPosition[1] + 1 <= 56) { // ASCII 코드에서 8이 56
			kingPosition[1] += 1;
			if (checkKingAndStonePosition()) {
				if (stonePosition[1] + 1 <= 56) {
					stonePosition[1] += 1;
				} else {
					kingPosition[1] -= 1;
				}
			}
		}
	}

	private static void moveToRT() {
		if (kingPosition[0] + 1 <= 'H' && kingPosition[1] + 1 <= 56) {
			kingPosition[0] += 1;
			kingPosition[1] += 1;
			if (checkKingAndStonePosition()) {
				if (stonePosition[0] + 1 <= 'H' && stonePosition[1] + 1 <= 56) {
					stonePosition[0] += 1;
					stonePosition[1] += 1;
				} else {
					kingPosition[0] -= 1;
					kingPosition[1] -= 1;
				}
			}
		}
	}

	private static void moveToLT() {
		if (kingPosition[0] - 1 >= 'A' && kingPosition[1] + 1 <= 56) {
			kingPosition[0] -= 1;
			kingPosition[1] += 1;
			if (checkKingAndStonePosition()) {
				if (stonePosition[0] - 1 >= 'A' && stonePosition[1] + 1 <= 56) {
					stonePosition[0] -= 1;
					stonePosition[1] += 1;
				} else {
					kingPosition[0] += 1;
					kingPosition[1] -= 1;
				}
			}
		}
	}

	private static void moveToRB() {
		if (kingPosition[0] + 1 <= 'H' && kingPosition[1] - 1 >= 49) {
			kingPosition[0] += 1;
			kingPosition[1] -= 1;
			if (checkKingAndStonePosition()) {
				if (stonePosition[0] + 1 <= 'H' && stonePosition[1] - 1 >= 49) {
					stonePosition[0] += 1;
					stonePosition[1] -= 1;
				} else {
					kingPosition[0] -= 1;
					kingPosition[1] += 1;
				}
			}
		}
	}

	private static void moveToLB() {
		if (kingPosition[0] - 1 >= 'A' && kingPosition[1] - 1 >= 49) {
			kingPosition[0] -= 1;
			kingPosition[1] -= 1;
			if (checkKingAndStonePosition()) {
				if (stonePosition[0] - 1 >= 'A' && stonePosition[1] - 1 >= 49) {
					stonePosition[0] -= 1;
					stonePosition[1] -= 1;
				} else {
					kingPosition[0] += 1;
					kingPosition[1] += 1;
				}
			}
		}
	}

	private static boolean checkKingAndStonePosition() {
		return kingPosition[0] == stonePosition[0] && kingPosition[1] == stonePosition[1];
	}
}
