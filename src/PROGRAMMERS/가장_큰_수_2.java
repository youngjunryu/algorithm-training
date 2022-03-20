package PROGRAMMERS;

import java.util.Arrays;
import java.util.Comparator;

public class 가장_큰_수_2 {
    public static String solution(int[] numbers) {
        String answer = "";
        StringBuilder sb = new StringBuilder();

        String[] arr = Arrays.stream(numbers).mapToObj(String::valueOf).toArray(String[]::new);
        Arrays.sort(arr, new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {
                int a = Integer.parseInt(o1 + o2);
                int b = Integer.parseInt(o2 + o1);

                if(a > b) return -1;
                else if(a < b) return 1;
                else return 0;
            }
        });

        if(arr[0].equals("0")) return "0";

        for(String s : arr)
            sb.append(s);

        return sb.toString();
    }

    public static void main(String[] args) {
        solution(new int[]{3, 30, 34, 5, 9});
    }
}

/*

[6, 10, 2]	"6210"
[3, 30, 34, 5, 9]	"9534330"



 */