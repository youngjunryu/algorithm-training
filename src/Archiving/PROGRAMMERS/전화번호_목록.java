package Archiving.PROGRAMMERS;

import java.util.*;

public class 전화번호_목록 {
    public static boolean solution(String[] phone_book) {
        boolean answer = true;
        HashSet<String> set = new HashSet<>();

        Arrays.sort(phone_book, (a, b) -> a.length() - b.length());

        for(int i = 0; i < phone_book.length; i++) {
            if(!answer)
                break;
            for(int j = 1; j <= phone_book[i].length(); j++) {
                if(set.contains(phone_book[i].substring(0, j))) {
                    answer = false;
                    break;
                }
            }

            set.add(phone_book[i]);
        }

        return answer;
    }
}

/*
public class Archiving.PROGRAMMERS.전화번호_목록 {
    public static boolean solution(String[] phone_book) {

        for(int i = 0; i < phone_book.length - 1; i++) {
            for(int j = i + 1; j < phone_book.length; j++) {
                if(phone_book[i].startWith(phone_book[j])) return false;
                if(phone_book[j].startWith(phone_book[i])) return false;
            }
        }

        return true;
    }
}
 */
