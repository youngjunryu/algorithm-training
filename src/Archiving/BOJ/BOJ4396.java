package Archiving.BOJ;

import java.io.*;

public class BOJ4396 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        char[][] bomb = new char[n][n];
        char[][] board = new char[n][n];
        int[] dr = {-1, 0, 1, 0, -1, 1, 1, -1};
        int[] dc = {0, 1, 0, -1, 1, 1, -1, -1};
        boolean flag = false;

        for(int i = 0; i < n; i++) {
            String str = br.readLine();
            for(int j = 0; j < n; j++) {
                bomb[i][j] = str.charAt(j);
            }
        }

        for(int i = 0; i < n; i++) {
            String str = br.readLine();
            for(int j = 0; j < n; j++) {
                if(str.charAt(j) == 'x') {
                    if(bomb[i][j] == '*') {
                        flag = true;
                        bomb[i][j] = '@';
                    }
                    else
                        bomb[i][j] = 'x';
                }
            }
        }

        for(int r = 0; r < n; r++) {
            for(int c = 0; c < n; c++) {
                if(bomb[r][c] != 'x') continue;
                int count = 0;
                for(int k = 0; k < 8; k++) {
                    int tr = r + dr[k];
                    int tc = c + dc[k];
                    if(tr < 0 || tc < 0 || tr >= n || tc >= n) continue;
                    if(bomb[tr][tc] == '*' || bomb[tr][tc] == '@') count++;
                }
                bomb[r][c] = Integer.toString(count).charAt(0);
            }
        }

        if(flag) {
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if(bomb[i][j] == '@')
                        sb.append('*');
                    else
                        sb.append(bomb[i][j]);
                }
                sb.append("\n");
            }
        }
        else {
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if(bomb[i][j] >= 48 && bomb[i][j] <= 56)
                        sb.append(bomb[i][j]);
                    else
                        sb.append('.');
                }
                sb.append("\n");
            }
        }

        System.out.print(sb);

    }
}
