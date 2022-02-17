package SWEA;

import java.util.*;

class UserSolution {
    class Point {
        int value;
        int r;
        int c;
    }

    int[][] map = new int[2001][2001];

    Point[][][] area = new Point[60][60][5];

    int[][] plusHeight = new int[60][60];
    int n, k;

    PriorityQueue<Point> pq = new PriorityQueue<>((o1, o2) -> {
        int h1 = getHeight(o1);
        int h2 = getHeight(o2);
        if (h1 != h2) return h2 - h1;
        return o1.r != o2.r ? o1.r - o2.r : o1.c - o2.c;
    });

    void init(int N, int K, int mHeight[][]) {
        n = N;
        k = K;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                map[i][j] = mHeight[i-1][j-1];
                Point point = new Point();
                point.value = map[i][j];
                point.r = i;
                point.c = j;

                selectionSort(area[(i-1)/k][(j-1)/k], point);
            }
        }
    }

    void selectionSort(Point[] arr, Point point) {
        for (int i = 0; i < 5; i++) {
            if (arr[i] == null) {
                arr[i] = point;
                return;
            }

            if (arr[i].value < point.value) {
                for (int j = 4; j > i; j--) {
                    arr[j] = arr[j - 1];
                }

                arr[i] = point;
                return;
            }
        }

        pq.clear();
    }

    void destroy() {
        for (int i = 0; i < 60; i++) {
            for (int j = 0; j < 60; j++) {
                Arrays.fill(area[i][j], null);
            }
        }

        for (int i = 0; i < 60; i++) {
            Arrays.fill(plusHeight[i], 0);
        }
    }

    void query(Point mA, Point mB, int mCount, Point mTop[]) {
        for (int i = mA.r; i < mB.r; i += k) {
            for (int j = mA.c; j < mB.c; j += k) {
                for (int l = 0; l < mCount; l++) {
                    if (area[(i-1) / k][(j-1) / k][l] == null) break;
                    pq.offer(area[(i-1) / k][(j-1) / k][l]);
                }
            }
        }

        for (int i = 0; i < mCount; i++) {
            mTop[i] = pq.poll();
        }

        pq.clear();
    }

    void work(Point mA, Point mB, int mH) {
        for (int i = mA.r; i < mB.r; i += k) {
            for (int j = mA.c; j < mB.c; j += k) {
                plusHeight[(i-1) / k][(j-1) / k] += mH;
            }
        }
    }

    int getHeight(Point mP) {
        return map[mP.r][mP.c] + plusHeight[(mP.r -1) / k][(mP.c -1) / k];
    }
}
