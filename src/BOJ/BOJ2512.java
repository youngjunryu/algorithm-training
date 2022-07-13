package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2512 {
	static int N;
	static int[] arr;
	static int budget;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int sum = 0;
		int max = 0;

		N = Integer.parseInt(br.readLine());
		arr = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			arr[i] = num;
			sum += num;
		}

		budget = Integer.parseInt(br.readLine());

		Arrays.sort(arr);

		if (sum <= budget) {
			max = arr[arr.length - 1];
		} else {
			max = calculateLimit(0, arr[arr.length - 1]);
		}

		System.out.println(max);
	}

	private static int calculateLimit(int low, int high) {
		int mid = 0;
		int sum = 0;
		int result = 0;

		while (low <= high) {
			sum = 0;
			mid = (low + high) / 2;
			for (int i = 0; i < N; i++) {
				if (arr[i] > mid) {
					sum += mid;
				} else {
					sum += arr[i];
				}
			}

			if (sum == budget) {
				return mid;
			} else if (sum > budget){
				high = mid - 1;
			} else {
				result = mid;
				low = mid + 1;
			}
		}

		return result;
	}
}

/*

4
120 110 140 150
485

 */