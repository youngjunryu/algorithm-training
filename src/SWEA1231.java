import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SWEA1231 {
    static int N;
    static Data1231[] arr;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = 1;

        while(t <= 10) {
            N = Integer.parseInt(br.readLine());
            arr = new Data1231[N + 1];
            sb = new StringBuilder();

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int num = Integer.parseInt(st.nextToken());
                char ch = st.nextToken().charAt(0);
                int left = 0;
                int right = 0;
                if (num * 2 <= N) {
                    left = Integer.parseInt(st.nextToken());
                }
                if (num * 2 + 1 <= N) {
                    right = Integer.parseInt(st.nextToken());
                }

                arr[num] = new Data1231(ch, left, right);
            }

            inOrder(1);
            System.out.println("#" + t + " " + sb);
            t++;
        }
    }

    private static void inOrder(int n) {
        if(arr[n].left > 0)
            inOrder(arr[n].left);

        sb.append(arr[n].word);

        if(arr[n].right > 0)
            inOrder(arr[n].right);
    }
}

class Data1231 {
    char word;
    int left;
    int right;

    Data1231(char word, int left, int right) {
        this.word = word;
        this.left = left;
        this.right = right;
    }
}