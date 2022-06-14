package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1916 {
    static final int INF = Integer.MAX_VALUE;
    static int N;
    static int M;
    static List<Data>[] graph;
    static int[] dist;
    static int start;
    static int end;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        graph = new List[N+1];
        dist = new int[N+1];
        Arrays.fill(dist, INF);

        for (int i = 1; i <= N; i++) {
            graph[i] = new LinkedList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[s].add(new Data(d, cost));
        }

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        dijkstra(start);

        System.out.println(dist[end]);
    }

    private static void dijkstra(int start) {
        PriorityQueue<Data> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[N+1];

        dist[start] = 0;
        pq.add(new Data(start, 0));

        while(!pq.isEmpty()) {
            Data data = pq.poll();
            int src = data.src;

            if (visited[src]) {
                continue;
            }

            visited[src] = true;

            for (Data next : graph[src]) {
                if (dist[next.src] > dist[src] + next.cost) {
                    dist[next.src] = dist[src] + next.cost;
                    pq.add(new Data(next.src, dist[next.src]));
                }
            }
        }
    }

    static class Data implements Comparable<Data> {
        int src;
        int cost;

        public Data(int src, int cost) {
            this.src = src;
            this.cost = cost;
        }


        @Override
        public int compareTo(Data o) {
            return this.cost - o.cost;
        }
    }
}
