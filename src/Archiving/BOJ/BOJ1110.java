package Archiving.BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class BOJ1110 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        br.close();

        int newNumber = n;
        int count = 0;

        while(true) {
            count++;
            newNumber = (newNumber % 10 * 10) + ((newNumber / 10 + newNumber % 10) % 10);
            if(newNumber == n) {
                System.out.print(count);
                break;
            }
        }
    }
}
