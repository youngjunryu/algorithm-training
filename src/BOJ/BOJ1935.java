package BOJ;

import java.util.*;
import java.io.*;

public class BOJ1935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<Character, Double> map = new HashMap<>();
        Stack<Double> stack = new Stack<>();

        char c = 'A';

        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();
        for(int i = 0; i < n; i++) {
            map.put(c, Double.parseDouble(br.readLine()));
            c = (char)(c + 1);
        }

        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) >= 65 && str.charAt(i) <= 90) {
                stack.push(map.get(str.charAt(i)));
            }
            else {
                double a = stack.pop();
                double b = stack.pop();
                double result = 0.0;
                if(str.charAt(i) == '*')
                    result = b*a;
                else if(str.charAt(i) == '/')
                    result = b/a;
                else if(str.charAt(i) == '+')
                    result = b+a;
                else if(str.charAt(i) == '-')
                    result = b-a;
                stack.push(result);
            }
        }

        System.out.printf("%.2f", stack.peek());

    }
}
