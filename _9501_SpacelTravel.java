import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
문제
꿍은 우주여행을 하고 싶어져서 우주여행을 계획하기 시작했다.
몇 가지를 고려해본 결과 우주여행에는 우주선의 연료와
목적지까지의 도착시간이 가장 큰 영향을 미치는것으로 파악됐다.
꿍은 엄청난 부자여서 우주선이 여러대가 있는데 각각의 우주선마다 최고속도와 연료소비율이 조금씩 다르다.
연료 소비율은 단위시간당 소비하는 연료의 양이다.

모든 우주선이 최고속도에 즉시 도달한다고 할 때 꿍이 가고싶어하는 곳까지 여행할 수 있는
우주선은 총 몇대인지 여러분이 대신 구해줘라.
 */

/*
입력
입력은 테스트케이스의 개수 T (1 ≤ T ≤ 50)로 시작한다.

각 테스트케이스는 공백으로 구분되는, 우주선의 개수 N (1 ≤ N ≤ 100)과
목적지 까지의 거리 D (1 ≤ D ≤ 106), 두 개의 정수로 시작한다.
다음 N줄에는 각각 공백으로 구분되는, 우주선의 최고속도 vi (1 ≤ vi ≤ 1000)와
우주선의 연료양 fi (1 ≤ fi ≤ 1000)와 우주선의 연료소비율 ci (1 ≤ ci ≤ 1000), 세개의 정수가 주어진다.

출력
각 테스트케이스에 대해 목적지까지 갈 수 있는 우주선의 개수를 구하여라.

이때, 정수의 나눗셈에 조심하라!
 */

/*
예제 입력 1 
2
3 100
52 75 10
88 13 44
56 9 5
2 920368
950 950 1
943 976 1
예제 출력 1 
2
1
 */
public class _9501_SpacelTravel {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		try {
			int countOfProblem = Integer.parseInt(br.readLine());
			StringBuffer sb = new StringBuffer();

			for (int i = 0; i < countOfProblem; i++) {
				st = new StringTokenizer(br.readLine());
				int countOfShip = Integer.parseInt(st.nextToken());
				int distance = Integer.parseInt(st.nextToken());
				int countOfAvailable = 0; // 가능한 우주선 수를 저장할 변수

				for (int j = 0; j < countOfShip; j++) {
					st = new StringTokenizer(br.readLine());
					int vi = Integer.parseInt(st.nextToken());
					int fi = Integer.parseInt(st.nextToken());
					int ci = Integer.parseInt(st.nextToken());

					// double로 선언해서 정확하게 갈수 있는 거리를 확인해야함
					double gasAvailable = (double) fi / ci;

					// 최고속도와 거리를 곱합값이 거리보다 크면 여행 가능
					if (vi * gasAvailable >= distance)
						countOfAvailable++;
				}
				sb.append(countOfAvailable + "\n");
			}
			System.out.println(sb);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}