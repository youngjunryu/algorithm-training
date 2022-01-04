import java.io.*;
import java.util.*;

public class BOJ10799 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack = new Stack<>();
        int count = 0;

        String str = br.readLine();
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '(')
                stack.push(str.charAt(i));
            else {
                stack.pop();
                if(str.charAt(i-1) == '(')
                    count += stack.size();
                else
                    count++;
            }
        }
        System.out.print(count);
    }
}
