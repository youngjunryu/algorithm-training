package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SWEA7701 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
            Set<String> set = new HashSet<>();
            List<String> list = new LinkedList<>();

            for(int i = 0; i < N; i++)
                set.add(br.readLine());

            Iterator<String> it = set.iterator();
            while(it.hasNext())
                list.add(it.next());

            Collections.sort(list, new Comparator<String>() {
                @Override
                public int compare(String s1, String s2) {
                    if(s1.length() == s2.length()) {
                        return s1.compareTo(s2);
                    }
                    else {
                        if(s1.length() < s2.length())
                            return -1;
                        else
                            return 1;
                    }
                }
            });

            it = list.iterator();

            System.out.printf("#%d\n", tc);
            while(it.hasNext())
                System.out.printf("%s\n", it.next());

        }
    }
}
