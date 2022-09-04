package PROGRAMMERS.simul.test7;

public class Two {
  public int solution(int n, int[] lost, int[] reserve) {
    int answer = 0;

    int[] student = new int[n + 1];

    for (int l : lost) {
      student[l] = -1;
    }

    for (int r : reserve) {
      student[r]++;
    }

    for (int i = 1; i < student.length; i++) {
      if (student[i] == -1) {
        if (i - 1 > 0 && student[i - 1] == 1) {
          student[i - 1] = 0;
          student[i] = 0;
        } else if (i + 1 <= n && student[i + 1] == 1) {
          student[i + 1] = 0;
          student[i] = 0;
        }
      }
    }

    for (int i = 1; i < student.length; i++) {
      if (student[i] >= 0) {
        answer++;
      }
    }

    return answer;
  }
}
