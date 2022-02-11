package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SWEA1232 {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for(int tc = 1; tc <= 10; tc++) {
            N = Integer.parseInt(br.readLine());
            Tree1232 tr = new Tree1232();
            for(int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int num = Integer.parseInt(st.nextToken());
                char op = '0';
                int value = -1;
                int left = -1;
                int right = -1;
                if(st.countTokens() == 3) {
                    op = st.nextToken().charAt(0);
                    left = Integer.parseInt(st.nextToken());
                    right = Integer.parseInt(st.nextToken());
                }
                else {
                    value = Integer.parseInt(st.nextToken());
                }

                tr.add(num, value, op, left, right);
            }

            System.out.println("#" + tc + " " + tr.inOrder(tr.tree[1]));
        }
    }
}

class Data1232 {
    int value;
    char op;
    int left;
    int right;

    Data1232(int value, char op, int left, int right) {
        this.value = value;
        this.op = op;
        this.left = left;
        this.right = right;
    }
}

class Tree1232 {
    Data1232[] tree;

    Tree1232() {
        tree = new Data1232[1001];
    }

    public void add(int num, int value, char op, int left, int right) {
        tree[num] = new Data1232(value, op, left, right);
    }

    public int inOrder(Data1232 data) {
        int leftResult;
        int rightResult;

        if(data.op != '0') {
            leftResult = inOrder(tree[data.left]);
            rightResult = inOrder(tree[data.right]);

            if(data.op == '*') {
                return leftResult * rightResult;
            } else if(data.op == '/') {
                return leftResult / rightResult;
            } else if(data.op == '+') {
                return leftResult + rightResult;
            } else {
                return leftResult - rightResult;
            }
        }
        else
            return data.value;
    }
}