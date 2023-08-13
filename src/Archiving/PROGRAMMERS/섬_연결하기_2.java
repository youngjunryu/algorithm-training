package Archiving.PROGRAMMERS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 섬_연결하기_2 {
    private static class Data implements Comparable<Data> {

        int v1;
        int v2;
        int cost;

        public Data(int v1, int v2, int cost) {
            this.v1 = v1;
            this.v2 = v2;
            this.cost = cost;
        }

        @Override
        public int compareTo(Data data) {
            return this.cost - data.cost;
        }
    }

    List<Data> list;
    int[] parent;

    public int solution(int n, int[][] costs) {
        int answer = 0;
        list = new ArrayList<>();
        parent = new int[n];

        for (int[] cost : costs) {
            list.add(new Data(cost[0], cost[1], cost[2]));
        }

        Collections.sort(list);

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < list.size(); i++) {
            Data data = list.get(i);
            if (!isSameParent(data.v1, data.v2)) {
                answer += data.cost;
                union(data.v1, data.v2);
            }
        }

        return answer;
    }

    private void union(int v1, int v2) {
        v1 = find(v1);
        v2 = find(v2);

        if (v1 != v2)  {
            parent[v2] = v1;
        }
    }

    private int find(int p) {
        if (p == parent[p])  {
            return p;
        }
        return parent[p] = find(parent[p]);
    }

    private boolean isSameParent(int v1, int v2) {
        v1 = find(v1);
        v2 = find(v2);

        if (v1 == v2) {
            return true;
        }
        else {
            return false;
        }
    }
}

/*

4	[[0,1,1],[0,2,2],[1,2,5],[1,3,1],[2,3,8]]	4

 */