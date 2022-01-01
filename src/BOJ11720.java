import java.io.*;

public class BOJ11720 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] value = new String[n];
        int sum = 0;
        value = br.readLine().split("");
        for(int i = 0; i < n; i++) {
            sum += Integer.parseInt(value[i]);
        }

        System.out.println(sum);
    }
}
