package PROGRAMMERS;

public class 풍선_터트리기 {
  public static int solution(int[] a) {
    int answer = 0;
    int len = a.length;

    int[] minLefts = new int[len];
    int[] minRights = new int[len];

    int minLeft = 1_000_000_001;
    int minRight = 1_000_000_001;

    for (int i = 0; i < len; i++) {
      if (minLeft > a[i]) {
        minLeft = Math.min(minLeft, a[i]);
      }
      minLefts[i] = minLeft;
    }

    for (int i = len - 1; i >= 0; i--) {
      if (minRight > a[i]) {
        minRight = Math.min(minRight, a[i]);
      }
      minRights[i] = minRight;
    }

    for (int i = 0; i < len; i++) {
      if (minLefts[i] < a[i] && minRights[i] < a[i]) {
        continue;
      }

      answer++;
    }

    return answer;
  }

  public static void main(String[] args) {
    solution(new int[]{-16,27,65,-2,58,-92,-71,-68,-61,-33});
  }
}

/*

선택한 수의 왼쪽과 오른쪽에 나보다 작은 숫자가 존재한다면, 최후까지 남기는 것이 불가능
=> 이유: 인접한 두 풍선 중에 번호가 더 큰 풍선을 터트릴 수 있고, 더 작은 풍선은 한 번만 터트리는게 가능하다.
        그렇다면 번호가 큰 풍선 A가 살아남기 위해서는 A보다 값이 작은 풍선이 한쪽에만 한 번 있어야 하는데, 양쪽에 다 있으면 생존 불가능

답: 최후까지 남기는 것이 가능한 숫자

 */