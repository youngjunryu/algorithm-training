package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA12318 {

    private final static UserSolution12318 usersolution = new UserSolution12318();

    private static BufferedReader br;

    private static int cmd_bfs() throws Exception {

        int score = 100;
        int N, M, x1, y1, x2, y2, dist, ans;
        int[][] map = new int[10][10];
        String str;
        StringTokenizer st;

        br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();
        N = Integer.parseInt(str);

        for(int i = 0; i < N; i++) {
            str = br.readLine();
            st = new StringTokenizer(str, " ");
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        usersolution.bfs_init(N, map);

        str = br.readLine();
        M = Integer.parseInt(str);

        for(int i = 1; i <= M; i++) {
            str = br.readLine();
            st = new StringTokenizer(str, " ");
            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());
            ans = Integer.parseInt(st.nextToken());

            dist = usersolution.bfs(x1, y1, x2, y2);

            System.out.println(dist);

            if(dist != ans) {
                score = 0;
            }
        }
        return score;
    }

    public static void main(String[] args) throws Exception {
        System.out.println("#total score : " + cmd_bfs());
    }
}

class UserSolution12318 {
    static int[] dx = { 0, 1, 0, -1 };
    static int[] dy = { 1, 0, -1, 0 };

    static int[][] MAP;
    static Node12318[] arr;
    static boolean[][] visited;
    static int N;

    void bfs_init(int map_size, int map[][]) {
        MAP = map;
        N = map_size;
    }

    int bfs(int x1, int y1, int x2, int y2) {
        arr = new Node12318[101];
        visited = new boolean[N][N];
        int head = 0;
        int tail = 0;

        x1--;
        y1--;
        x2--;
        y2--;

        arr[head] = new Node12318(y1, x1, 0);
        visited[y1][x1] = true;

        int result = -1;
        while(arr[head] != null) {
            Node12318 node = arr[head];

            if (node.x == x2 && node.y == y2) {
                result = node.cost;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];
                if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                    if (MAP[ny][nx] == 0 && !visited[ny][nx]) {
                        visited[ny][nx] = true;
                        tail++;
                        arr[tail] = new Node12318(ny, nx, node.cost + 1);
                    }
                }
            }

            head++;
        }

        return result;
    }
}

class Node12318 {
    int x;
    int y;
    int cost;

    public Node12318(int y, int x, int cost) {
        this.x = x;
        this.y = y;
        this.cost = cost;
    }
}