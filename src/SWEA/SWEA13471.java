package SWEA;

import java.util.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
    private final static int CMD_INIT = 1;
    private final static int CMD_REQUEST = 2;
    private final static int CMD_STATUS = 3;

    private final static UserSolution13471 usersolution = new UserSolution13471();

    private static boolean run(BufferedReader br) throws Exception {
        int q = Integer.parseInt(br.readLine());

        int l, m, timestamp, pid, mline, eid, mtime;
        int cmd, ans, ret = 0;
        boolean okay = false;

        for (int i = 0; i < q; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            cmd = Integer.parseInt(st.nextToken());
            switch (cmd) {
                case CMD_INIT:
                    l = Integer.parseInt(st.nextToken());
                    m = Integer.parseInt(st.nextToken());
                    usersolution.init(l, m);
                    okay = true;
                    break;
                case CMD_REQUEST:
                    timestamp = Integer.parseInt(st.nextToken());
                    pid = Integer.parseInt(st.nextToken());
                    mline = Integer.parseInt(st.nextToken());
                    eid = Integer.parseInt(st.nextToken());
                    mtime = Integer.parseInt(st.nextToken());
                    ans = Integer.parseInt(st.nextToken());
                    ret = usersolution.request(timestamp, pid, mline, eid, mtime);
                    if (ret != ans)
                        okay = false;
                    break;
                case CMD_STATUS:
                    timestamp = Integer.parseInt(st.nextToken());
                    pid = Integer.parseInt(st.nextToken());
                    ans = Integer.parseInt(st.nextToken());
                    ret = usersolution.status(timestamp, pid);
                    if (ret != ans)
                        okay = false;
                    break;
                default:
                    okay = false;
                    break;
            }
        }
        return okay;
    }

    public static void main(String[] args) throws Exception {
        int TC, MARK;

        //System.setIn(new java.io.FileInputStream("res/sample_input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        TC = Integer.parseInt(st.nextToken());
        MARK = Integer.parseInt(st.nextToken());

        for (int testcase = 1; testcase <= TC; ++testcase) {
            int score = run(br) ? MARK : 0;
            System.out.println("#" + testcase + " " + score);
        }

        br.close();
    }
}

class UserSolution13471 {
    static class Product {
        int pId;
        int mLine;
        int eId;
        int mTime;

        public Product(int pId, int mLine, int eId, int mTime) {
            this.pId = pId;
            this.mLine = mLine;
            this.eId = eId;
            this.mTime = mTime;
        }
    }

    static class Job {
        Product product;
        int endTime;

        public Job(Product product, int endTime) {
            this.product = product;
            this.endTime = endTime;
        }
    }

    private final int MAX = 500;

    Map<Integer, Integer> statusMap = new HashMap<>();
    PriorityQueue<Job> pq = new PriorityQueue<>((p1, p2) -> p1.endTime - p2.endTime);
    Queue<Product>[] lineQue = new Queue[MAX];
    int[] lineUse = new int[MAX];
    boolean[] equipUse = new boolean[MAX];
    int L, M;

    public UserSolution13471() {
        for (int i = 0; i < MAX; i++) {
            lineQue[i] = new LinkedList<>();
        }
    }

    void init(int L, int M) {
        this.L = L; this.M = M;
        Arrays.fill(lineUse, -1);
        Arrays.fill(equipUse, false);

        for (int i = 0; i < MAX; i++) {
            lineQue[i].clear();
        }
        pq.clear();
        statusMap.clear();
    }

    // time 시간 까지의 작업을 한다.
    void execute(int time) {
        while (!pq.isEmpty() && pq.peek().endTime <= time) {
            int now = pq.peek().endTime;

            while (!pq.isEmpty() && pq.peek().endTime == now) {
                Job job = pq.poll();
                if (job.product == null) continue;
                Product product = job.product;
                lineUse[product.mLine] = -1;
                equipUse[product.eId] = false;
                statusMap.put(product.pId, 3);
            }

            for (int i = 0; i < L; i++) {
                if (lineUse[i] == -1 && !lineQue[i].isEmpty()) {
                    Product product = lineQue[i].peek();

                    if (!equipUse[product.eId]) {
                        equipUse[product.eId] = true;
                        lineUse[product.mLine] = product.pId;
                        statusMap.put(product.pId, 2);
                        pq.offer(new Job(product, now + product.mTime));
                        lineQue[i].poll();
                    }
                }
            }
        }
    }

    int request(int tStamp, int pId, int mLine, int eId, int mTime) {
        execute(tStamp - 1);
        lineQue[mLine].offer(new Product(pId, mLine, eId, mTime));
        statusMap.put(pId, 1);
        pq.offer(new Job(null, tStamp));
        execute(tStamp);
        return lineUse[mLine] == -1 ? -1 : lineUse[mLine];
    }

    int status(int tStamp, int pId) {
        execute(tStamp);
        return statusMap.getOrDefault(pId, 0);
    }
}
