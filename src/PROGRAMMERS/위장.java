package PROGRAMMERS;

import java.util.*;

public class 위장 {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> map = new HashMap<>();
        int answer = 1;

        for(String[] arr : clothes) {
            if(!map.containsKey(arr[1]))
                map.put(arr[1], 1);
            else
                map.put(arr[1], map.get(arr[1]) + 1);
        }

        for(Map.Entry<String, Integer> entry : map.entrySet())
            answer *= entry.getValue() + 1;

        return answer - 1;
    }
}
