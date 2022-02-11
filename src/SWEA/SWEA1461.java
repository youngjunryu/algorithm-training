package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SWEA1461 {
    static int[] dx = { 0, -1, 0, 1 };
    static int[] dy = { 1, 0, -1, 0 };
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int cnt;
    static int min;
    static ArrayList<int []> list;
    static int maxCore;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            visited = new boolean[N][N];
            list = new ArrayList<>();
            min = 987654321;
            maxCore = 0;

            for(int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if(map[i][j] == 1) {
                        if(i == 0 || j == 0 || i == N - 1 || j == N - 1) {
                            map[i][j] = -1;
                            continue;
                        }
                        list.add(new int[] {i, j});
                    }
                }
            }

            dfs(0, 0);

            System.out.println("#" + tc + " " + min);

        }
    }

    private static void dfs(int idx, int core) {
        if(idx == list.size()) {
            if (maxCore < core) {
                maxCore = core;
                min = cnt;
            } else if (maxCore == core) {
                min = Math.min(min, cnt);
            }
            return;
        }

        int nx = list.get(idx)[0];
        int ny = list.get(idx)[1];
        for(int i = 0; i < 4; i++) {
            if(isPossible(nx, ny, i)) {
                dfs(idx + 1, core + 1);
                initVisited(nx, ny, i);
            }
            else {
                dfs(idx + 1, core);
            }
        }
    }

    private static boolean isPossible(int x, int y, int dir) {

        int initX = x;
        int initY = y;

        boolean flag = true;

        while(true) {
            x = x + dx[dir];
            y = y + dy[dir];
            if(x < 0 || y < 0 || x == N || y == N)
                break;
            if(map[x][y] != 0 || visited[x][y]) {
                flag = false;
                break;
            }
        }

        if(flag) {
            while(true) {
                initX = initX + dx[dir];
                initY = initY + dy[dir];
                if(initX < 0 || initY < 0 || initX == N || initY == N)
                    break;
                visited[initX][initY] = true;
                cnt++;
            }
        }

        return flag;
    }

    private static void initVisited(int x, int y, int dir) {
        while(true) {
            x = x + dx[dir];
            y = y + dy[dir];
            if(x < 0 || y < 0 || x == N || y == N)
                break;
            visited[x][y] = false;
            cnt--;
        }
    }

}
