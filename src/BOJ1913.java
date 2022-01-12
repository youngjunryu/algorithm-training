import java.util.*;
import java.io.*;

public class BOJ1913 {
    // 상 우 하 좌
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int n = sc.nextInt();
        int search = sc.nextInt();
        int[][] board = new int[n][n];
        int[]result = new int[2];

        int direction = 0;
        int x = n / 2;
        int y = n / 2;
        board[x][y] = 1;

        if(search == 1) {
            result[0] = x + 1;
            result[1] = y + 1;
        }


        for(int i = 2; i <= n*n; i++) {
            x = x + dx[direction];
            y = y + dy[direction];

            if(i == search) {
                result[0] = x + 1;
                result[1] = y + 1;
            }

            board[x][y] = i;

            int tDirection = (direction + 1) > 3 ? 0 : direction + 1;

            int tx = x + dx[tDirection];
            int ty = y + dy[tDirection];
            if (board[tx][ty] == 0) {
                direction++;
                if (direction > 3) direction = 0;
            }
        }

        for(int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(board[i][j]).append(" ");
            }
            sb.append("\n");
        }
        sb.append(result[0]).append(" ").append(result[1]);
        System.out.printf(sb.toString());
    }
}
