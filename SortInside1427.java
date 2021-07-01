import java.util.Arrays;
import java.util.Scanner;

/*
문제
배열을 정렬하는 것은 쉽다. 수가 주어지면, 그 수의 각 자리수를 내림차순으로 정렬해보자.

입력
첫째 줄에 정렬하고자하는 수 N이 주어진다. N은 1,000,000,000보다 작거나 같은 자연수이다.

출력
첫째 줄에 자리수를 내림차순으로 정렬한 수를 출력한다.
 */

/*
예제 입력 1 
2143
예제 출력 1 
4321
 */
public class SortInside1427 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String inputNumberS = sc.nextLine(); // 아래에서 배열로 쪼갤려고 String으로 받음
		
		String[] numbersList = inputNumberS.split(""); // 각 숫자를 나누어서 배열로 저장
		
		Arrays.sort(numbersList); // 오름차순 정렬
		
		StringBuffer sb = new StringBuffer(); // 정렬한 배열을 담을 스트링퍼버 생성
		
		for(String str : numbersList) { sb.append(str); } // 배열을 스트링버퍼에 넣어줌

		System.out.println(sb.reverse().toString()); // 스트링버퍼의 reverse 메소드를 이용하여 내림차순으로 변경
		
	}

}
