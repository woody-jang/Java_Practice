import java.util.Scanner;

/*
문제
Bath’s annual Christmas market runs from the 23rd of November 2017 until the 10th of December 2017.
During this time, the market will occupy the entire square courtyard of Bath Abbey.

To brighten things up at night, a single long strand of cheerful festive lights
will be run along all four equally long edges of the courtyard.

You will be in charge of buying the electrical wiring to which the lights will be affixed.
How much will you need to use to outline the whole Christmas market with festive lights?
 */

/*
입력
The input consists of:

One line with an integer a (1 ≤ a ≤ 1018), the area in square metres of the yard.
출력
Output the total length of electrical wiring needed for the market, in metres.
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

public class _15610_AbbeyCourtyard {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double squareMetres = sc.nextDouble();
		System.out.println(Math.sqrt(squareMetres) * 4);
	}
}