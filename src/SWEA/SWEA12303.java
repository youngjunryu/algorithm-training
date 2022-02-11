package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA12303 {

    private final static int MAX_NODE = 10000;
    private final static int ADD_HEAD = 1;
    private final static int ADD_TAIL = 2;
    private final static int ADD_NUM = 3;
    private final static int REMOVE = 4;
    private final static int PRINT = 5;
    private final static int END = 99;

    private final static SWEA12303Solution usersolution = new SWEA12303Solution();

    private static BufferedReader br;

    private static void run() throws Exception {

        int cmd, data, num, ret;
        int[] output = new int[MAX_NODE];
        String str;
        StringTokenizer st;

        while(true) {
            str = br.readLine();
            st = new StringTokenizer(str, " ");
            cmd = Integer.parseInt(st.nextToken());

            switch(cmd) {
                case ADD_HEAD :
                    data = Integer.parseInt(st.nextToken());
                    usersolution.addNode2Head(data);
                    break;

                case ADD_TAIL :
                    data = Integer.parseInt(st.nextToken());
                    usersolution.addNode2Tail(data);
                    break;

                case ADD_NUM :
                    data = Integer.parseInt(st.nextToken());
                    num = Integer.parseInt(st.nextToken());
                    usersolution.addNode2Num(data, num);
                    break;

                case REMOVE :
                    data = Integer.parseInt(st.nextToken());
                    usersolution.removeNode(data);
                    break;

                case PRINT :
                    ret = usersolution.getList(output);
                    for(int i = 0; i < ret; i++) {
                        System.out.print(output[i] + " ");
                    }
                    System.out.println();
                    break;

                case END :
                    return;
            }
        }
    }
    public static void main(String[] args) throws Exception {
        int TC;
        System.setIn(new java.io.FileInputStream("./src/sll_input.txt"));

        br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        TC = Integer.parseInt(str);

        for (int tc = 1; tc <= TC; tc++) {
            System.out.println("#" + tc);
            usersolution.init();
            run();
            System.out.println();
        }
    }
}

class Node {
    public int data;
    public Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class SWEA12303Solution {

    private final static int MAX_NODE = 10000;

    private Node[] node = new Node[MAX_NODE];
    private int nodeCnt = 0;
    private Node head;

    public Node getNode(int data) {
        node[nodeCnt] = new Node(data);
        return node[nodeCnt++];
    }

    public void init() {
        head = new Node(-1);
    }

    public void addNode2Head(int data) {
        Node node = getNode(data);
        node.next = head.next;
        head.next = node;
    }

    public void addNode2Tail(int data) {
        Node node = getNode(data);
        Node pointer = head;
        while(pointer.next != null)
            pointer = pointer.next;

        node.next = pointer.next;
        pointer.next = node;
    }

    public void addNode2Num(int data, int num) {
        Node node = getNode(data);
        Node pointer = head.next;

        if(num == 1) {
            node.next = head.next;
            head.next = node;
        }
        else if(num == 2) {
            node.next = pointer.next;
            pointer.next = node;
        }
        else {
            for(int i = 0; i < num - 2; i++) {
                pointer = pointer.next;
            }
            node.next = pointer.next;
            pointer.next = node;
        }
    }

    public void removeNode(int data) {
        Node pointer = head;

        while(pointer.next.data != data) {
            pointer = pointer.next;
            if(pointer.next == null) return;
        }

        pointer.next = pointer.next.next;
    }

    public int getList(int[] output) {
        int cnt = 0;
        Node pointer = head;

        for(int i = 0; pointer.next != null ; i++){
            pointer = pointer.next;
            output[i] = pointer.data;
            cnt++;
        }

        return cnt;
    }
}