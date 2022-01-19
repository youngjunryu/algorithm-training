import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SWEA4408 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
            int[] way = new int[201];


            for(int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int x = (Integer.parseInt(st.nextToken()) + 1) / 2;
                int y = (Integer.parseInt(st.nextToken()) + 1) / 2;

                if(x >= y) {
                    for(int j = y; j <= x; j++)
                        way[j]++;
                } else {
                    for(int j = x; j <= y; j++)
                        way[j]++;
                }

            }

            int cnt = 0;
            for(int i = 0; i < 201; i++) {
                cnt = Math.max(cnt, way[i]);
            }

            System.out.printf("#%d %d\n", tc, cnt);

        }
    }
}
