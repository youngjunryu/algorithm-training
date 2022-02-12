package PROGRAMMERS;

import java.util.*;

public class 가장_큰_수 {
    public String solution(int[] numbers) {
        StringBuilder sb = new StringBuilder();
        String[] arr = new String[numbers.length];

        for(int i = 0; i < numbers.length; i++)
            arr[i] = Integer.toString(numbers[i]);

        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int a = Integer.parseInt(o1 + o2);
                int b = Integer.parseInt(o2 + o1);

                if(a > b) return -1;
                else if (a < b) return 1;
                else return 0;
            }
        });

        if(arr[0].equals("0")) return "0";

        for(String s : arr)
            sb.append(s);

        return sb.toString();
    }
}
