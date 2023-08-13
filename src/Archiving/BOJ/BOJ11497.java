package Archiving.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ11497 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			ArrayList<Integer> oddList = new ArrayList<>();
			ArrayList<Integer> evenList = new ArrayList<>();
			ArrayList<Integer> resultList = new ArrayList<>();

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			Arrays.sort(arr);

			for (int i = 0; i < N; i++) {
				if (i % 2 == 0) {
					oddList.add(arr[i]);
				} else {
					evenList.add(arr[i]);
				}
			}

			Collections.sort(evenList, Collections.reverseOrder());

			resultList.addAll(oddList);
			resultList.addAll(evenList);
			resultList.add(oddList.get(0));

			int diff = 0;
			for (int i = 0; i < resultList.size() - 1; i++) {
				diff = Math.max(Math.abs(resultList.get(i) - resultList.get(i + 1)), diff);
			}

			System.out.println(diff);
		}
	}
}
