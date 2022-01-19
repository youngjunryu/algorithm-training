import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SWEA1244 {
    static int[] num;
    static int s;
    static int result;
    static String str;

    private static void dfs(int index, int cnt) {
        if(cnt == s) {
            StringBuilder sb = new StringBuilder();
            for(int i : num)
                sb.append(i);
            result = Math.max(result, Integer.parseInt(sb.toString()));
            return;
        }

        for(int i = index; i < num.length; i++) {
            for(int j = i + 1; j < num.length; j++) {
                if(num[i] <= num[j]) {
                    int temp = num[i];
                    num[i] = num[j];
                    num[j] = temp;
                    dfs(i, cnt + 1);
                    temp = num[i];
                    num[i] = num[j];
                    num[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());

            str = st.nextToken();
            s = Integer.parseInt(st.nextToken());

            num = new int[str.length()];
            Arrays.fill(num, 0);
            result = 0;

            for(int i = 0; i < str.length(); i++)
                num[i] = Character.getNumericValue(str.charAt(i));

            dfs(0, 0);

            System.out.printf("#%d %d\n", tc, result);
        }
    }
}