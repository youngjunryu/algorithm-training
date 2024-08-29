package Baekjoon._11723;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int M = Integer.parseInt(br.readLine());

    HashSet<Integer> set = new HashSet<>();

    for (int i = 0; i < M; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      String command = st.nextToken();
      int num = -1;
      if (!(command.equals("all") || command.equals("empty"))) {
        num = Integer.parseInt(st.nextToken());
      }

      if (command.equals("add")) {
        set.add(num);
      } else if (command.equals("check")) {
        if (set.contains(num)) {
          bw.write("1\n");
        } else {
          bw.write("0\n");
        }
      } else if (command.equals("remove")) {
        set.remove(num);
      } else if (command.equals("toggle")) {
        if (set.contains(num)) {
          set.remove(num);
        } else {
          set.add(num);
        }
      } else if (command.equals("all")) {
        set.clear();
        for (int j = 1; j <= 20; j++) {
          set.add(j);
        }
      } else if (command.equals("empty")) {
        set.clear();
      }
    }

    bw.flush();
    bw.close();
  }
}
