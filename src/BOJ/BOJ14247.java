package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ14247 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        long answer = 0;

        int n = Integer.parseInt(br.readLine());
        Tree[] trees = new Tree[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            trees[i] = new Tree(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            trees[i].grow = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(trees);

        for (int i = 0; i < n; i++) {
            answer += trees[i].length + trees[i].grow * i;
        }

        System.out.println(answer);
    }

    static class Tree implements Comparable<Tree> {
        int length;
        int grow;

        Tree(int length){
            this.length = length;
        }

        @Override
        public int compareTo(Tree o) {
            return Integer.compare(this.grow, o.grow);
        }
    }
}