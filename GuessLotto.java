import java.util.Arrays;

// 프로그래머스 로또 순위 구하기

/*
순위	당첨 내용
1		6개 번호가 모두 일치
2		5개 번호가 일치
3		4개 번호가 일치
4		3개 번호가 일치
5		2개 번호가 일치
6(낙첨)	그 외
 */

/*
민우가 구매한 로또 번호를 담은 배열 lottos, 당첨 번호를 담은 배열 win_nums가 매개변수로 주어집니다.
이때, 당첨 가능한 최고 순위와 최저 순위를 차례대로 배열에 담아서 return 하도록 solution 함수를 완성해주세요.

제한사항
lottos는 길이 6인 정수 배열입니다.
lottos의 모든 원소는 0 이상 45 이하인 정수입니다.
0은 알아볼 수 없는 숫자를 의미합니다.
0을 제외한 다른 숫자들은 lottos에 2개 이상 담겨있지 않습니다.
lottos의 원소들은 정렬되어 있지 않을 수도 있습니다.
win_nums은 길이 6인 정수 배열입니다.
win_nums의 모든 원소는 1 이상 45 이하인 정수입니다.
win_nums에는 같은 숫자가 2개 이상 담겨있지 않습니다.
win_nums의 원소들은 정렬되어 있지 않을 수도 있습니다.
 */

/*
lottos					win_nums					result
[44, 1, 0, 0, 31, 25]	[31, 10, 45, 1, 6, 19]		[3, 5]
[0, 0, 0, 0, 0, 0]		[38, 19, 20, 40, 15, 25]	[1, 6]
[45, 4, 35, 20, 3, 9]	[20, 9, 3, 45, 4, 35]		[1, 1]
 */

// 0은 true / false 두가지이기때문에 최고 최저는 0 갯수와 맞는 갯수
// 0 갯수 확인하고 0이 아닌것중에 맞는 갯수 확인
// 정렬하면 편하게 비교 가능(안하면 for 루프 끝까지 돌아야함)
public class GuessLotto {

	public static void main(String[] args) {
		int[] lottos1 = { 44, 1, 0, 0, 31, 25 };
		int[] win_nums1 = { 31, 10, 45, 1, 6, 19 };
		int[] lottos2 = { 0, 0, 0, 0, 0, 0 };
		int[] win_nums2 = { 38, 19, 20, 40, 15, 25 };
		int[] lottos3 = { 45, 4, 35, 20, 3, 9 };
		int[] win_nums3 = { 20, 9, 3, 45, 4, 35 };

		for (int i : Solution.solution(lottos1, win_nums1)) {
			System.out.print(i + " ");
		}
		System.out.println();
		for (int i : Solution.solution(lottos2, win_nums2)) {
			System.out.print(i + " ");
		}
		System.out.println();
		for (int i : Solution.solution(lottos3, win_nums3)) {
			System.out.print(i + " ");
		}
	}
}

class Solution {
	static public int[] solution(int[] lottos, int[] win_nums) {
		int[] score = { 6, 6, 5, 4, 3, 2, 1 }; // index로 등수 뽑아낼 용도
		int[] answer = new int[2];
		Arrays.sort(lottos); // 순서가 무작위이기 때문에 정렬하여 비교
		Arrays.sort(win_nums);
//		for (int i : lottos) {
//			System.out.println(i);
//		}
//		for (int i : win_nums) {
//			System.out.println(i);
//		}
		int cnt0 = 0; // 지워진번호 카운트
		int cnt = 0; // 지워지지 않은 번호중에 당첨번호인것 카운트
		int j = 0;	// win_nums 확인하기위한 index용
		for (int i : lottos) {
			if (i == 0) {
				cnt0++;
			} else { // 0인 경우는 win_nums 안봐도 되기때문에 else로 묶음
				for (; j < 6; j++) { // 이미 봤던 win_nums는 다시 안봄. j 초기화 x
					if (i == win_nums[j]) {
						cnt++;
						// System.out.println(i + " " + j);
						j++; // 바로 탈출하기 때문에 직접 index 1 증가
						break;
					}
					if (i < win_nums[j]) // win_nums가 더 크면 lottos에 win_nums가
						break;			// 있을수 있으므로 j 증가 없이 탈출
				}
			}
		}
		int cntt = cnt + cnt0; // 최고등수용 카운트
//		System.out.println(cnt + "-" + cntt);
		answer[0] = score[cntt];
		answer[1] = score[cnt];

		return answer;
	}
}
