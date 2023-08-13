package Archiving.BOJ;

import java.util.*;
import java.io.*;

public class BOJ14667 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        boolean[] cow = new boolean[11];
        int[] position = new int[11];
        int result = 0;

        int n = Integer.parseInt(br.readLine());
        while(n-- > 0) {
            st = new StringTokenizer(br.readLine());
            int cowNumber = Integer.parseInt(st.nextToken());
            int cowPosition = Integer.parseInt(st.nextToken());

            if(cow[cowNumber]) {
                if (position[cowNumber] != cowPosition) {
                    result++;
                }
            }
            else {
                cow[cowNumber] = true;
            }
            position[cowNumber] = cowPosition;
        }
        System.out.println(result);
    }
}
