package BOJ;

import java.util.*;
import java.io.*;

public class BOJ1343 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();
        st = new StringTokenizer(str, ".");
        String[] arr = new String[50];
        int now = 0;

        while(st.hasMoreTokens()) {
            int length = st.nextToken().length();
            int fourCnt = 0;
            int twoCnt = 0;

            while(true) {
                if (length == 1) {
                    System.out.print(-1);
                    return;
                }

                if(length <= 0) {
                    break;
                }

                if(length % 4 == 0 ) {
                    fourCnt++;
                    length -= 4;
                }
                else {
                    twoCnt++;
                    length -= 2;
                }
            }

            while(fourCnt-- > 0)
                sb.append("AAAA");
            while(twoCnt-- > 0)
                sb.append("BB");

            arr[now++] = sb.toString();
            sb.setLength(0);

        }

        sb.setLength(0);
        now = 0;

        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i)  == 'X') {
                sb.append(arr[now]);
                i += arr[now].length() - 1;
                now++;
            }
            else {
                sb.append('.');
            }
        }

        System.out.println(sb);

    }
}