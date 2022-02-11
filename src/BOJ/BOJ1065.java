package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1065 {

    private static boolean isHansu(int value) {
        if(1 <= value && value <= 99)
            return true;

        int gap = (value / 10 % 10) - (value % 10);

        if(gap == value / 100 - value / 10 % 10)
            return true;
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        br.close();

        int count = 0;

        for(int i = 1; i <= n; i++) {
            if(isHansu(i))
                count++;
        }

        System.out.print(count);
    }
}
