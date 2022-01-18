import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SWEA1228 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = 10;

        for(int tc = 1; tc <= T; tc++) {
            LinkedList<Integer> list = new LinkedList<>();

            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            while(N-- > 0)
                list.add(Integer.parseInt(st.nextToken()));

            int k = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            while(k-- > 0) {
                if (st.nextToken().charAt(0) == 'I') {
                    int index = Integer.parseInt(st.nextToken());
                    int cnt =  Integer.parseInt(st.nextToken());
                    while(cnt-- > 0) {
                        list.add(index, Integer.parseInt(st.nextToken()));
                        index++;
                    }
                }
            }

            System.out.printf("#%d ", tc);
            for(int i = 0; i < 10; i++)
                System.out.print(list.get(i) + " ");
            System.out.println();
        }
    }
}

/*
11
449047 855428 425117 532416 358612 929816 313459 311433 472478 589139 568205
7
I 1 5 400905 139831 966064 336948 119288 I 8 6 436704 702451 762737 557561 810021 771706 I 3 8 389953 706628 552108 238749 661021 498160 493414 377808 I 13 4 237017 301569 243869 252994 I 3 4 408347 618608 822798 370982 I 8 2 424216 356268 I 4 10 512816 992679 693002 835918 768525 949227 628969 521945 839380 479976
 */