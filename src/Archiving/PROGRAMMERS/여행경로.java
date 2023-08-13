package Archiving.PROGRAMMERS;

import java.util.*;

public class 여행경로 {
    boolean[] visited;
    ArrayList<String> allRoute;
    int n;

    public String[] solution(String[][] tickets) {
        String[] answer = {};

        n = tickets.length;
        visited = new boolean[n];
        allRoute = new ArrayList<>();

        dfs("ICN", "ICN", tickets, 0);

        Collections.sort(allRoute);
        answer = allRoute.get(0).split(" ");

        return answer;
    }

    private void dfs(String start, String route, String[][] tickets, int depth) {
        if(depth == n) {
            allRoute.add(route);
            return;
        }

        for(int i = 0; i < n; i++) {
            if(start.equals(tickets[i][0]) && !visited[i]) {
                visited[i] = true;
                dfs(tickets[i][1], route + " " + tickets[i][1], tickets, depth + 1);
                visited[i] = false;
            }
        }
    }
}

/*

[["ICN", "JFK"], ["HND", "IAD"], ["JFK", "HND"]]
["ICN", "JFK", "HND", "IAD"]

[["ICN", "SFO"], ["ICN", "ATL"], ["SFO", "ATL"], ["ATL", "ICN"], ["ATL","SFO"]]
["ICN", "ATL", "ICN", "SFO", "ATL", "SFO"]

 */

