import java.util.*;
import java.io.*;

public class BOJ2217 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] list;

        int n = Integer.parseInt(br.readLine());
        list = new int[n];
        for(int i = 0; i < n; i++){
            list[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(list);

        int pos = 2;
        int result = list[list.length-1];
        for(int i = list.length - 2; i >= 0; i--) {
            if(result < list[i] * pos) {
                result = list[i] * pos;
            }
            pos++;
        }

        System.out.println(result);

    }
}
