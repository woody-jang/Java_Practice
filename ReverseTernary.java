import java.util.ArrayList;

/*
문제 설명
자연수 n이 매개변수로 주어집니다.
n을 3진법 상에서 앞뒤로 뒤집은 후,
이를 다시 10진법으로 표현한 수를 return 하도록 solution 함수를 완성해주세요.

제한사항
n은 1 이상 100,000,000 이하인 자연수입니다.
 */

/*
입출력 예
n		result
45		7
125		229
 */
public class ReverseTernary {

	public static void main(String[] args) {
		int n1 = 45;
		int n2 = 125;
		System.out.println(Solution.solution(n1));
		System.out.println(Solution.solution(n2));
	}

}

class Solution {
    public static long solution(int n) {
    	// 주어진 숫자를 3진수로 바꿔 저장할 list 선언
        ArrayList<Integer> tmp = new ArrayList<Integer>();
		long answer = 0;
        int a; // 3진수로 연산하기 위해 변수 하나 선언
        while(n > 0){ // n이 0이되면 3진수 변환이 완료 됨
            a = n % 3; // a에 3으로 나눈 나머지를 넣어주고
            n /= 3; // n은 3으로 나눈 몫으로 바꾼 후
            tmp.add(a); // 3으로 나눈 나머지인 a를 list에 추가
        }
        //System.out.println(tmp);
        // list에 추가함으로 자동으로 뒤집혀졌기 때문에 하나씩 뽑으면서 바로 더해줌
        for (int i = 0; i < tmp.size(); i++){
        	// 리스트의 첫번째가 3의 길이 - 1 만큼의 제곱임
            answer += tmp.get(i) * (long)Math.pow(3, tmp.size() - 1 - i);
        }
        return answer;
    }
}
