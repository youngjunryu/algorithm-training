package Archiving.BOJ;

import java.util.*;
import java.io.*;

class Top {
    int order;
    int length;

    Top(int order, int length) {
        this.order = order;
        this.length = length;
    }
}

public class BOJ2493 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        Stack<Top> stack = new Stack<>();

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for(int i = 1; i <= n; i++) {
            Top cur = new Top(i, Integer.parseInt(st.nextToken()));
            while (true) {
                if (stack.isEmpty()) {
                    sb.append("0 ");
                    stack.push(cur);
                    break;
                } else if (stack.peek().length > cur.length) {
                    sb.append(stack.peek().order).append(' ');
                    stack.push(cur);
                    break;
                } else {
                    stack.pop();
                }
            }
        }
        System.out.println(sb);
    }
}
