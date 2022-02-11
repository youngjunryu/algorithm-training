package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA1970 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());

            int a, b, c, d, e, f, g, h;

            a = N / 50000;
            N -= 50000 * a;
            b = N / 10000;
            N -= 10000 * b;
            c = N / 5000;
            N -= 5000 * c;
            d = N / 1000;
            N -= 1000 * d;
            e = N / 500;
            N -= 500 * e;
            f = N / 100;
            N -= 100 * f;
            g = N / 50;
            N -= 50 * g;
            h = N / 10;
            N -= 10 * h;

            System.out.printf("#%d\n", tc);
            System.out.printf("%d %d %d %d %d %d %d %d\n", a, b, c, d, e, f, g, h);

        }
    }
}
