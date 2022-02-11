package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SWEA1868 {
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    static int N;
    static char[][] map;
    static int[][] mCnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            map = new char[N][N];
            mCnt = new int[N][N];
            for(int i = 0; i < N; i++) {
                map[i] = br.readLine().toCharArray();
            }

            countMine();

            int result = 0;
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    if(mCnt[i][j] == 0 && map[i][j] != '*') {
                        click(i, j);
                        result++;
                    }
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(mCnt[i][j] > 0 && map[i][j] != '*') {
                        result++;
                    }
                }
            }

            System.out.println("#" + tc + " " + result);
        }
    }

    private static void click(int x, int y) {
        Queue<Data1868> queue = new LinkedList<>();
        queue.offer(new Data1868(x, y));

        mCnt[x][y] = -1;
        while(!queue.isEmpty()) {
            Data1868 data = queue.poll();
            for(int k = 0; k < 8; k++) {
                int nx = data.x + dx[k];
                int ny = data.y + dy[k];
                if(nx < 0 || ny < 0 || nx >= N || ny >= N || mCnt[nx][ny] == -1 || map[nx][ny] == '*')
                    continue;
                if(mCnt[nx][ny] == 0)
                    queue.offer(new Data1868(nx, ny));
                mCnt[nx][ny] = -1;
            }
        }
    }

    private static void countMine() {
        int nx, ny;

        for(int x = 0; x < N; x++) {
            for(int y = 0; y < N; y++) {
                if(map[x][y] == '.') {
                    int cnt = 0;
                    for(int k = 0; k < 8; k++) {
                        nx = x + dx[k];
                        ny = y + dy[k];
                        if(nx < 0 || ny < 0 || nx >= N || ny >= N || map[nx][ny] != '*')
                            continue;
                        cnt++;
                    }
                    mCnt[x][y] = cnt;
                }
            }
        }
    }
}

class Data1868 {
    int x;
    int y;

    Data1868(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
