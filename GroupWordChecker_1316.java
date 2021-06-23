import java.util.HashMap;
import java.util.Scanner;

public class GroupWordChecker_1316 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			String str = sc.nextLine();
			HashMap<Character, Integer> a = new HashMap<Character, Integer>();
			for (int j = 0; j < str.length(); j++) {
				char tmp = str.charAt(j);
				if (a.containsKey(tmp)) {
					if (a.get(tmp) == j - 1)
						a.replace(tmp, j);
					else {
						cnt++;
						break;
					}
				} else
					a.put(tmp, j);
			}
		}
		System.out.println(n - cnt);
		sc.close();
	}
}
