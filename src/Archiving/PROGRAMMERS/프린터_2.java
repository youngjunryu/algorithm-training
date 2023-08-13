package Archiving.PROGRAMMERS;

import java.util.LinkedList;
import java.util.List;

public class 프린터_2 {

    private class Data {
        int priority;
        int idx;

        public Data(int priority, int idx) {
            this.priority = priority;
            this.idx = idx;
        }
    }

    public int solution(int[] priorities, int location) {
        int answer = 0;

        List<Data> list = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            list.add(new Data(priorities[i], i));
        }

        while (true) {
            Data data = list.get(0);
            boolean flag = false;

            for (int i = 1; i < list.size(); i++) {
                if (data.priority < list.get(i).priority) {
                    list.add(list.remove(0));
                    flag = true;
                    break;
                }
            }

            if (flag) {
                continue;
            }

            list.remove(0);
            answer++;

            if (data.idx == location) {
                break;
            }
        }

        return answer;
    }
}