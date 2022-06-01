package PROGRAMMERS;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;

public class 전화번호_목록_2 {

    HashSet<String> set = new HashSet<>();

    public boolean solution(String[] phone_book) {
        boolean answer = true;

        Arrays.sort(phone_book, Comparator.comparingInt(String::length));

        for (String num : phone_book) {
            for (int i = 1; i <= num.length(); i++) {
                if (isContain(num, i)) {
                    return false;
                }
            }
            set.add(num);
        }

        return answer;
    }

    private boolean isContain(String num, int n) {
        String sub = num.substring(0, n);
        if (set.contains(sub)) {
            System.out.println("true");
            return true;
        }
        return false;
    }
}
