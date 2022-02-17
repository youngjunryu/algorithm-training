package PROGRAMMERS;

public class 단어_변환 {
    boolean[] visited;
    int answer;

    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];
        answer = words.length;

        dfs(begin, target, words, 0);

        if(answer == words.length) return 0;
        else return answer;
    }

    private void dfs(String current, String target, String[] words, int depth) {
        if(answer <= depth)
            return;

        if(current.equals(target)) {
            answer = depth;
            return;
        }

        for(int i = 0; i < words.length; i++) {
            if(!visited[i] && checkWord(current, words[i])) {
                visited[i] = true;
                dfs(words[i], target, words, depth + 1);
                visited[i] = false;
            }
        }
    }

    private boolean checkWord(String a, String b){
        int cnt = 0;

        for(int i = 0; i < a.length(); i++) {
            if(a.charAt(i) != b.charAt(i))
                cnt++;
        }

        if(cnt == 1) return true;
        else return false;
    }
}
