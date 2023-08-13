package Archiving.BOJ;

import java.util.*;
import java.io.*;

class Data2346 {
    int order;
    int number;

    Data2346(int order, int number) {
        this.order = order;
        this.number = number;
    }
}

public class BOJ2346 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        Deque<Data2346> deque = new ArrayDeque<>();

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for(int i = 1; i <= n; i++)
            deque.addLast(new Data2346(i, Integer.parseInt(st.nextToken())));

        while(true) {
            sb.append(deque.peekFirst().order).append(' ');
            int move = deque.peekFirst().number;
            deque.removeFirst();

            if(deque.isEmpty())
                break;

            if(move > 0) {
                while(move-- > 1)
                    deque.addLast(deque.removeFirst());
            }
            else {
                while (move++ < 0)
                    deque.addFirst(deque.removeLast());
            }
        }
        System.out.print(sb);
    }
}

/*

1  2  3  4  5
3  2  1 -3 -1

 4  5  2  3
-3 -1  2  1

 5  2  3
-1  2  1

3 2
1 2

1  4  5  3  2

 */

