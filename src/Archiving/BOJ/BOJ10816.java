package Archiving.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ10816 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        List<Integer> list = new ArrayList<>();

        int n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(list);

        int m = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int num = Integer.parseInt(st.nextToken());
            int high = upperBound(list, num);
            int low = lowerBound(list, num);
            if (high == -1) {
                sb.append("0 ");
                continue;
            }
            sb.append((high - low + 1) + " ");
        }

        System.out.println(sb);
    }

    private static int upperBound(List<Integer> list, int num) {
        int left = 0;
        int right = list.size() - 1;
        int answer = -1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (num < list.get(mid)) {
                right = mid - 1;
            } else if (num > list.get(mid)){
                left = mid + 1;
            } else {
                answer = mid;
                left = mid + 1;
            }
        }

        return answer;
    }

    private static int lowerBound(List<Integer> list, int num) {
        int left = 0;
        int right = list.size() - 1;
        int answer = -1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (num < list.get(mid)) {
                right = mid - 1;
            } else if (num > list.get(mid)) {
                left = mid + 1;
            } else {
                answer = mid;
                right = mid - 1;
            }
        }

        return answer;
    }
}
