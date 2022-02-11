package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SWEA3998 {
    static int N;
    static int[] tmp = new int[100000];
    static int[] A = new int[100000];
    static long cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++)
                A[i] = Integer.parseInt(st.nextToken());

            cnt = 0L;

            mergeSort(0, N-1);

            System.out.println("#" + tc + " " + cnt);

        }
    }

    private static void mergeSort(int left, int right) {
        int m;

        if(left < right) {
            m = (left + right) / 2;
            mergeSort(left, m);
            mergeSort(m+1, right);
            merge(left, m, right);
        }
    }

    private static void merge(int left, int m, int right) {
        int L = left;
        int R = m + 1;
        int k = left;

        while(L <= m && R <= right) {
            if(A[L] <= A[R]) {
                tmp[k++] = A[L++];
            }
            else {
                cnt = cnt + (m - L) + 1;
                tmp[k++] = A[R++];
            }
        }

        if(L > m) {
            for(int i = R; i <= right; i++)
                tmp[k++] = A[i];
        }
        else {
            for(int i = L; i <= m; i++)
                tmp[k++] = A[i];
        }

        for (int i = left; i <= right; i++)
            A[i] = tmp[i];

    }
}
