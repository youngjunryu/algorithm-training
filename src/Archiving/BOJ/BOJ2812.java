package Archiving.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ2812 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int idx = 0;
		boolean flag = false;
		String numStr = br.readLine();
		Stack<Integer> s = new Stack<>();

		s.add(numStr.charAt(idx) - '0');

		for (idx = 1; idx < N; idx++) {
			if (flag) {
				break;
			}

			int num = numStr.charAt(idx) - '0';
			while (s.size() > 0 && s.peek() < num) {
				if (K <= 0) {
					flag = true;
					break;
				}
				s.pop();
				K--;
			}

			s.push(num);
		}

		while (s.size() > 0) {
			sb.append(s.pop());
		}
		sb.reverse();
		while (idx < N) {
			sb.append(numStr.charAt(idx) - '0');
			idx++;
		}
		while (K > 0) {
			sb.deleteCharAt(sb.length() - 1);
			K--;
		}

		System.out.println(sb);
	}
}
