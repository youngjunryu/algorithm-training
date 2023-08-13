package Archiving.PROGRAMMERS;

import java.util.Stack;

public class 주식가격 {

    class Data {
        int index;
        int price;

        public Data(int index, int price) {
            this.index = index;
            this.price = price;
        }
    }

    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Data> s = new Stack<>();

        for(int i = 0; i < prices.length; i++) {

            if(s.isEmpty() || s.peek().price <= prices[i])
                s.push(new Data(i, prices[i]));
            else {
                while(s.peek().price > prices[i]) {
                    answer[s.peek().index] = i - s.peek().index;
                    s.pop();

                    if(s.isEmpty())
                        break;
                }
                s.push(new Data(i, prices[i]));
            }
        }

        while(!s.isEmpty()) {
            answer[s.peek().index] = (prices.length - 1) - s.peek().index;
            s.pop();
        }

        return answer;
    }
}

