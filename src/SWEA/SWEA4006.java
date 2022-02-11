package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SWEA4006 {
    static int[] root;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
            int M = Integer.parseInt(br.readLine());

            root = new int[N+1];
            for(int i = 1; i <= N; i++) {
                root[i] = i;
            }

            PriorityQueue<Data4006> pq = new PriorityQueue<>();
            for(int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                pq.offer(new Data4006(s, e, c));
            }

            int result = 0;
            while(!pq.isEmpty()) {
                Data4006 data = pq.poll();
                if (find(data.s) == find(data.e))
                    continue;
                union(data.s, data.e);
                result += data.c;
            }

            System.out.println("#" + tc + " " + result);
        }
    }

    private static int find(int p) {
        if(p == root[p])
            return p;
        return root[p] = find(root[p]);
    }

    private static void union(int p1, int p2) {
        int a = find(p1);
        int b = find(p2);
        if(a != b)
            root[b] = a;
    }
}

class Data4006 implements Comparable<Data4006>{
    int s;
    int e;
    int c;

    Data4006(int s, int e, int c) {
        this.s = s;
        this.e = e;
        this.c = c;
    }

    @Override
    public int compareTo(Data4006 data) {
        return this.c <= data.c ? -1 : 1;
    }
}