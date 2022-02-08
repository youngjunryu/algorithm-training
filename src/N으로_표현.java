import java.util.*;

public class N으로_표현 {
    public int solution(int N, int number) {
        List<Set<Long>> list = new ArrayList<>();
        int answer = -1;

        list.add(null);
        list.add(new HashSet<>());
        list.get(1).add(new Long(N));

        for(int i = 1; i <= 8; i++) {
            if(i >= 2)
                list.add(new HashSet<>());

            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < i; j++)
                sb.append(N);

            list.get(i).add(Long.parseLong(sb.toString()));

            for(int j = 1; j < i; j++) {
                for(Long a : list.get(j)) {
                    for(Long b : list.get(i - j)) {
                        list.get(i).add(a + b);
                        list.get(i).add(a - b);
                        list.get(i).add(a * b);
                        if(b != 0)
                            list.get(i).add(a / b);
                    }
                }
            }

            if(list.get(i).contains((long)number))
                return i;
        }

        return answer;
    }
}