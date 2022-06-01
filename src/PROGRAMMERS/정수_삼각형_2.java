package PROGRAMMERS;

import java.util.Arrays;

public class 정수_삼각형_2 {
    public int solution(int[][] triangle) {
        int[][] result = new int[500][500];

        result[0][0] = triangle[0][0];

        for (int i = 1; i < triangle.length; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    result[i][j] = result[i-1][j];
                } else if (i == j) {
                    result[i][j] = result[i-1][j-1];
                } else {
                    result[i][j] = Math.max(result[i-1][j-1], result[i-1][j]);
                }

                result[i][j] += triangle[i][j];
            }
        }

        int[] arr = Arrays.copyOfRange(result[triangle.length-1], 0, triangle.length-1);
        Arrays.sort(arr);

        return arr[arr.length-1];
    }
}
