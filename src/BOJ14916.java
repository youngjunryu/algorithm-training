import java.util.*;
import java.io.*;

public class BOJ14916 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int cnt = 0;

        while(true) {
            if(n == 1) {
                cnt = -1;
                break;
            }

            if(n <= 0) {
                break;
            }

            if(n % 5 == 0) {
                cnt++;
                n -= 5;
            } else {
                cnt++;
                n -= 2;
            }
        }
        System.out.println(cnt);
    }
}