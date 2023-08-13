package Archiving.PROGRAMMERS;

import java.util.Stack;

public class 주식가격_2 {

    class Data {
        int price;
        int index;

        public Data(int price, int index) {
            this.price = price;
            this.index = index;
        }
    }

    public int[] solution(int[] prices) {
        int len = prices.length;
        int[] answer = new int[len];
        Stack<Data> s = new Stack<>();

        for (int i = 0; i < prices.length; i++) {
            Data data = new Data(prices[i], i);

            if (s.empty() || s.peek().price <= data.price) {
                s.push(data);
            } else {
                while (s.peek().price > data.price) {
                    answer[s.peek().index] = data.index - s.peek().index;
                    s.pop();

                    if (s.empty()) {
                        break;
                    }
                }

                s.push(data);
            }
        }

        while(!s.empty()) {
            Data data = s.pop();
            answer[data.index] = len - data.index - 1;
        }

        return answer;
    }
}
