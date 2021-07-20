import java.util.Scanner;

/*
문제
The atrium of a traditional Roman dormus, much like the atria of today,
is a perfectly square room designed for residents and guests to congregate in
and to enjoy the sunlight streaming in from above. Or, in the case of Britannia, the rain streaming in from above.

A major problem with traditional Roman architecture, particularly in modern times,
is the absence of any kind of effective walls between rooms.
You have arrived in Italy and now you are going to helpfully rebuild the walls on behalf of the authorities,
starting with the atrium of a particularly derelict building you found.

What length of prefabricated wall section must you bring with you to fully enclose the atrium of the building?
 */

/*
입력
The input consists of a single integer a (1 ≤ a ≤ 1018), the area in square meters of the Atrium.

출력
Output the total length of walling needed for the atrium, in metres.
The length should be accurate to an absolute or relative error of at most 10−6.
 */

/*
예제 입력 1 
64
예제 출력 1 
32.0
예제 입력 2 
1234
예제 출력 2 
140.51334456
 */
public class _20353_Atrium {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double squareMetres = sc.nextDouble();
		System.out.println(Math.sqrt(squareMetres) * 4);
	}
}