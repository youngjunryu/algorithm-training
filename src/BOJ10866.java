import java.io.*;
import java.util.*;

public class BOJ10866 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        Deque<Integer> deque = new LinkedList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        while(n > 0) {
            String s = br.readLine();
            String[] array = s.split(" ");
            switch(array[0]) {
                case "push_front":
                    deque.offerFirst(Integer.parseInt(array[1]));
                    break;
                case "push_back":
                    deque.offerLast(Integer.parseInt(array[1]));
                    break;
                case "pop_front":
                    if(!deque.isEmpty()) {
                        System.out.println(deque.pollFirst());
                    }else {
                        System.out.println(-1);
                    }
                    break;
                case "pop_back":
                    if(!deque.isEmpty()) {
                        System.out.println(deque.pollLast());
                    }else {
                        System.out.println(-1);
                    }
                    break;
                case "size":
                    System.out.println(deque.size());
                    break;
                case "empty":
                    if(!deque.isEmpty()) {
                        System.out.println(0);
                    }else {
                        System.out.println(1);
                    }
                    break;
                case "front":
                    if(!deque.isEmpty()) {
                        System.out.println(deque.peekFirst());
                    }else {
                        System.out.println(-1);
                    }
                    break;
                case "back":
                    if(!deque.isEmpty()) {
                        System.out.println(deque.peekLast());
                    }else {
                        System.out.println(-1);
                    }
                    break;
            }
            n--;
        }
    }
}