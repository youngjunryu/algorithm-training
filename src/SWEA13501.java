import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SWEA13501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        LinkedList<Integer> list;

        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++) {
            list = new LinkedList<>();

            String[] arr = br.readLine().split(" ");
            int N = Integer.parseInt(arr[0]);
            int M = Integer.parseInt(arr[1]);
            int L = Integer.parseInt(arr[2]);

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++)
                list.add(Integer.parseInt(st.nextToken()));

            while(M-- > 0) {
                st = new StringTokenizer(br.readLine());
                char ch = st.nextToken().charAt(0);
                if(ch == 'I') {
                    list.add(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
                }
                else if(ch == 'D') {
                    list.remove(Integer.parseInt(st.nextToken()));
                }
                else if(ch == 'C') {
                    list.set(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
                }
            }

            try {
                int result = list.get(L);
                System.out.printf("#%d %d\n", tc, result);
            } catch (IndexOutOfBoundsException e){
                System.out.printf("#%d -1\n", tc);
            }

        }
    }
}
