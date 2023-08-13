package Archiving.PROGRAMMERS;

public class 조이스틱_2 {
    public int solution(String name) {
        int answer = 0;
        int len = name.length();
        int index;
        int move = len - 1;

        for (int i = 0; i < name.length(); i++) {
            answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);

            index = i + 1;
            while (index < len && name.charAt(index) == 'A') {
                index++;
            }

            move = Math.min(move, i * 2 + len - index);
            move = Math.min(move, (len - index) * 2 + i);
        }

        return answer + move;
    }
}
