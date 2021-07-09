import java.util.ArrayList;
import java.util.Arrays;

/*
카카오톡 게임별의 하반기 신규 서비스로 다트 게임을 출시하기로 했다.
다트 게임은 다트판에 다트를 세 차례 던져 그 점수의 합계로 실력을 겨루는 게임으로,
모두가 간단히 즐길 수 있다.
갓 입사한 무지는 코딩 실력을 인정받아 게임의 핵심 부분인 점수 계산 로직을 맡게 되었다.
다트 게임의 점수 계산 로직은 아래와 같다.

다트 게임은 총 3번의 기회로 구성된다.
각 기회마다 얻을 수 있는 점수는 0점에서 10점까지이다.
점수와 함께 Single(S), Double(D), Triple(T) 영역이 존재하고
각 영역 당첨 시 점수에서 1제곱, 2제곱, 3제곱 (점수1 , 점수2 , 점수3 )으로 계산된다.
옵션으로 스타상(*) , 아차상(#)이 존재하며 스타상(*) 당첨 시
해당 점수와 바로 전에 얻은 점수를 각 2배로 만든다.
아차상(#) 당첨 시 해당 점수는 마이너스된다.
스타상(*)은 첫 번째 기회에서도 나올 수 있다.
이 경우 첫 번째 스타상(*)의 점수만 2배가 된다. (예제 4번 참고)
스타상(*)의 효과는 다른 스타상(*)의 효과와 중첩될 수 있다.
이 경우 중첩된 스타상(*) 점수는 4배가 된다. (예제 4번 참고)
스타상(*)의 효과는 아차상(#)의 효과와 중첩될 수 있다. 
이 경우 중첩된 아차상(#)의 점수는 -2배가 된다. (예제 5번 참고)
Single(S), Double(D), Triple(T)은 점수마다 하나씩 존재한다.
스타상(*), 아차상(#)은 점수마다 둘 중 하나만 존재할 수 있으며, 존재하지 않을 수도 있다.
0~10의 정수와 문자 S, D, T, *, #로 구성된 문자열이 입력될 시 총점수를 반환하는 함수를 작성하라.
 */

/*
입력 형식
"점수|보너스|[옵션]"으로 이루어진 문자열 3세트.
예) 1S2D*3T

점수는 0에서 10 사이의 정수이다.
보너스는 S, D, T 중 하나이다.
옵선은 *이나 # 중 하나이며, 없을 수도 있다.
출력 형식
3번의 기회에서 얻은 점수 합계에 해당하는 정수값을 출력한다.
예) 37
 */

/*
입출력 예제
예제	dartResult		answer	설명
1		1S2D*3T			37		1^1 * 2 + 2^2 * 2 + 3^3
2		1D2S#10S		9		1^2 + 2^1 * (-1) + 101
3		1D2S0T			3		1^2 + 2^1 + 03
4		1S*2T*3S		23		1^1 * 2 * 2 + 2^3 * 2 + 3^1
5		1D#2S*3S		5		1^2 * (-1) * 2 + 2^1 * 2 + 3^1
6		1T2D3D#			-4		1^3 + 2^2 + 3^2 * (-1)
7		1D2S3T*			59		1^2 + 2^1 * 2 + 3^3 * 2
 */

public class DartGame {

	public static void main(String[] args) {
		String a = "1S2D*3T";
		String b = "1D2S#10S";
		String c = "1D2S0T";
		String d = "1S*2T*3S";
		String e = "1D#2S*3S";
		String f = "1T2D3D#";
		String g = "1D2S3T*";
		
		System.out.println(Solution.solution(a));
		System.out.println(Solution.solution(b));
		System.out.println(Solution.solution(c));
		System.out.println(Solution.solution(d));
		System.out.println(Solution.solution(e));
		System.out.println(Solution.solution(f));
		System.out.println(Solution.solution(g));
	}

}

class Solution {
    public static int solution(String dartResult) {
        //String dartResult = "1D2S#10S";
		int answer = 0;
		int cnt = 0;
		String[] tmp = new StringBuffer(dartResult).reverse().toString().split("");
		// 10은 잘 되는데 5, 8번 런타임 에러.....
		ArrayList<String> rmtmp = new ArrayList<String>(Arrays.asList(tmp));
		for (int i = 0; i < rmtmp.size() - 1; i++) {
			if (rmtmp.get(i).equals("0") && rmtmp.get(i + 1).equals("1")) {
				rmtmp.set(i + 1, "10");
				rmtmp.remove(i);
				i--;
			}
		}
//		System.out.println(rmtmp);
		ArrayList<String> sList = new ArrayList<String>();
		sList.add("S");
		sList.add("D");
		sList.add("T");
		sList.add("*");
		sList.add("#");
		ArrayList<Integer> iList = new ArrayList<Integer>();
		boolean plus = false;
		for (int i = 0; i < rmtmp.size(); i++) {
			if (sList.contains(rmtmp.get(i))) {
				cnt++;
				continue;
			}
			/*
			if (tmp[i].equals("0") && tmp[i + 1].equals("1")) {
				tmp[i + 1] = "10";
                tmp[i] = "-1";
				continue;
			}
			*/
			String tmp1 = rmtmp.get(i - 1);
			if (tmp1.equals("D"))
				iList.add((int) Math.pow(Integer.parseInt(rmtmp.get(i)), 2));
			else if (tmp1.equals("T"))
				iList.add((int) Math.pow(Integer.parseInt(rmtmp.get(i)), 3));
			else if (tmp1.equals("S"))
				iList.add(Integer.parseInt(rmtmp.get(i)));
			int idx = iList.size() - 1;
			if (plus)
				iList.set(idx, iList.get(idx) * 2);
			plus = false;
			if (cnt == 2) {
				String tmp2 = rmtmp.get(i - 2);
				if (tmp2.equals("*")) {
					iList.set(idx, iList.get(idx) * 2);
					plus = true;
				}
				else {
					iList.set(idx, iList.get(idx) * -1);
				}
			}
			cnt = 0;
		}
		//System.out.println(iList);
		for (int i = 0; i < iList.size(); i++) {
			answer += iList.get(i);
		}
		//System.out.println(answer);
        return answer;
    }
}
