import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.time.LocalDate;
import java.util.Scanner;

/*
 * 이번달 달력 출력.
 * 7   1   2   3   4   5   6
 * 일  월  화  수  목  금  토
 * ---------------------------
 *         01  02  03  04  05
 * 06  07  08  09  10  11  12
 */
public class PrintMonth {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("년도를 입력하세요 : ");
		int year = sc.nextInt();
		System.out.println("월을 입력하세요 : ");
		int month = sc.nextInt();
		makeCalendarSB(year, month);
		System.out.println("\n=============================\n");
		makeCalendarBW(year, month);
		sc.close();
	}

	private static void makeCalendarBW(int year, int month) {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		try {
			bw.write("\n        " + year + "년 " + month + "월      bw\n");
			bw.write("---------------------------\n");
			bw.write("일  월  화  수  목  금  토\n");
			for (int i = 1; i <= LocalDate.of(year, month, 1).lengthOfMonth(); i++) {
				int todayi = LocalDate.of(year, month, i).getDayOfWeek().getValue(); // i일의 요일을 숫자로 저장
				if (todayi != 7 && i == 1) { // i일이 일요일이 아니면서 1일이면 앞에 공백
					for (int j = 0; j < todayi; j++) {
						bw.write("    ");
					}
				}
				String fmt = "%02d  ";
				bw.write(String.format(fmt, i));
				if (todayi == 6) // i일이 토요일이라면 엔터
					bw.write("\n");
			}
		} catch (IOException e) {
		}
		try {
			bw.flush();
			bw.close();
		} catch (IOException e) {
		}
	}

	private static void makeCalendarSB(int year, int month) {
		StringBuffer sb = new StringBuffer();
		sb.append("\n        " + year + "년 " + month + "월      sb\n");
		sb.append("---------------------------\n");
		sb.append("일  월  화  수  목  금  토\n");
		for (int i = 1; i <= LocalDate.of(year, month, 1).lengthOfMonth(); i++) {
			int todayi = LocalDate.of(year, month, i).getDayOfWeek().getValue(); // i일의 요일을 숫자로 저장
			if (todayi != 7 && i == 1) { // i일이 일요일이 아니면서 1일이면 앞에 공백
				for (int j = 0; j < todayi; j++) {
					sb.append("    ");
				}
			}
			String fmt = "%02d  ";
			sb.append(String.format(fmt, i));
			if (todayi == 6) // i일이 토요일이라면 엔터
				sb.append("\n");
		}
		System.out.println(sb);
	}
}
