package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ16935 {
    static int N;
    static int M;
    static int[][] arr;
    static int[][] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        result = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < R; i++) {
            int op = Integer.parseInt(st.nextToken());
            switch (op) {
                case 1:
                    reverseTopBottom();
                    break;
                case 2:
                    reverseLeftRight();
                    break;
                case 3:
                    rightRotate();
                    break;
                case 4:
                    leftRotate();
                    break;
                case 5:
                    partitionRightRotate();
                    break;
                case 6:
                    partitionLeftRotate();
                    break;
            }
        }

        print();
    }

    private static void reverseTopBottom() {
        result = new int[arr.length][arr[0].length];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                result[i][j] = arr[arr.length-i-1][j];
            }
        }

        arr = result;
    }

    private static void reverseLeftRight() {
        result = new int[arr.length][arr[0].length];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                result[i][j] = arr[i][arr[0].length-j-1];
            }
        }

        arr = result;
    }

    private static void rightRotate() {
        result = new int[arr[0].length][arr.length];

        for (int i = 0; i < arr[0].length; i++) {
            for (int j = 0; j < arr.length; j++) {
                result[i][j] = arr[arr.length-j-1][i];
            }
        }

        arr = result;
    }

    private static void leftRotate() {
        result = new int[arr[0].length][arr.length];

        for (int i = 0; i < arr[0].length; i++) {
            for (int j = 0; j < arr.length; j++) {
                result[i][j] = arr[j][arr[0].length-i-1];
            }
        }

        arr = result;
    }

    private static void partitionRightRotate() {
        result = new int[arr.length][arr[0].length];

        int r = arr.length;
        int c = arr[0].length;

        for (int i = 0; i < r/2; i++) {
            for (int j = 0; j < c/2; j++) {
                result[i][j] = arr[r/2+i][j];
            }
        }

        for (int i = 0; i < r/2; i++) {
            for (int j = c/2; j < c; j++) {
                result[i][j] = arr[i][j-c/2];
            }
        }

        for (int i = r/2; i < r; i++) {
            for (int j = c/2; j < c; j++) {
                result[i][j] = arr[i-r/2][j];
            }
        }

        for (int i = r/2; i < r; i++) {
            for (int j = 0; j < c/2; j++) {
                result[i][j] = arr[i][c/2+j];
            }
        }

        arr = result;
    }

    private static void partitionLeftRotate() {
        result = new int[arr.length][arr[0].length];

        int r = arr.length;
        int c = arr[0].length;

        for (int i = 0; i < r/2; i++) {
            for (int j = 0; j < c/2; j++) {
                result[i][j] = arr[i][c/2+j];
            }
        }

        for (int i = 0; i < r/2; i++) {
            for (int j = c/2; j < c; j++) {
                result[i][j] = arr[r/2+i][j];
            }
        }

        for (int i = r/2; i < r; i++) {
            for (int j = c/2; j < c; j++) {
                result[i][j] = arr[i][j-c/2];
            }
        }

        for (int i = r/2; i < r; i++) {
            for (int j = 0; j < c/2; j++) {
                result[i][j] = arr[i-r/2][j];
            }
        }

        arr = result;
    }

    private static void print() {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
