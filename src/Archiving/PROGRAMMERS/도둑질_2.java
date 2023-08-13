package Archiving.PROGRAMMERS;

public class 도둑질_2 {
    public int solution(int[] money) {
        int answer = 0;

        int[] startFirst = new int[money.length];
        int[] notStartFirst = new int[money.length];

        startFirst[0] = money[0];
        startFirst[1] = money[0];

        notStartFirst[0] = 0;
        notStartFirst[1] = money[1];

        for (int i = 2; i < money.length - 1; i++) {

            startFirst[i] = Math.max(startFirst[i - 2] + money[i], startFirst[i - 1]);
        }

        for (int i = 2; i < money.length; i++) {

            notStartFirst[i] = Math.max(notStartFirst[i - 2] + money[i], notStartFirst[i - 1]);
        }

        return Math.max(startFirst[money.length - 2], notStartFirst[money.length - 1]);
    }
}
