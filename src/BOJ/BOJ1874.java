package BOJ;

import java.io.*;
import java.util.Stack;

public class BOJ1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<Integer>();
        boolean flag = true;

        int n = Integer.parseInt(br.readLine());
        int number = 0;
        for(int i = 0; i < n; i++) {
            int value = Integer.parseInt(br.readLine());

            if(!stack.empty() && (stack.peek() > value)) {
                flag = false;
            }

            if(stack.empty() || (stack.peek() < value)) {
                int diff = value - number;
                for(int j = 0; j < diff; j++) {
                    stack.push(++number);
                    sb.append("+").append('\n');
                }
            }
            stack.pop();
            sb.append("-").append('\n');
        }

        if(flag)
            System.out.print(sb);
        else
            System.out.print("NO");

    }
}