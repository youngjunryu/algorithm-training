package Archiving.BOJ;

import java.util.*;
import java.io.*;

public class BOJ2164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> queue = new LinkedList<>();

        int n = Integer.parseInt(br.readLine());

        for(int i = 1; i <= n; i++)
            queue.add(i);

        while(queue.size() != 1) {
            queue.remove();
            queue.add(queue.peek());
            queue.remove();
        }

        System.out.print(queue.peek());

    }
}
