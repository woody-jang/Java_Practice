import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
문제
알파벳 소문자로 이루어진 N개의 단어가 들어오면 아래와 같은 조건에 따라 정렬하는 프로그램을 작성하시오.
1. 길이가 짧은 것부터
2. 길이가 같으면 사전 순으로

입력
첫째 줄에 단어의 개수 N이 주어진다. (1 ≤ N ≤ 20,000)
둘째 줄부터 N개의 줄에 걸쳐 알파벳 소문자로 이루어진 단어가 한 줄에 하나씩 주어진다.
주어지는 문자열의 길이는 50을 넘지 않는다.

출력
조건에 따라 정렬하여 단어들을 출력한다.
단, 같은 단어가 여러 번 입력된 경우에는 한 번씩만 출력한다.
 */

/*
예제 입력 1 
13
but
i
wont
hesitate
no
more
no
more
it
cannot
wait
im
yours
예제 출력 1 
i
im
it
no
but
more
wait
wont
yours
cannot
hesitate
 */

// 11650, 11651 좌표 정렬과 마찬가지로 list에 담아
// comparator를 지정해서 정렬 - 이번엔 익명 클래스가 아닌 새로운 클래스로 정렬해보기
// 같은 단어는 list에 담으면서 거르기

class MyComparator implements Comparator<String> {
	@Override
	public int compare(String o1, String o2) {
		if (o1.length() == o2.length()) // 길이가 같다면
			return o1.compareTo(o2); // 사전순 정렬
		else
			return o1.length() - o2.length(); // 아니라면 길이순 정렬
	}
}

public class SortWords1181 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int count = Integer.parseInt(br.readLine());
		List<String> inputWords = new ArrayList<>();

		// list에 단어를 입력받아 저장
		getStringList(inputWords, count, br);

		// 직접 만든 MyComparator로 정렬
		Collections.sort(inputWords, new MyComparator());

		for (String str : inputWords) {
			bw.write(str + "\n"); // 순서대로 꺼내서 출력하기
		}

		bw.flush();
	}

	private static void getStringList(List<String> inputWords, int count, BufferedReader br) throws IOException {
		for (int i = 0; i < count; i++) {
			String temp = br.readLine(); // 현재 넣을 단어 임시로 저장
			if (!inputWords.contains(temp)) // list에 현재 넣을 단어가 없다면
				inputWords.add(temp); // 추가
		}
	}
}