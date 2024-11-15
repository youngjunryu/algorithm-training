package Baekjoon._4195;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

  static HashMap<String, Integer> nameMap;
  static HashMap<String, String> parentMap;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int T = Integer.parseInt(br.readLine());
    for (int t = 0; t < T; t++) {
      nameMap = new HashMap<>();
      parentMap = new HashMap<>();

      int F = Integer.parseInt(br.readLine());

      for (int f = 0; f < F; f++) {
        StringTokenizer st = new StringTokenizer(br.readLine());
        String a = st.nextToken();
        String b = st.nextToken();

        if (!nameMap.containsKey(a)) {
          nameMap.put(a, 1);
          parentMap.put(a, a);
        }

        if (!nameMap.containsKey(b)) {
          nameMap.put(b, 1);
          parentMap.put(b, b);
        }

        System.out.println(union(a, b));
      }
    }
  }

  public static String find(String a) {
    if (!a.equals(parentMap.get(a))) {
      parentMap.put(a, find(parentMap.get(a)));
    }
    return parentMap.get(a);
  }

  public static int union(String a, String b) {
    String parentA = find(a);
    String parentB = find(b);

    if (!parentA.equals(parentB)) {
      int sizeA = nameMap.get(parentA);
      int sizeB = nameMap.get(parentB);

      if (sizeA < sizeB) {
        parentMap.put(parentA, parentB);
        nameMap.put(parentB, sizeA + sizeB); // 새로운 루트의 크기를 갱신
      } else {
        parentMap.put(parentB, parentA);
        nameMap.put(parentA, sizeA + sizeB); // 새로운 루트의 크기를 갱신
      }
    }

    return nameMap.get(find(a));
  }
}
