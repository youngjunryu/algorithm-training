import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SWEA1233 {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for(int tc = 1; tc <= 10; tc++) {
            N = Integer.parseInt(br.readLine());
            Tree1233 tr = new Tree1233();
            for(int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int num = Integer.parseInt(st.nextToken());
                int value = st.nextToken().charAt(0);
                int left = 0;
                int right = 0;
                if (num * 2 <= N) {
                    left = Integer.parseInt(st.nextToken());
                }
                if (num * 2 + 1 <= N) {
                    right = Integer.parseInt(st.nextToken());
                }

                tr.add(num, value, left, right);
            }

            int result = tr.inOrder(tr.tree[1]) ? 1 : 0;
            System.out.println("#" + tc + " " + result);
        }
    }
}

class Data1233 {
    int value;
    int left;
    int right;

    Data1233(int value, int left, int right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}

class Tree1233 {
    Data1233[] tree;

    Tree1233() {
        tree = new Data1233[201];
    }

    public void add(int num, int value, int left, int right) {
        tree[num] = new Data1233(value, left, right);
    }

    public boolean inOrder(Data1233 data) {
        if(data == null)
            return false;

        if(data.value >= '0' && data.value <= '9') {
            if(data.left != 0 || data.right != 0)
                return false;
            else
                return true;
        }
        else {
            if(data.left == 0 || data.right == 0)
                return false;
            else
                return (inOrder(tree[data.left]) && inOrder(tree[data.right]));
        }
    }
}