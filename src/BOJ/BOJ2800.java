package BOJ;

import java.util.*;
import java.io.*;

public class BOJ2800 {
    static BufferedReader br;
    static StringBuilder sb;
    static Stack<Integer> stack;
    static Set<String> set;

    static String str = null;
    static int[] pair = null;
    static boolean[] check = null;

    private static void dfs(int deptNow, int dept) {
        if(deptNow == dept) {
            set.add(sb.toString());
            return;
        }

        char ch = str.charAt(deptNow);
        if(ch == '(') {
            check[deptNow] = true;
            dfs(deptNow + 1, dept);
            check[deptNow] = false;
        }

        if(ch == ')' && check[pair[deptNow]]) {
            check[deptNow] = true;
            dfs(deptNow + 1, dept);
            check[deptNow] = false;
        }
        else {
            sb.append(ch);
            dfs(deptNow + 1, dept);
            sb.deleteCharAt(sb.length()-1);
        }
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        stack = new Stack<>();
        set = new HashSet<>();

        str = br.readLine();
        pair = new int[str.length()];
        check = new boolean[str.length()];

        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '(')
                stack.push(i);
            else if(str.charAt(i) == ')'){
                pair[i] = stack.peek();
                pair[stack.peek()] = i;
                stack.pop();
            }
        }

        dfs(0, str.length());
        set.remove(str);
        ArrayList<String> list = new ArrayList<>(set);
        Collections.sort(list);
        for(String a : list) {
            sb.append(a).append('\n');
        }
        System.out.print(sb);
    }
}

/*
(0/(0))
 */