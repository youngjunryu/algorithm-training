package Archiving.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ16472 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		String humanStr = br.readLine();
		int[] check = new int[26];
		int left = 0;
		int right = -1;
		int cnt = 0;
		int max = 0;

		while (right < humanStr.length() - 1) {
			right++;
			int num = humanStr.charAt(right) - 'a';
			check[num]++;

			if (check[num] == 1) {
				cnt++;
			}

			while (cnt > N) {
				int num2 = humanStr.charAt(left) - 'a';
				check[num2]--;

				if (check[num2] == 0) {
					cnt--;
				}

				left++;
			}

			max = Math.max(max, right - left + 1);
		}

		System.out.println(max);
	}
}

/*

abbcaccba

 */