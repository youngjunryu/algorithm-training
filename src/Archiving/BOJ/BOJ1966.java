package Archiving.BOJ;

import java.io.*;
import java.util.*;

class Data1966 {
     int order;
     int priority;

     Data1966(int order, int priority) {
     this.order = order;
     this.priority = priority;
     }
}

public class BOJ1966 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        while(t-- > 0) {
            ArrayList<Data1966> list = new ArrayList<>();
            st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine(), " ");
            for(int i = 0; i < n; i++)
                list.add(new Data1966(i, Integer.parseInt(st.nextToken())));

            int count = 1;
            Loop:
            while(!list.isEmpty()) {
                Data1966 data = list.get(0);
                for(int i = 1; i < list.size(); i++) {
                    if(list.get(i).priority > data.priority) {
                        list.remove(0);
                        list.add(data);
                        continue Loop;
                    }
                }
                if(data.order == m)
                    break;
                list.remove(0);
                count++;
            }
            System.out.println(count);
        }
    }
}
