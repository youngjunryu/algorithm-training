package Archiving.BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.io.IOException;

public class BOJ10951 {
    public static void main(String[] args)  throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str;
        StringTokenizer st;

        while((str = br.readLine()) != null) {
            st = new StringTokenizer(str, " ");
            bw.write( (Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken())) + "\n");
            bw.flush();
        }

        br.close();
        bw.close();
    }
}
