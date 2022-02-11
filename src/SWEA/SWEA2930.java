package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SWEA2930 {
    static int[] tree;
    static int heapSize;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb;

        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++) {
            sb = new StringBuilder();
            int N = Integer.parseInt(br.readLine());
            init(N);
            for(int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                if(Integer.parseInt(st.nextToken()) == 1)
                    push(Integer.parseInt(st.nextToken()));
                else {
                    sb.append(pop() + " ");
                }
            }
            System.out.println("#" + tc + " " + sb);
        }
    }

    private static void init(int N) {
        tree = new int[N];
        heapSize = 0;
    }

    private static void push(int value) {
        tree[heapSize] = value;

        int current = heapSize;

        while(current > 0 && tree[current] > tree[(current - 1) / 2]) {
            int temp = tree[current];
            tree[current] = tree[(current - 1) / 2];
            tree[(current - 1) / 2] = temp;
            current = (current - 1) / 2;
        }

        heapSize++;
    }

    private static int pop() {
        if(heapSize == 0)
            return -1;

        int value = tree[0];
        heapSize--;
        tree[0] = tree[heapSize];

        int current = 0;
        while(current * 2 + 1 < heapSize) {
            int child;
            if(current * 2 + 2 == heapSize)
                child = current * 2 + 1;
            else
                child = tree[current * 2 + 1] > tree[current * 2 + 2] ? current * 2 + 1 : current * 2 + 2;

            if(tree[current] > tree[child])
                break;

            int temp = tree[current];
            tree[current] = tree[child];
            tree[child] = temp;
            current = child;
        }

        return value;
    }
}

/*
2
3
1 1
2
2
5
1 3
1 5
2
1 1
2
 */