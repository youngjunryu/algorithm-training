import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SWEA1249 {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int N;
    static int[][] map;
    static int[][] dist;
    static final int INF = 987654321;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            dist = new int[N][N];

            for(int i = 0; i < N; i++) {
                String str = br.readLine();
                for(int j = 0; j < N; j++)
                    map[i][j] = str.charAt(j) - '0';
            }

            for(int i = 0; i < N; i++)
                Arrays.fill(dist[i], INF);

            dijkstra();
            System.out.println("#" + tc + " " + dist[N-1][N-1]);
        }
    }

    private static void dijkstra() {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] <= b[2] ? -1 : 1);
        dist[0][0] = 0;
        pq.offer(new int[]{0, 0, 0});

        while(!pq.isEmpty()) {
            int[] p = pq.poll();
            int x = p[0];
            int y = p[1];
            int d = p[2];

            if(dist[x][y] < d)
                continue;
            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx >= 0 && ny >= 0 && nx < N && ny < N) {
                    if(dist[nx][ny] > map[nx][ny] + d) {
                        dist[nx][ny] = map[nx][ny] + d;
                        pq.offer(new int[]{ nx, ny, dist[nx][ny]});
                    }
                }
            }
        }
    }
}
/*
10
4
0100
1110
1011
1010
 */