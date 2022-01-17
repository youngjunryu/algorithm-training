import java.io.*;
import java.util.*;

public class SWEA10726 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int k = (1 << N) - 1;

            if((M & k) != k) System.out.printf("#%d OFF\n", tc);
            else System.out.printf("#%d ON\n", tc);

        }
    }
}
