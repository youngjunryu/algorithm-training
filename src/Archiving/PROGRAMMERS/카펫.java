package Archiving.PROGRAMMERS;

import java.util.ArrayList;
import java.util.List;

public class 카펫 {
    public int[] solution(int brown, int yellow) {

        int carpet = brown + yellow;

        List<int []> list = new ArrayList<>();
        for(int i = 1; i*i <= carpet; i++) {
            if(carpet % i == 0) {
                list.add(new int[]{carpet / i, i});
            }
        }

        int answer1 = 0, answer2 = 0;
        for(int[] arr : list) {
            if(brown == (arr[0] + arr[1] - 2) * 2) {
                answer1 = arr[0];
                answer2 = arr[1];
            }
        }

        return new int[]{answer1, answer2};
    }
}
