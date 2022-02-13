package PROGRAMMERS;

import java.util.*;

public class 정수_삼각형 {
    public int solution(int[][] triangle) {
        int[][] arr = new int[500][500];

        arr[0][0] = triangle[0][0];

        for(int i = 1; i < triangle.length; i++) {
            for(int j = 0; j <= i; j++) {
                if(j == 0)
                    arr[i][j] = arr[i-1][j];
                else if(j == i)
                    arr[i][j] = arr[i-1][j-1];
                else
                    arr[i][j] = arr[i-1][j-1] > arr[i-1][j] ? arr[i-1][j-1] : arr[i-1][j];

                arr[i][j] += triangle[i][j];
            }
        }

        int[] last = Arrays.copyOfRange(arr[triangle.length - 1], 0, triangle.length - 1);
        Arrays.sort(last);

        return last[last.length - 1];
    }
}
