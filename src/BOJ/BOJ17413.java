package BOJ;

import java.util.*;
import java.io.*;

public class BOJ17413 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        String str = br.readLine();
        for(int i = str.length() - 1; i >= 0; i--) {
            stack.push(str.charAt(i));
        }

        while(stack.size() != 0) {
            if(stack.peek() == '<') {
                result.append(sb.reverse().toString());
                sb.setLength(0);
                while(stack.peek() != '>')
                    result.append(stack.pop());
                result.append(stack.pop());
            } else if(stack.peek() == ' '){
                result.append(sb.reverse().toString());
                sb.setLength(0);
                result.append(stack.pop());
            } else {
                sb.append(stack.pop());
            }
        }

        result.append(sb.reverse().toString());

        System.out.println(result);

    }
}
