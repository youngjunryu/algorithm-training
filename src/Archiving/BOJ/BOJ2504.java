package Archiving.BOJ;

import java.io.*;
import java.util.*;

public class BOJ2504 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack = new Stack<>();
        String str = br.readLine();
        Character bracket;
        boolean flag = true;
        int result = 0;
        int cnt = 1;

        for(int i = 0; i < str.length(); i++) {
            bracket = str.charAt(i);
            if(bracket == '(') {
                stack.push(bracket);
                cnt *= 2;
            }
            else if(bracket == '[') {
                stack.push(bracket);
                cnt *= 3;
            }
            else {
                if(bracket == ')') {
                    if(stack.empty() || stack.peek() != '(') {
                        flag = false;
                        break;
                    }
                    if(str.charAt(i-1) == '(')
                        result += cnt;
                    stack.pop();
                    cnt /= 2;
                }
                else if(bracket == ']'){
                    if(stack.empty() || stack.peek() != '[') {
                        flag = false;
                        break;
                    }
                    if(str.charAt(i-1) == '[')
                        result += cnt;
                    stack.pop();
                    cnt /= 3;
                }
                else {
                    flag = false;
                    break;
                }
            }
        }
        if(!flag || !stack.isEmpty()) {
            System.out.print(0);
        }else {
            System.out.print(result);
        }
    }
}
