
//[카카오 인턴] 키패드 누르기

/*
이 전화 키패드에서 왼손과 오른손의 엄지손가락만을 이용해서 숫자만을 입력하려고 합니다.
맨 처음 왼손 엄지손가락은 * 키패드에 오른손 엄지손가락은 # 키패드 위치에서 시작하며, 엄지손가락을 사용하는 규칙은 다음과 같습니다.

엄지손가락은 상하좌우 4가지 방향으로만 이동할 수 있으며 키패드 이동 한 칸은 거리로 1에 해당합니다.
왼쪽 열의 3개의 숫자 1, 4, 7을 입력할 때는 왼손 엄지손가락을 사용합니다.
오른쪽 열의 3개의 숫자 3, 6, 9를 입력할 때는 오른손 엄지손가락을 사용합니다.
가운데 열의 4개의 숫자 2, 5, 8, 0을 입력할 때는 두 엄지손가락의 현재 키패드의 위치에서 더 가까운 엄지손가락을 사용합니다.
4-1. 만약 두 엄지손가락의 거리가 같다면, 오른손잡이는 오른손 엄지손가락, 왼손잡이는 왼손 엄지손가락을 사용합니다.
순서대로 누를 번호가 담긴 배열 numbers, 왼손잡이인지 오른손잡이인 지를 나타내는 문자열 hand가 매개변수로 주어질 때,
각 번호를 누른 엄지손가락이 왼손인 지 오른손인 지를 나타내는 연속된 문자열 형태로 return 하도록 solution 함수를 완성해주세요.
 */

/*
[제한사항]
numbers 배열의 크기는 1 이상 1,000 이하입니다.
numbers 배열 원소의 값은 0 이상 9 이하인 정수입니다.
hand는 "left" 또는 "right" 입니다.
"left"는 왼손잡이, "right"는 오른손잡이를 의미합니다.
왼손 엄지손가락을 사용한 경우는 L, 오른손 엄지손가락을 사용한 경우는 R을
순서대로 이어붙여 문자열 형태로 return 해주세요.
 */

/*
[1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5]	"right"	"LRLLLRLLRRL"
[7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2]	"left"	"LRLLRRLLLRR"
[1, 2, 3, 4, 5, 6, 7, 8, 9, 0]	"right"	"LLRLLRLLRL"
 */
/*
1 2 3
4 5 6
7 8 9
* 0 #

1 4 7 - 왼손
3 6 9 - 오른손
2 5 8 0 - 거리 확인해야 함
택시기하학으로 |x1-x2| + |y1-y2|
 */

public class Kakao_PushKeypad {

	public static void main(String[] args) {
		int[] numbers1 = { 1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5 };
		String hand1 = "right";
		int[] numbers2 = { 7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2 };
		String hand2 = "left";
		int[] numbers3 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0 };
		String hand3 = "right";
		
		System.out.println(Solution.solution(numbers1, hand1));
		System.out.println(Solution.solution(numbers2, hand2));
		System.out.println(Solution.solution(numbers3, hand3));
	}

}

class Solution {
	static int[][] key = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { 11, 0, 12 } };
	// 키패드 배열 저장, *과 #은 인트로 변환하여 임의로 11, 12 부여

	public static String solution(int[] numbers, String hand) {
		StringBuffer sb = new StringBuffer();
		int nowLeft = 11; // 현재 왼손의 위치
		int nowRight = 12; // 현재 오른손의 위치
		for (int i = 0; i < numbers.length; i++) {
			int now = numbers[i]; // 현재 입력할 숫자를 저장
			if (now == 1 || now == 4 || now == 7) { // 왼쪽열은 무조건 왼손으로
				sb.append("L");
				nowLeft = now;
			} else if (now == 3 || now == 6 || now == 9) { // 오른쪽열은 무조건 오른손
				sb.append("R");
				nowRight = now;
			} else { // 가운데 숫자이면 거리및 주로 사용하는 손 체크
				if (getPosion(nowLeft, nowRight, now) < 0) {
					sb.append("L");
					nowLeft = now;
				} else if (getPosion(nowLeft, nowRight, now) > 0) {
					sb.append("R");
					nowRight = now;
				} else { // 거리가 같을 경우 사용 손 체크
					if (hand.equals("left")) {
						sb.append("L");
						nowLeft = now;
					} else {
						sb.append("R");
						nowRight = now;
					}
				}
			}
		}
//		System.out.println(sb);
		return sb.toString();
	}

	private static int getPosion(int nowLeft, int nowRight, int now) {
		// 경우의 수가 3가지이므로 int형으로 반환
		int[] leftPosition = new int[2];	// 현재 왼손의 좌표 저장
		int[] rightPostion = new int[2];	// 현재 오른손의 좌표 저장
		int[] nowPosition = new int[2];		// 눌려야 할 숫자 좌표 저장
		for (int i = 0; i < key.length; i++) {
			for (int j = 0; j < key[i].length; j++) {
				if (key[i][j] == nowLeft) {
					leftPosition[0] = i;
					leftPosition[1] = j;
				} else if (key[i][j] == nowRight) { // 양손이 같은 위치에 있을 수 없음
					rightPostion[0] = i;
					rightPostion[1] = j;
				}
				if (key[i][j] == now) { // 거리가 0일 경우도 있기때문에 else if 안씀
					nowPosition[0] = i;
					nowPosition[1] = j;
				}
			}
		}
		int nlp = Math.abs(leftPosition[0] - nowPosition[0]) + Math.abs(leftPosition[1] - nowPosition[1]);
		// 현재 손위치와 눌려야할 번호 위치 택시기하학으로 거리 체크 
		int nrp = Math.abs(rightPostion[0] - nowPosition[0]) + Math.abs(rightPostion[1] - nowPosition[1]);
		if (nlp < nrp)
			return -1; // 왼손이 가까우면 음수
		else if (nlp > nrp)
			return 1; // 오른손이 가까우면 양수
		return 0; // 거리가 같으면 0
	}
}