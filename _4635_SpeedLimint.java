import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
문제
Bill and Ted are taking a road trip. But the odometer in their car is broken,
so they don't know how many miles they have driven.
Fortunately, Bill has a working stopwatch, so they can record their speed and the total time they have driven.
Unfortunately, their record keeping strategy is a little odd,
so they need help computing the total distance driven.
You are to write a program to do this computation.

For example, if their log shows

Speed in miles per hour	Total elapsed time in hours
20	2
30	6
10	7
this means they drove 2 hours at 20 miles per hour,
then 6-2=4 hours at 30 miles per hour, then 7-6=1 hour at 10 miles per hour.
The distance driven is then (2)(20) + (4)(30) + (1)(10) = 40 + 120 + 10 = 170 miles.
Note that the total elapsed time is always since the beginning of the trip,
not since the previous entry in their log.
 */

/*
입력
The input consists of one or more data sets.
Each set starts with a line containing an integer n, 1 ≤ n ≤ 10, 
followed by n pairs of values, one pair per line.
The first value in a pair, s, is the speed in miles per hour and the second value,
t, is the total elapsed time. Both s and t are integers, 1 ≤ s ≤ 90 and 1 ≤ t ≤ 12.
The values for t are always in strictly increasing order. A value of -1 for n signals the end of the input.

출력
For each input set, print the distance driven, followed by a space, followed by the word "miles". 
 */

/*
예제 입력 1 
3
20 2
30 6
10 7
2
60 1
30 5
4
15 1
25 2
30 3
10 5
-1
예제 출력 1 
170 miles
180 miles
90 miles
 */
public class _4635_SpeedLimint {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		try {
			StringBuffer sb = new StringBuffer();
			while (true) {
				int countOfProblem = Integer.parseInt(br.readLine().trim());
				int distance = 0; // 거리를 저장할 변수 선언

				if (countOfProblem == -1) // -1이 입력되면 무한루프 종료
					break;

				int lastTime = 0; // 마지막 입력받은 시간을 저장할 변수
				for (int i = 0; i < countOfProblem; i++) {
					st = new StringTokenizer(br.readLine());
					int speed = Integer.parseInt(st.nextToken());
					int time = Integer.parseInt(st.nextToken());

					distance += (time - lastTime) * speed; // 현재시간 - 마지막시간에 속도를 곱하면 현재의 이동거리
					lastTime = time; // 주어진 시간이 누적값이므로 마지막시간에 대입 함
				}
				sb.append(distance + " miles\n");
			}
			System.out.println(sb);
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}