package Archiving.BOJ;

import java.util.*;
import java.io.*;

public class BOJ17298 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        String[] num = br.readLine().split(" ");
        int[] result = new int[n];

        for(int i = n - 1; i >= 0; i--) {
            while(!stack.isEmpty() && Integer.parseInt(num[i]) >= stack.peek()) {
                stack.pop();
            }

            if(stack.isEmpty())
                result[i] = -1;
            else
                result[i] = stack.peek();

            stack.push(Integer.parseInt(num[i]));
        }

        for(int i = 0; i < n; i++)
            sb.append(result[i]).append(' ');
        System.out.println(sb);
    }
}