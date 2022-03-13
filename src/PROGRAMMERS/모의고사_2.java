package PROGRAMMERS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 모의고사_2 {
    public int[] solution(int[] answers) {
        int[] result = {0, 0, 0};
        List<Integer> list = new ArrayList<>();

        int[]a = new int[]{1, 2, 3, 4, 5};
        int[]b = new int[]{2, 1, 2, 3, 2, 4, 2, 5};
        int[]c = new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        for(int i = 0; i < answers.length; i++){
            if(answers[i] == a[i % a.length]) result[0]++;
            if(answers[i] == b[i % b.length]) result[1]++;
            if(answers[i] == c[i % c.length]) result[2]++;
        }

        for(int i = 0; i < result.length; i++) {
            if(result[i] == Arrays.stream(result).max().getAsInt()) {
                list.add(i+1);
           }
        }

        return list.stream().mapToInt(i -> i).toArray();
    }
}
