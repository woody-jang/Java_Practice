import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Goldbach {	// 백준 9020 문제
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int[] prime = new int[10000 * 2 + 1];
		prime[0] = prime[1] = 1;
		for (int i = 2; i * i <= 10000 * 2; i++) {
			if (prime[i] == 0) {
				for (int j = i * i; j <= 10000 * 2; j += i) {
					prime[j]++;
				}
			}
		}

		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			int n = Integer.parseInt(br.readLine());

			for (int j = n / 2, k = n / 2; j < n || k > 1; j++, k--) {
				if (prime[j] != 0) {
					if (prime[k] == 0)
						k++;
					continue;
				}
				if (prime[k] != 0) {
					if (prime[j] == 0)
						j--;
					continue;
				}
				if (j + k == n) {
					bw.write(k + " " + j + "\n");
					break;
				} else if (j + k > n)
					j--;
				else
					k++;
			}
		}
		bw.flush();
		bw.close();
	}
}