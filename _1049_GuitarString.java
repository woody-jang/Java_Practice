import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
문제
Day Of Mourning의 기타리스트 강토가 사용하는 기타에서 N개의 줄이 끊어졌다.
따라서 새로운 줄을 사거나 교체해야 한다. 강토는 되도록이면 돈을 적게 쓰려고 한다.
6줄 패키지를 살 수도 있고, 1개 또는 그 이상의 줄을 낱개로 살 수도 있다.

끊어진 기타줄의 개수 N과 기타줄 브랜드 M개가 주어지고,
각각의 브랜드에서 파는 기타줄 6개가 들어있는 패키지의 가격,
낱개로 살 때의 가격이 주어질 때, 적어도 N개를 사기 위해
필요한 돈의 수를 최소로 하는 프로그램을 작성하시오.

입력
첫째 줄에 N과 M이 주어진다. N은 100보다 작거나 같은 자연수이고, M은 50보다 작거나 같은 자연수이다.
둘째 줄부터 M개의 줄에는 각 브랜드의 패키지 가격과 낱개의 가격이 공백으로 구분하여 주어진다.
가격은 0보다 크거나 같고, 1,000보다 작거나 같은 정수이다.

출력
첫째 줄에 기타줄을 적어도 N개 사기 위해 필요한 돈의 최솟값을 출력한다.
 */

/*
예제 입력 1 
4 2
12 3
15 4
예제 출력 1 
12
예제 입력 2 
10 3
20 8
40 7
60 4
예제 출력 2 
36
예제 입력 3 
15 1
100 40
예제 출력 3 
300
 */
public class _1049_GuitarString {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int countOfBrokenString = Integer.parseInt(st.nextToken());
		int countOfBrand = Integer.parseInt(st.nextToken());

		// 낱개 가격의 최저가를 담을 변수
		int minPriceOfOne = Integer.MAX_VALUE;
		// 세트 가격의 최저가를 담을 변수
		int minPriceOfSet = Integer.MAX_VALUE;
		while (countOfBrand-- > 0) {
			st = new StringTokenizer(br.readLine());

			// 6줄 세트 가격을 담을 변수
			int priceOfSet = Integer.parseInt(st.nextToken());
			// 낱개 가격을 담을 변수
			int priceOfOne = Integer.parseInt(st.nextToken());

			// 각각 최저가를 담음
			minPriceOfOne = Math.min(minPriceOfOne, priceOfOne);
			minPriceOfSet = Math.min(minPriceOfSet, priceOfSet);
		}

		// 낱개로만 샀을때의 가격
		int totalPriceOne = countOfBrokenString * minPriceOfOne;

		// 세트로만 샀을때의 가격
		int totalPriceSet = countOfBrokenString / 6 * minPriceOfSet;
		if (countOfBrokenString % 6 != 0) // 무조건 6개 세트이기 때문에 나누어서 떨어지지 않으면
			totalPriceSet += minPriceOfSet; // 한세트를 더 사야함

		// 세트 + 낱개로 샀을때의 가격
		int totalPriceShuffle = countOfBrokenString / 6 * minPriceOfSet + countOfBrokenString % 6 * minPriceOfOne;

		System.out.println(Math.min(totalPriceOne, Math.min(totalPriceSet, totalPriceShuffle)));
	}
}
