package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SWEA1230 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = 10;

        for(int tc = 1; tc <= T; tc++) {
            LinkedList<Integer> list = new LinkedList<>();

            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            while(N-- > 0)
                list.add(Integer.parseInt(st.nextToken()));

            int k = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            while(k-- > 0) {
                char ch = st.nextToken().charAt(0);
                if (ch == 'I') {
                    int x = Integer.parseInt(st.nextToken());
                    int y =  Integer.parseInt(st.nextToken());
                    while(y-- > 0) {
                        list.add(x, Integer.parseInt(st.nextToken()));
                        x++;
                    }
                }
                else if(ch == 'A') {
                    int y =  Integer.parseInt(st.nextToken());
                    while(y-- > 0) {
                        list.add(Integer.parseInt(st.nextToken()));
                    }
                }
                else if(ch == 'D'){
                    int x = Integer.parseInt(st.nextToken());
                    int y =  Integer.parseInt(st.nextToken());
                    while(y-- > 0) {
                        list.remove(x);
                    }
                }
            }

            System.out.printf("#%d ", tc);
            for(int i = 0; i < 10; i++)
                System.out.print(list.get(i) + " ");
            System.out.println();
        }
    }
}