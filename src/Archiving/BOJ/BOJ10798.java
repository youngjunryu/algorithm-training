package Archiving.BOJ;

import java.io.*;

public class BOJ10798 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] reader =  new String[5];

        for(int i = 0; i < 5; i++)
            reader[i] = br.readLine();

        for(int i = 0; i < 15; i++) {
            for(int j = 0; j < 5; j++) {
                if(i < reader[j].length())
                    System.out.print(reader[j].charAt(i));
            }
        }
    }
}
