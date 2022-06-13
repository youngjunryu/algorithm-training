package BOJ;

import java.io.*;
import java.util.*;

public class BOJ14940 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        Queue<info> q = new LinkedList<>();


        int dx[] = {-1, 1, 0, 0};
        int dy[] = {0, 0, -1, 1};
        int N, M;

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int map[][] = new int[N][M];
        int route[][] = new int[N][M];
        boolean check[][] = new boolean[N][M];

        for (int i = 0; i < N; i++){
            for (int j = 0; j < M; j++){
                route[i][j] = -1;
            }
        }

        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2){
                    check[i][j] = true;
                    route[i][j] = 0;
                    q.add(new info(i, j, 0));
                }
            }
        }

        while (!q.isEmpty()){
            info info = q.remove();
            int x = info.x;
            int y = info.y;
            int move = info.move;
            route[x][y] = move;

            for (int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
                    continue;
                }

                if (check[nx][ny] || map[nx][ny] == 0) {
                    continue;
                }

                check[nx][ny] = true;

                q.add(new info(nx, ny, (move+1)));
            }
        }

        for (int i = 0; i < N; i++){
            for (int j = 0; j < M; j++){
                if (map[i][j] == 0) route[i][j] = 0;
            }
        }


        for (int i = 0; i < N; i++){
            for (int j = 0; j < M; j++){
                sb.append(route[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static class info{
        int x;
        int y;
        int move;

        info(int x, int y, int move){
            this.x = x;
            this.y = y;
            this.move = move;
        }
    }
}