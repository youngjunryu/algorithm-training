package Archiving.BOJ;

import java.io.*;

public class BOJ9663 {
    static int n;
    static int[] board;
    static int count = 0;

    private static boolean check(int row) {
        for(int i = 1; i < row; i++) {
            if(board[i] == board[row] || Math.abs(board[row] - board[i]) == row - i)
                return false;
        }
        return true;
    }

    private static void nQueen(int row) {
        if(row == n + 1) {
            count++;
            return;
        }

        for(int i = 1; i < n + 1; i++) {
            board[row] = i;
            if(check(row))
                nQueen(row + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        board = new int[n+1];
        nQueen(1);
        System.out.print(count);
    }
}

