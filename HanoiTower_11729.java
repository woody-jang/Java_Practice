import java.util.Scanner;


/*
 * 하노이탑 이동순서 및 이동횟수 구하는 예제
 * 백준 11729번 문제
 * 
 * 일단 처음 보는 알고리즘이라
 * 처음엔 엑셀로 직접 옮겨봄
 * 옮기다보니 규칙이 보이고 횟수도 구해짐
 * n을 옮기는 횟수는 n-1을 옮기는 횟수 * 2 + 1이었음
 * 계산하다보니 2^n - 1이 나옴
 * 횟수는 완료하였고 이동방법을 고민하다보니
 * 처음 접한 재귀가 피보나치 수열이었기때문에
 * 피보나치 수열과 접목해서 재귀함수로 바꾸는 방법 생각 해봄
 * 만약 abc 3개를 옮긴다면
 * ab를 2번으로 옮기고
 * c를 1번에서 3번으로 옮기면 됨
 * 그리고 남은 ab를 같은 식으로 옮기면 됨
 * 자세히 보면 ab를 2번으로 옮기는게
 * ab를 원하는 지점으로 옮기는것과 목적지만 다를뿐 같은 횟수임
 * 결국 하노이탑도 n - 1개의 원반을 중간지점으로 옮기면
 * n번째 원반을 원하는 지점으로 옮길 수 있음
 * 이렇게 접근한다면 시작지점과 옮길지점 경유지점을 크로스하면
 * 재귀 함수로 표현이 가능해짐
 */

public class HanoiTower_11729 {
	static StringBuffer sb = new StringBuffer();

	static void hanoi(int N, int start, int arrive, int middle) {
	    if (N == 1) // 원반이 하나만 남았을때는
	        tracking(start, arrive); // 현재 원반의 위치에서 목적지로 넘겨주면 끝남
	    else {
	        hanoi(N-1, start, middle, arrive); // n을 목적지로 보내기 위해 n-1까지 경유지로 보냄
	        tracking(start, arrive); // 이동 궤적을 남김
	        hanoi(N-1, middle, arrive, start); // n이 목적지로 갔기 때문에 n-1까지를
	        								   // 경유지에서 시작점을 통해서 목적지로 보내면 끝남
	    }
	}
	
	static void tracking(int start, int arrive) {
	    sb.append(start + " " + arrive + "\n");  // 이동 궤적을 저장
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		// 총 이동횟수 구함
		int k = (int) Math.pow(2, n) - 1;
		sb.append(k + "\n");
		
		hanoi(n, 1, 3, 2); // 출발점과 도착점 경유지를 넘겨줌
		
		System.out.println(sb);

		sc.close();
	}
}
