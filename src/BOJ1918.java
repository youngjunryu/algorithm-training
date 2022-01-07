import java.io.*;
import java.util.*;

public class BOJ1918 {
    private static int getPriority(char ch) {
        switch(ch) {
            case '*' :
            case '/' :
                return 2;
            case '+' :
            case '-' :
                return 1;
            default :
                return 0;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str = br.readLine();
        Stack<Character> stack = new Stack<>();

        int len = str.length();
        for(int i = 0; i < len; i++) {
            char ch = str.charAt(i);
            int priority = getPriority(ch);

            switch(ch) {
                case '+' :
                case '-' :
                case '*' :
                case '/' :
                    while(!stack.isEmpty() && getPriority(stack.peek()) >= priority) {
                        sb.append(stack.pop());
                    }
                    stack.push(ch);
                    break;
                case '(' :
                    stack.push(ch);
                    break;
                case ')' :
                    while(!stack.isEmpty() && stack.peek() != '(') {
                        sb.append(stack.pop());
                    }
                    stack.pop();
                    break;
                default :
                    sb.append(ch);
            }
        }

        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        System.out.println(sb.toString());
    }
}