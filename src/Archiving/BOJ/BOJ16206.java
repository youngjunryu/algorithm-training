package Archiving.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ16206 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        List<Integer> cakeInput = new LinkedList<>();
        List<Integer> cake = new LinkedList<>();
        int sum = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cakeInput.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(cakeInput);

        for (int i = 0; i < cakeInput.size(); i++) {
            if (cakeInput.get(i) % 10 == 0) {
                cake.add(cakeInput.get(i));
                cakeInput.remove(i);
                i--;
            }
        }

        cake.addAll(cakeInput);

        for (int i = 0; i < N; i++) {
            int len = cake.get(i);
            while (M > 0 && len > 10) {
                len -= 10;
                M--;
                sum++;
            }
            cake.set(i, len);
        }

        for (int i = 0; i < N; i++) {
            if (cake.get(i) == 10) {
                sum++;
            }
        }

        System.out.println(sum);
    }
}