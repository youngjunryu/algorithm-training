package Archiving.BOJ;

import java.util.*;
import java.io.*;

public class BOJ20207 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[] arr = new int[366];
        boolean check = false;
        int max = 0;
        int start = 0;
        int sum = 0;
        int s, e;

        int n = Integer.parseInt(br.readLine());

        while(n-- > 0) {
            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            for(int i = s; i <= e; i++)
                arr[i]++;
        }

        for(int i = 1; i <= 365; i++) {
            if(!check && arr[i] > 0) {
                check = true;
                max = arr[i];
                start = i;
            }

            if(check) {
                if(arr[i] == 0) {
                    sum += (max * (i - start));
                    check = false;
                } else if(i == 365) {
                    sum += (max * (366 - start));
                }

                if(arr[i] > max)
                    max = arr[i];
            }
        }
        System.out.println(sum);
    }
}
