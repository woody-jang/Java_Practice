import java.util.HashSet;
import java.util.Set;

/*
문제 설명
당신은 폰켓몬을 잡기 위한 오랜 여행 끝에, 홍 박사님의 연구실에 도착했습니다.
홍 박사님은 당신에게 자신의 연구실에 있는 총 N 마리의 폰켓몬 중에서
N/2마리를 가져가도 좋다고 했습니다.
홍 박사님 연구실의 폰켓몬은 종류에 따라 번호를 붙여 구분합니다.
따라서 같은 종류의 폰켓몬은 같은 번호를 가지고 있습니다.
예를 들어 연구실에 총 4마리의 폰켓몬이 있고,
각 폰켓몬의 종류 번호가 [3번, 1번, 2번, 3번]이라면 이는 3번 폰켓몬 두 마리,
1번 폰켓몬 한 마리, 2번 폰켓몬 한 마리가 있음을 나타냅니다.
이때, 4마리의 폰켓몬 중 2마리를 고르는 방법은 다음과 같이 6가지가 있습니다.

첫 번째(3번), 두 번째(1번) 폰켓몬을 선택
첫 번째(3번), 세 번째(2번) 폰켓몬을 선택
첫 번째(3번), 네 번째(3번) 폰켓몬을 선택
두 번째(1번), 세 번째(2번) 폰켓몬을 선택
두 번째(1번), 네 번째(3번) 폰켓몬을 선택
세 번째(2번), 네 번째(3번) 폰켓몬을 선택
이때, 첫 번째(3번) 폰켓몬과 네 번째(3번) 폰켓몬을 선택하는 방법은
한 종류(3번 폰켓몬 두 마리)의 폰켓몬만 가질 수 있지만,
다른 방법들은 모두 두 종류의 폰켓몬을 가질 수 있습니다.
따라서 위 예시에서 가질 수 있는 폰켓몬 종류 수의 최댓값은 2가 됩니다.
당신은 최대한 다양한 종류의 폰켓몬을 가지길 원하기 때문에,
최대한 많은 종류의 폰켓몬을 포함해서 N/2마리를 선택하려 합니다.
N마리 폰켓몬의 종류 번호가 담긴 배열 nums가 매개변수로 주어질 때,
N/2마리의 폰켓몬을 선택하는 방법 중, 가장 많은 종류의 폰켓몬을 선택하는 방법을 찾아,
그때의 폰켓몬 종류 번호의 개수를 return 하도록 solution 함수를 완성해주세요.

제한사항
nums는 폰켓몬의 종류 번호가 담긴 1차원 배열입니다.
nums의 길이(N)는 1 이상 10,000 이하의 자연수이며, 항상 짝수로 주어집니다.
폰켓몬의 종류 번호는 1 이상 200,000 이하의 자연수로 나타냅니다.
가장 많은 종류의 폰켓몬을 선택하는 방법이 여러 가지인 경우에도,
선택할 수 있는 폰켓몬 종류 개수의 최댓값 하나만 return 하면 됩니다.
 */

/*
입출력 예
nums			result
[3,1,2,3]		2
[3,3,3,2,2,4]	3
[3,3,3,2,2,2]	2
 */

public class ChoosePocketmon {

	public static void main(String[] args) {
		int[] nums1 = { 3, 1, 2, 3 };
		int[] nums2 = { 3, 3, 3, 2, 2, 4 };
		int[] nums3 = { 3, 3, 3, 2, 2, 2 };
		System.out.println(new Solution().solution(nums1));
		System.out.println(new Solution().solution(nums2));
		System.out.println(new Solution().solution(nums3));
	}

}

class Solution {
	public static int solution(int[] nums) {
		// Set을 이용하여 중복을 제거한 종류를 저장함
		Set<Integer> setNums = new HashSet<Integer>();
		for (int i : nums) {
			setNums.add(i);
		}
		
		// 6마리중 3마리 즉 반만 들고 갈 수 있으므로
		// 중복을 제거한 종류가 반보다 작다면
		// 가져갈 수 있는 종류는 set에 들어있는 갯수
		if (nums.length / 2 > setNums.size())
			return setNums.size();
		// 중복을 제거한 종류가 반보다 많다면
		// 들고갈 수 있는 종류는 반만큼
		else
			return nums.length / 2;
		
//		int answer = 1; // 무조건 한종류는 들고가기때문에 1로 초기화
//		int choice = nums.length / 2 - 1; // 1로 초기화 했으므로 -1
//		Arrays.sort(nums); // 정렬해서 확인해야지 이전값과 비교 가능
//		int last = nums[0]; // 첫번째 포켓몬은 무조건 들고가므로 마지막 담은 포켓몬은 0번째
//		for (int i : nums) {
//			if (last != nums[i]) { // 이전값과 현재값이 다르면(서로 다른 종류라면)
//				last = nums[i]; // 마지막에 현재값 저장
//				answer++; // 종류수 1 증가
//				choice--; // 선택은 1 감소
//			}
//		  	if (choice == 0) // 만약 for문이 끝나기전에 선택이 0 이 되면 이미 종류가 더 많으므로
//			    break; // for문 탈출
//		}
		 
	}
}