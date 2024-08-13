package Baekjoon._2108;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    int[] arr = new int[N];
    int[] count = new int[8001];
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(br.readLine());
      count[arr[i] + 4000]++;
    }

    int one = Arrays.stream(arr).sum();
    System.out.println(Math.round((float) one / N));

    Arrays.sort(arr);

    int two = N % 2 == 0 ? arr[N / 2 - 1] : arr[N / 2];
    System.out.println(two);

    // 빈도 계산
    Map<Integer, Integer> frequencyMap = new HashMap<>();
    for (int num : arr) {
      frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
    }

    // 최빈값의 최대 빈도 찾기
    int maxFrequency = Collections.max(frequencyMap.values());

    // 최빈값 리스트 생성
    List<Integer> modeList = new ArrayList<>();
    for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
      if (entry.getValue() == maxFrequency) {
        modeList.add(entry.getKey());
      }
    }

    // 최빈값이 여러 개 있을 때 정렬 후 두 번째로 작은 값 선택
    Collections.sort(modeList);
    int result = (modeList.size() > 1) ? modeList.get(1) : modeList.get(0);

    // 결과 출력
    System.out.println(result);

    int four = arr[N - 1] - arr[0];
    System.out.println(four);
  }
}
