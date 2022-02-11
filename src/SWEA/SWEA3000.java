package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SWEA3000 {
    static final int MODULER = 20171109;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++) {
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int A = Integer.parseInt(st.nextToken());
            int sum = 0;

            maxHeap.offer(A);

            for(int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                while(st.hasMoreTokens()) {
                    int k = Integer.parseInt(st.nextToken());
                    int mid = maxHeap.peek();
                    if(maxHeap.size() > minHeap.size()) {
                        if(k < mid) {
                            minHeap.offer(maxHeap.poll());
                            maxHeap.offer(k);
                        } else {
                            minHeap.offer(k);
                        }
                    } else if(maxHeap.size() == minHeap.size()) {
                        if(k > mid) {
                            minHeap.offer(k);
                            maxHeap.offer(minHeap.poll());
                        } else {
                            maxHeap.offer(k);
                        }
                    }
                }

                sum += maxHeap.peek() % MODULER;
                sum %= MODULER;
            }

            System.out.println("#" + tc + " " + sum);
        }
    }
}