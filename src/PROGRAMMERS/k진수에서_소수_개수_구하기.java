package PROGRAMMERS;

public class k진수에서_소수_개수_구하기 {
  public int solution(int n, int k) {
    int answer = 0;
    String primeNumber = createPrimeNumber(n, k);

    String[] numbers = primeNumber.split("0");
    for (String num : numbers) {
      if (num.length() != 0 && isPrime(Long.parseLong(num))) {
        answer++;
      }
    }

    return answer;
  }

  private boolean isPrime(long num) {
    if (num == 1) {
      return false;
    } else if (num == 2) {
      return true;
    }

    for (int i = 2; i < Math.sqrt(num) + 1; i++) {
      if (num % i == 0) {
        return false;
      }
    }

    return true;
  }

  private String createPrimeNumber(int n, int k) {
    StringBuilder sb = new StringBuilder();
    while (n > 0) {
      sb.append(n%k);
      n /= k;
    }
    return sb.reverse().toString();
  }
}
