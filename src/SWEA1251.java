import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SWEA1251 {
    static int[] root;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
            int[][] map = new int[N+1][2];
            st = new StringTokenizer(br.readLine());
            for(int i = 1; i <= N; i++)
                map[i][0] = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            for(int i = 1; i <= N; i++)
                map[i][1] = Integer.parseInt(st.nextToken());

            double E = Double.parseDouble(br.readLine());

            root = new int[N+1];
            for (int i = 1; i <= N; ++i)
                root[i] = i;

            PriorityQueue<Data1251> pq = new PriorityQueue<>();
            for(int i = 1; i <= N; i++) {
                for(int j = i + 1; j <= N; j++) {
                    long disX = (long)(map[i][0] - map[j][0]) * (map[i][0] - map[j][0]);
                    long disY = (long)(map[i][1] - map[j][1]) * (map[i][1] - map[j][1]);
                    long distance = (long)(disX + disY);
                    pq.offer(new Data1251(i, j, distance));
                }
            }

            double result = 0;
            while(!pq.isEmpty()) {
                Data1251 data = pq.poll();
                int p1 = find(data.start);
                int p2 = find(data.end);
                if(p1 == p2)
                    continue;
                union(p1, p2);
                result += E * data.d;
            }

            System.out.println("#" + tc + " " + Math.round(result));
        }
    }

    private static int find(int p) {
        if(p != root[p])
            return find(root[p]);
        return p;
    }

    private static void union(int p1, int p2) {
        if(p1 < p2)
            root[p2] = root[p1];
        else
            root[p1] = root[p2];
    }
}

class Data1251 implements Comparable<Data1251> {
    int start;
    int end;
    long d;
    Data1251(int start, int end, long d) {
        this.start = start;
        this.end = end;
        this.d = d;
    }

    @Override
    public int compareTo(Data1251 data) {
        return this.d <= data.d ? -1 : 1;
    }
}
