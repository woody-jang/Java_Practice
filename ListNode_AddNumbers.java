import java.util.ArrayList;
import java.util.List;

/*
You are given two non-empty linked lists representing two non-negative integers.
The digits are stored in reverse order, and each of their nodes contains a single digit.
Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example 1:
Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.

Example 2:
Input: l1 = [0], l2 = [0]
Output: [0]

Example 3:
Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]
 

Constraints:

The number of nodes in each linked list is in the range [1, 100].
0 <= Node.val <= 9
It is guaranteed that the list represents a number that does not have leading zeros.
 */

/*
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */


/*
 LeetCode 2번 Add Two Numbers 문제
 문제에서 ListNode라는 연결된 리스트 클래스를 만들어 놓음
 주어진 l1과 l2를 더해서 새로운 객체에 넣어서 반환해야됨
 생각해보면 stack 구조라서 객체에 저장된 다음 객체를 확인만 하면 쉬운 문제
 이전에 stack을 직접 구현해봐서 개념을 알고있었음
 */
class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
 
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        List<Integer> list = new ArrayList<>(); // 우선 각 숫자를 더해서 저장할 용도
        boolean chkl1 = true; // ListNode에 다음 객체가 있는지 없는지 검사할 용도
        boolean chkl2 = true;
        while (chkl1 || chkl2){ // 둘다 다음 객체가 없으면 while문 탈출
            if(chkl1){
                if (chkl2) // 둘다 현재 객체가 있는 상태이므로 더해서 add
                    list.add(l1.val + l2.val);
                else
                    list.add(l1.val); // l1만 현재 객체가 있으므로 l1값만 add
            }
            else{
                if (chkl2)
                    list.add(l2.val); // l2만 현재 객체가 있으므로 l2값만 add
            }
            if (l1.next == null)
                chkl1 = false; // l1의 다음값이 없다면 false로 바꿔서 NullPoint 에러 안나게
            else
                l1 = l1.next; // 다음 객체가 있다면 l1을 next로 바꿈
            if (l2.next == null)
                chkl2 = false;
            else
                l2 = l2.next;
            
        }
        ListNode answer = new ListNode(); // return할 객체 생성
        boolean over10 = false; // 10이상일 경우 다음값에 1을 더해주기 위해 boolean 생성
        for (int i = 0; i < list.size(); i++){ // 이제 ListNode의 체인 길이가 list에 저장되어 있기 때문에 list 크기만큼 반복
        	int sum = list.get(i);
            if (over10){ // 이전 값이 10 이상이면
                list.set(i, ++sum); // 현재 값에 1을 더해줌
                over10 = false; // boolean 값은 초기화
            }
            if (sum > 9){ // 현재 값이 10 이상이면
                list.set(i, sum - 10); // 현재 값을 10을 뺀후
                over10 = true; // 다음값에 1을 더해주기위해 true로 변경
                if (i == list.size() - 1) { // 마지막값이 10이상이면 1을 추가해줘야 함
                	list.add(1);
                	over10 = false; // 추가해서 for문을 한번더 돌때 1증가 막기위해 false
                }
            }
        }
        for (int i = list.size() - 1; i >= 0; i--) {
            if (i == list.size() - 1){ // 첫번째 객체는 next가 null이기 때문에 따로 빼야함
                answer.val = list.get(i); // 위에서 객체 생성했으므로 val 값만 수정해주면 됨
            }
            else{ // 첫번째 이후 부터는 현재의 값과 이전의 객체(나)를 담아서 새로운 객체 생성
                answer = new ListNode(list.get(i), answer);
            }
        }
        return answer;
    }
}

public class ListNode_AddNumbers {

	public static void main(String[] args) {
		ListNode l1 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))))));
		ListNode l2 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))));
		ListNode result = (new Solution()).addTwoNumbers(l1, l2);
		while (result != null) {
			System.out.println(result.val);
			result = result.next;
		}
	}

}
