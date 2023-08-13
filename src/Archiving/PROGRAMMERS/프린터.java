package Archiving.PROGRAMMERS;

import java.util.*;

public class 프린터 {

    static class Node {
        int priority;
        int order;

        public Node(int priority, int order) {
            this.priority = priority;
            this.order = order;
        }
    }

    public static int solution(int[] priorities, int location) {
        List<Node> list = new LinkedList<>();
        int cnt = 0;

        for(int i = 0; i < priorities.length; i++)
            list.add(new Node(priorities[i], i));

        while(true) {
            Node node = list.get(0);
            boolean flag = false;

            for(int j = 1; j < list.size(); j++) {
                if(list.get(j).priority > node.priority) {
                    list.add(list.remove(0));
                    flag = true;
                    break;
                }
            }

            if(flag) continue;

            list.remove(0);
            cnt++;

            if(node.order == location) return cnt;
        }
    }
}

