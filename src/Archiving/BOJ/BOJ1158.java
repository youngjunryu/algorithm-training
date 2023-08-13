package Archiving.BOJ;

import java.io.*;
import java.util.*;

public class BOJ1158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        Queue<Integer> queue = new LinkedList<Integer>();

        st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int cur = 1;

        for(int i = 1; i <= n; i++)
            queue.add(i);

        sb.append("<");

        while(!queue.isEmpty()) {
            if(cur == k) {
                sb.append(queue.peek()).append(", ");
                queue.remove();
                cur = 1;
                continue;
            }

            queue.add(queue.peek());
            queue.remove();
            cur++;
        }

        sb.deleteCharAt(sb.length()-1);
        sb.deleteCharAt(sb.length()-1);
        sb.append(">");

        System.out.println(sb);
    }
}
