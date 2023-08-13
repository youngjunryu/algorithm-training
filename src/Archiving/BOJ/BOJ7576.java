package Archiving.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ7576 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[][] store;
        Queue<int[]> queue = new LinkedList<>();
        int[] dx = new int[]{1, 0, -1, 0};
        int[] dy = new int[]{0, 1, 0, -1};
        int max = -1;
        boolean zero = false;

        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        store = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                store[i][j] = Integer.parseInt(st.nextToken());
                if (store[i][j] == 1) {
                    queue.add(new int[]{i, j});
                } else if (!zero && store[i][j] == 0) {
                    zero = true;
                }
            }
        }

        if (!zero) {
            System.out.println(0);
            return;
        }

        while(!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                for (int d = 0; d < 4; d++) {
                    int ny = cur[0] + dy[d];
                    int nx = cur[1] + dx[d];

                    if (ny >= N || ny < 0 || nx >= M || nx < 0 || store[ny][nx] == -1 || store[ny][nx] != 0) {
                        continue;
                    }

                    store[ny][nx] = store[cur[0]][cur[1]] + 1;
                    queue.add(new int[]{ny, nx});
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (store[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
                max = Math.max(store[i][j], max);
            }
        }

        System.out.println(max - 1);
    }
}
