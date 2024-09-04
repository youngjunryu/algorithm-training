package Baekjoon._17219;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    HashMap<String, String> map = new HashMap<>();

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      map.put(st.nextToken(), st.nextToken());
    }

    for (int j = 0; j < m; j++) {
      bw.write(map.get(br.readLine()) + "\n");
    }

    bw.flush();
    bw.close();
  }
}
