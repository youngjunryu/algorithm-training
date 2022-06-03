package PROGRAMMERS;

public class 카펫_2 {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        int sum = brown + yellow;

        for (int i = 1; i <= Math.sqrt(sum); i++) {
            if (sum % i == 0) {
                int width = sum / i;
                int length = i;

                if (length <= 2) {
                    continue;
                }

                if ((width + length - 2) * 2 == brown) {
                    answer[0] = width;
                    answer[1] = length;
                    break;
                }
            }
        }
        return answer;
    }
}