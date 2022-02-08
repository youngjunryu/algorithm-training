import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SWEA2948 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            HashSet<String> set = new HashSet<>();
            int result = 0;

            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < first; i++)
                set.add(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < second; i++) {
                if (set.contains(st.nextToken()))
                    result++;
            }

            System.out.println("#" + tc + " " + result);
        }
    }
}

/*

2
2 3
ab a
a ac ba
3 3
aa bb cc
dd cc aa

 */