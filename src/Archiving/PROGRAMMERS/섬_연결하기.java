package Archiving.PROGRAMMERS;

import java.util.*;

public class 섬_연결하기 {
    public static class Data implements Comparable<Data> {
        int v1;
        int v2;
        int cost;

        Data(int v1, int v2, int cost) {
            this.v1 = v1;
            this.v2 = v2;
            this.cost = cost;
        }

        @Override
        public int compareTo(Data o) {
            if(this.cost < o.cost)
                return -1;
            else if(this.cost == o.cost)
                return 0;
            else
                return 1;
        }
    }

    static List<Data> list;
    static int[] parent;

    public static int solution(int n, int[][] costs) {
        list = new ArrayList<>();
        for(int[] arr : costs)
            list.add(new Data(arr[0], arr[1], arr[2]));

        Collections.sort(list);

        parent = new int[n];
        for(int i = 0; i < n; i++)
            parent[i] = i;

        int sum = 0;
        for(int i = 0; i < list.size(); i++) {
            Data d = list.get(i);
            if(!isSameParent(d.v1, d.v2)) {
                sum += d.cost;
                union(d.v1, d.v2);
            }
        }

        return sum;
    }

    private static boolean isSameParent(int a, int b) {
        a = find(a);
        b = find(b);

        if(a == b) return true;
        else return false;
    }

    private static int find(int a) {
        if(parent[a] == a)
            return a;
        return parent[a] = find(parent[a]);
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if(a != b)
            parent[b] = a;
    }

    public static void main(String[] args) {
        System.out.println(solution(4, new int[][]{{0, 1, 1,}, {0, 2, 2}, {1, 2, 5}, {1, 3, 1}, {2, 3, 8}}));
    }
}
