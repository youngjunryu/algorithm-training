package BOJ;

import java.util.*;
import java.io.*;

class Data22942 implements Comparable<Data22942>{
    int xPoint;
    String status;
    int num;

    Data22942(int xPoint, String status, int num) {
        this.xPoint = xPoint;
        this.status = status;
        this.num = num;
    }

    @Override
    public int compareTo(Data22942 data) {
        if(this.xPoint < data.xPoint) {
            return -1;
        } else if(this.xPoint == data.xPoint) {
            return 0;
        } else {
            return 1;
        }
    }
}

public class BOJ22942 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Stack<Data22942> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        List<Data22942> list = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int center = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            Data22942 openData = new Data22942(center - r, "open", i);
            Data22942 closeData = new Data22942(center + r, "close", i);
            list.add(openData);
            list.add(closeData);
        }

        Collections.sort(list);
        for(Data22942 data : list) {
            if(stack.isEmpty())
                stack.push(data);
            else {
                if(stack.peek().num == data.num)
                    stack.pop();
                else {
                    if(stack.peek().status != data.status) {
                        System.out.print("NO");
                        return;
                    }
                    stack.push(data);
                }
            }
        }
        System.out.print("YES");
    }
}
