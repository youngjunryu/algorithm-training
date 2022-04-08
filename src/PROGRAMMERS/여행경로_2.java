package PROGRAMMERS;

import java.util.ArrayList;
import java.util.List;

public class 여행경로_2 {
    boolean[] visited;
    List<String> result;

    public String[] solution(String[][] tickets) {
        String[] answer = {};
        visited = new boolean[tickets.length];
        result = new ArrayList<>();

        dfs("ICN", "ICN", tickets, 0);

        return result.stream()
                .sorted()
                .findFirst()
                .get()
                .split(" ");
    }

    private void dfs(String start, String route, String[][] tickets, int depth) {

        if (depth == tickets.length) {
            result.add(route);
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            if (tickets[i][0].equals(start) && !visited[i]) {
                visited[i] = true;
                dfs(tickets[i][1], route + " " + tickets[i][1], tickets, depth + 1);
                visited[i] = false;
            }
        }
    }
}
