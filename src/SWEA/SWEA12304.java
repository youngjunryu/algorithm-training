package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA12304 {

    private final static int MAX_NODE = 10000;
    private final static int ADD_HEAD = 1;
    private final static int ADD_TAIL = 2;
    private final static int ADD_NUM = 3;
    private final static int FIND = 4;
    private final static int REMOVE = 5;
    private final static int PRINT = 6;
    private final static int PRINT_REVERSE = 7;
    private final static int END = 99;

    private final static SWEA12304Solution usersolution = new SWEA12304Solution();

    private static BufferedReader br;

    public static void run() throws Exception {
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

                case FIND :
                    data = Integer.parseInt(st.nextToken());
                    num = usersolution.findNode(data);
                    System.out.println(num);
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

                case PRINT_REVERSE :
                    ret = usersolution.getReversedList(output);
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
        System.setIn(new java.io.FileInputStream("./src/dll_input.txt"));

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

class Node12304 {
    public int data;
    public Node12304 prev;
    public Node12304 next;

    public Node12304(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

class SWEA12304Solution {

    private final static int MAX_NODE = 10000;

    private Node12304[] node = new Node12304[MAX_NODE];
    private int nodeCnt = 0;
    private Node12304 head;
    private Node12304 tail;

    public Node12304 getNode(int data) {
        node[nodeCnt] = new Node12304(data);
        return node[nodeCnt++];
    }

    public void init() {
        head = getNode(-1);
        tail = getNode(-1);

        head.next = tail;
        tail.prev = head;
    }

    public void addNode2Head(int data) {
        Node12304 node = getNode(data);
        node.next = head.next;
        node.prev = head;
        head.next = node;
        node.next.prev = node;
    }

    public void addNode2Tail(int data) {
        Node12304 node = getNode(data);
        node.prev = tail.prev;
        node.next = tail;
        tail.prev = node;
        node.prev.next = node;
    }

    public void addNode2Num(int data, int num) {
        Node12304 node = getNode(data);
        Node12304 pointer = head;

        if(num == 1) {
            node.prev = head;
            node.next = head.next;
            head.next = node;
            node.next.prev = node;
        }
        else {
            for(int i = 0; i < num - 1; i++)
                pointer = pointer.next;

            node.prev = pointer;
            node.next = pointer.next;
            node.next.prev = node;
            pointer.next = node;
        }
    }

    public int findNode(int data) {
        int order = 0;
        Node12304 pointer = head;
        while(pointer.next.data != data) {
            pointer = pointer.next;
            order++;
        }

        order++;

        return order;
    }

    public void removeNode(int data) {
        Node12304 pointer = head;

        while(pointer.next.data != data) {
            pointer = pointer.next;
            if(pointer.next == null) return;
        }

        pointer.next = pointer.next.next;
        pointer.next.prev = pointer;
    }

    public int getList(int[] output) {
        int cnt = 0;
        Node12304 pointer = head;

        for(int i = 0; pointer.next != tail ; i++){
            pointer = pointer.next;
            output[i] = pointer.data;
            cnt++;
        }

        return cnt;
    }

    public int getReversedList(int[] output) {
        int cnt = 0;
        Node12304 pointer = tail;

        for(int i = 0; pointer.prev != head ; i++){
            pointer = pointer.prev;
            output[i] = pointer.data;
            cnt++;
        }

        return cnt;
    }
}