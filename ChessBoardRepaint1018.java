import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
문제
지민이는 자신의 저택에서 MN개의 단위 정사각형으로 나누어져 있는 M*N 크기의 보드를 찾았다.
어떤 정사각형은 검은색으로 칠해져 있고, 나머지는 흰색으로 칠해져 있다.
지민이는 이 보드를 잘라서 8*8 크기의 체스판으로 만들려고 한다.

체스판은 검은색과 흰색이 번갈아서 칠해져 있어야 한다.
구체적으로, 각 칸이 검은색과 흰색 중 하나로 색칠되어 있고,
변을 공유하는 두 개의 사각형은 다른 색으로 칠해져 있어야 한다.
따라서 이 정의를 따르면 체스판을 색칠하는 경우는 두 가지뿐이다.
하나는 맨 왼쪽 위 칸이 흰색인 경우, 하나는 검은색인 경우이다.

보드가 체스판처럼 칠해져 있다는 보장이 없어서,
지민이는 8*8 크기의 체스판으로 잘라낸 후에 몇 개의 정사각형을 다시 칠해야겠다고 생각했다.
당연히 8*8 크기는 아무데서나 골라도 된다. 지민이가 다시 칠해야 하는 정사각형의 최소 개수를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 N과 M이 주어진다. N과 M은 8보다 크거나 같고, 50보다 작거나 같은 자연수이다.
둘째 줄부터 N개의 줄에는 보드의 각 행의 상태가 주어진다. B는 검은색이며, W는 흰색이다.

출력
첫째 줄에 지민이가 다시 칠해야 하는 정사각형 개수의 최솟값을 출력한다.
 */

/*
예제 입력 1 
8 8
WBWBWBWB
BWBWBWBW
WBWBWBWB
BWBBBWBW
WBWBWBWB
BWBWBWBW
WBWBWBWB
BWBWBWBW
예제 출력 1 
1
예제 입력 2 
10 13
BBBBBBBBWBWBW
BBBBBBBBBWBWB
BBBBBBBBWBWBW
BBBBBBBBBWBWB
BBBBBBBBWBWBW
BBBBBBBBBWBWB
BBBBBBBBWBWBW
BBBBBBBBBWBWB
WWWWWWWWWWBWB
WWWWWWWWWWBWB
예제 출력 2 
12
 */

// 단순히 생각했을때 2차원 배열로 받아서 for문으로 반복하면 해결됨
// 한칸씩 옆으로 옮기면서 반복을 하면 최소값을 구할 수 있음
// 그리고 최대한 객체화를 하자!!!
// C에서 쓰던 습관을 버리자
// 누구나 알아볼 수 있는 변수명을 쓰자

public class ChessBoardRepaint1018 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int column = Integer.parseInt(st.nextToken());
		int row = Integer.parseInt(st.nextToken());
		char[][] chessBoard = new char[column][row];

		getDefaultChessBoard(chessBoard, br); // 기본 체스판 받아옴

		System.out.println(getRepaintCount(chessBoard));
	}

	public static void getDefaultChessBoard(char[][] chessBoard, BufferedReader br) throws IOException {
		for (int i = 0; i < chessBoard.length; i++) {
			String line = br.readLine();
			for (int j = 0; j < chessBoard[i].length; j++) {
				chessBoard[i][j] = line.charAt(j);
			}
		}
	}
	
	// 8 by 8 이 넘었을때 각 8 by 8로 쪼개서 최소값 구하는 메소드로 넘겨주기 위한 메소드
	public static int getRepaintCount(char[][] chessBoard) {
		int minRepaintCount = Integer.MAX_VALUE; // 최소값을 구하기때문에 max값으로 초기화
		for (int i = 0; i <= chessBoard.length - 8; i++) { // 8줄을 넘으면 한줄씩 증가하고
			for (int j = 0; j <= chessBoard[i].length - 8; j++) { // 8칸을 넘으면 한칸씩 증가하면서
				int repaintCount = eightByEight(chessBoard, i, j); // 해당칸을 0,0으로 생각해서 칠할 횟수 체크
				minRepaintCount = (minRepaintCount > repaintCount) ? repaintCount : minRepaintCount;
			}// 최소 페인팅횟수보다 새로운시작점에서 한 페인팅횟수가 작으면 최소값 교체
		}
		return minRepaintCount;
	}
	
	// 8 by 8을 받았을때 단순 반복을 통해서 최소값을 받아옴
	public static int eightByEight(char[][] chessBoard, int startColumn, int startRow) {
		int countFirstBlack = 0; // 첫칸에 블랙을 넣을경우 바꿔야 되는 칸 카운트용
		int countFirstWhite = 0; // 첫칸에 화이트를 넣을경우 바꿔야 되는 칸 카운트용
		for (int i = startColumn; i < startColumn + 8; i++) { // 시작점부터 8줄까지 반복
			for (int j = startRow; j < startRow + 8; j++) { // 시작점부터 8칸까지 반복
				if ((i % 2 == 0 && j % 2 == 0) || (i % 2 == 1 && j % 2 == 1)) {
					if (chessBoard[i][j] == 'B') // 대각선으로 내려가기때문에 조건을 짝,짝 / 홀,홀 로 함
						countFirstWhite++; // 해당칸이 블랙이면 화이트를 칠해야하기때문에 ++
					else
						countFirstBlack++; // 해당칸이 화이트면 블랙을 칠해야하기때문에 ++
				}
				else{ // 칸의 조건자체가 true of false 2가지라서 조건없이 else로 지정
					if (chessBoard[i][j] == 'W')
						countFirstWhite++; // 칸안에서 위의 조건과 반대가 되야되기때문에 조건이 바뀜
					else
						countFirstBlack++;
				}
			}
		} // 첫칸을 블랙으로 한 경우와 화이트로 한 경우중 더 작은 카운트를 리턴함
		return (countFirstBlack > countFirstWhite) ? countFirstWhite : countFirstBlack;
	}
}
