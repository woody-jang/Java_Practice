import java.io.*;

/*
문제
N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.

입력
첫째 줄에 수의 개수 N(1 ≤ N ≤ 10,000,000)이 주어진다. 둘째 줄부터 N개의 줄에는 숫자가 주어진다.
이 수는 10,000보다 작거나 같은 자연수이다.

출력
첫째 줄부터 N개의 줄에 오름차순으로 정렬한 결과를 한 줄에 하나씩 출력한다.
 */

// 문제에서 counting sort를 이용하라해서 개념을 찾아봄
// counting sort란 말그대로 배열의 각 값을 카운팅해서 배열에 저장해줌
// 저장한 값들을 순차적으로 더해서 각 숫자의 마지막 index값으로 바꿔줌
// 그리고 새로운 배열을 생성해서 기존 배열의 맨 뒤부터 순서대로 내려오면서
// index가 저장된 배열에서 해당하는 숫자의 index를 찾아 넣어주고
// 숫자 하나가 들어갔으므로 index는 -- 해줌

public class CountingSort10989 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int count = Integer.parseInt(br.readLine()); // 입력받을 숫자 갯수 입력 받음
		int[] inputNumbers = new int[count]; // 숫자 갯수 크기의 int 배열 생성

		inputNumbers(inputNumbers, count, br); // 배열에 숫자를 추가해줌

		int[] newNumbers = countSort(inputNumbers); // sort한 배열을 저장할 새로운 배열 생성

		for (int i : newNumbers)
			bw.write(i + "\n"); // 배열의 값 하나씩 출력
		bw.flush();
	}

	private static int[] countSort(int[] inputNumbers) {
		int[] countChk = new int[10001]; // 숫자 범위가 10000이하 자연수이므로 0~10000까지 총 10001개의 index를 저장할 배열 생성
		
		makeCountChk(inputNumbers, countChk); // 배열에 들어있는 각 숫자를 카운팅후, 더해서 마지막 index로 만들어줌
		
		return sortByCount(inputNumbers, countChk); // 정렬된 배열을 return
	}

	private static int[] sortByCount(int[] inputNumbers, int[] countChk) {
		int[] newNumbers = new int[inputNumbers.length]; // 정렬후 저장할 새로운 배열 생성
		for (int i = inputNumbers.length - 1; i >= 0; i--) { // 기존 배열을 역순으로 확인
			int tmp = inputNumbers[i]; // 현재 숫자를 임시로 저장
			newNumbers[countChk[tmp] - 1] = tmp; // 새로운 배열의 countChk를 확인해서 저장된 새배열에
			countChk[tmp]--; // 저장된 인덱스 위치에 값을 넣어주고 인덱스는 --
			
		}
		return newNumbers;
	}

	private static void makeCountChk(int[] inputNumbers, int[] countChk) {
		int max = 0; // 처음에 배열을 생성할때 10001로 해서 반복이 많아지므로 최대값을 뽑아서
		for (int i : inputNumbers) { // 나중에 반복할때 최대값만큼만 반복하기 위함
			countChk[i]++; // 인덱스 체크용 배열의 기존 배열 숫자들의 인덱스에 1씩 더해줌
			if (i > max) // 최대값 저장
				max = i;
		}
		for (int i = 1; i <= max; i++) { // 최대숫자 까지만 반복해서 안에 들어있는 각각의 카운트를 더해
			countChk[i] += countChk[i - 1]; // 새로운 배열에 저장할 수 있도록 index로 변환해줌
		}
	}

	// 숫자를 입력받아 배열에 순서대로 저장
	private static void inputNumbers(int[] inputNumbers, int count, BufferedReader br) throws IOException {
		for (int i = 0; i < count; i++)
			inputNumbers[i] = Integer.parseInt(br.readLine());
	}

}
