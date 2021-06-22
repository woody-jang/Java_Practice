import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class GetPrimeNumber {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int min = Integer.parseInt(st.nextToken());
		int max = Integer.parseInt(st.nextToken());
		int[] prime = new int[max + 1];
		prime[0] = prime[1] = 1;

		for (int i = 2; i * i <= max; i++) {
			if (prime[i] == 0) {
				for (int j = i * i; j <= max; j += i) {
					prime[j]++;
				}
			}
		}

		for (int i = min; i <= max; i++) {
			if (prime[i] == 0)
				bw.write(i + "\n");
		}

		bw.flush();
		bw.close();
	}
}