package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ6443 {
	static int[] wordArr;
	static char[] save;
	static int len;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		for (int t = 0; t < N; t++) {
			wordArr = new int[26];
			String word = br.readLine();
			len = word.length();
			save = new char[len];

			for (int i = 0; i < word.length(); i++) {
				wordArr[word.charAt(i) - 'a']++;
			}

			dfs(0);
		}

		System.out.println(sb);
	}

	private static void dfs(int cnt) {
		if (cnt == len) {
			sb.append(save).append("\n");
			return;
		}

		for (int i = 0; i < 26; i++) {
			if (wordArr[i] > 0) {
				save[cnt] = (char) (i + 'a');
				wordArr[i]--;
				dfs(cnt + 1);
				wordArr[i]++;
			}
		}
	}
}
