package Archiving.BOJ;

import java.util.*;

public class BOJ5883 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> line = new LinkedList<>();
        HashSet<Integer> set = new HashSet<>();
        int answer = 0;

        int N = sc.nextInt();
        while (N-- > 0) {
            int num = sc.nextInt();
            line.add(num);
            set.add(num);
        }

        for (int num : set) {
            int cur = line.get(0);
            int cnt = 0;
            for (int i = 0; i < line.size(); i++) {
                if (line.get(i) == num) {
                    continue;
                }

                if (line.get(i) == cur) {
                    cnt++;
                } else {
                    cur = line.get(i);
                    cnt = 1;
                }

                answer = Math.max(answer, cnt);
            }
        }

        System.out.println(answer);
    }
}
