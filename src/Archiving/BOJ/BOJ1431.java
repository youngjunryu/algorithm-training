package Archiving.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ1431 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		String[] arr = new String[N];
		for (int i = 0; i < N; i++) {
			arr[i] = br.readLine();
		}

		Arrays.sort(arr, (o1, o2) -> {
			if (o1.length() < o2.length()) {
				return -1;
			} else if(o1.length() == o2.length()) {
				if (add(o1) == add(o2)) {
					return o1.compareTo(o2);
				} else {
					return Integer.compare(add(o1), add(o2));
				}
			} else {
				return 1;
			}
		});

		for (String s : arr) {
			System.out.println(s);
		}
	}

	private static int add(String num) {
		int sum = 0;
		for (int i = 0; i < num.length(); i++) {
			if (num.charAt(i) >= '0' && num.charAt(i) <= '9') {
				sum += num.charAt(i) - '0';
			}
		}
		return sum;
	}
}