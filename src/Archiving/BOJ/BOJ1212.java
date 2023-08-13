package Archiving.BOJ;

import java.io.*;

public class BOJ1212 {
    public static void main(String[] args) throws  IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String eight = br.readLine();

        String[] arr = {"000", "001", "010", "011", "100", "101", "110", "111"};
        String[] arrFirst = {"0", "1", "10", "11", "100", "101", "110", "111"};

        sb.append(arrFirst[eight.charAt(0) - '0']);
        for(int i = 1; i < eight.length(); i++) {
            sb.append(arr[eight.charAt(i) - '0']);
        }

        System.out.print(sb);

    }
}
