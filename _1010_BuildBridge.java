import java.io.*;
import java.util.StringTokenizer;

/*
문제
재원이는 한 도시의 시장이 되었다.
이 도시에는 도시를 동쪽과 서쪽으로 나누는 큰 일직선 모양의 강이 흐르고 있다.
하지만 재원이는 다리가 없어서 시민들이 강을 건너는데 큰 불편을 겪고 있음을 알고 다리를 짓기로 결심하였다.
강 주변에서 다리를 짓기에 적합한 곳을 사이트라고 한다.
재원이는 강 주변을 면밀히 조사해 본 결과 강의 서쪽에는 N개의 사이트가 있고
동쪽에는 M개의 사이트가 있다는 것을 알았다. (N ≤ M)

재원이는 서쪽의 사이트와 동쪽의 사이트를 다리로 연결하려고 한다.
(이때 한 사이트에는 최대 한 개의 다리만 연결될 수 있다.)
재원이는 다리를 최대한 많이 지으려고 하기 때문에
서쪽의 사이트 개수만큼 (N개) 다리를 지으려고 한다.
다리끼리는 서로 겹쳐질 수 없다고 할 때
다리를 지을 수 있는 경우의 수를 구하는 프로그램을 작성하라.
 */

/*
입력
입력의 첫 줄에는 테스트 케이스의 개수 T가 주어진다.
그 다음 줄부터 각각의 테스트케이스에 대해 강의 서쪽과 동쪽에 있는 사이트의 개수
정수 N, M (0 < N ≤ M < 30)이 주어진다.

출력
각 테스트 케이스에 대해 주어진 조건하에 다리를 지을 수 있는 경우의 수를 출력한다.
 */

/*
예제 입력 1 
3
2 2
1 5
13 29
예제 출력 1 
1
5
67863915
 */

// 조합으로 풀기
// nCr = n! / (r! * (n - r)!)

public class _1010_BuildBridge {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		try {
			int count = Integer.parseInt(br.readLine());
			while (count-- > 0) {
				st = new StringTokenizer(br.readLine());
				int westSite = Integer.parseInt(st.nextToken());
				int eastSite = Integer.parseInt(st.nextToken());
				bw.write(getBridegeCount(westSite, eastSite) + "\n");
			}
			bw.flush();
		} catch (IOException e) {
		}
		try {
			bw.close();
			br.close();
		} catch (IOException e) {
		}
	}

	private static long getBridegeCount(int westSite, int eastSite) {
		long count = 1;
		if (westSite == eastSite) // 양쪽의 site 갯수가 같다면 방법은 하나밖에 없음
			return count;
		if (westSite == 1) // westSite가 1이라면 eastSite 만큼의 경우의 수가 있음
			return eastSite;
		for (int i = Math.max(westSite, eastSite - westSite) + 1; i <= eastSite; i++) {
			count *= i; // 조합은 팩토리얼을 나누는게 있어서 계산과정에서
		} // n이나 n-r중 큰수의 +1부터 시작
		long temp = 1; // for문에서 큰수는 이미 나눴기 때문에 작은수의 팩토리얼을 구할 변수
		if (westSite < eastSite - westSite) { // n-r이 r보다 크다면
			for (int i = 1; i <= westSite; i++) { // r!을 구함
				temp *= i;
			}
		} else {
			for (int i = 1; i <= eastSite - westSite; i++) { // (n - r)!을 구함
				temp *= i;
			}
		}
		count /= temp; // 구한 팩토리얼을 나눠줌
		return count;
	}
}