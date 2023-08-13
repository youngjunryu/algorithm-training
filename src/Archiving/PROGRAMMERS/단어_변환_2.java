package Archiving.PROGRAMMERS;

public class 단어_변환_2 {
    boolean[] visited;
    int answer;

    public int solution(String begin, String target, String[] words) {
        answer = words.length;
        visited = new boolean[words.length];

        dfs(begin, target, words, 0);

        if(answer == words.length) return 0;
        return answer;
    }

    public void dfs(String cur, String target, String[] words, int depth) {
        if (depth >= answer) {

            return;
        }

        if(cur.equals(target)) {
            answer = depth;
            return;
        }

        for(int i = 0; i < words.length; i++) {
            if(!visited[i] && checkDiffWord(cur, words[i])) {
                visited[i] = true;
                dfs(words[i], target, words, depth + 1);
                visited[i] = false;
            }
        }
    }

    public boolean checkDiffWord(String str1, String str2) {

        int match = 0;

        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) == str2.charAt(i)) {
                match++;
            }
        }

        return match == str1.length() - 1;
    }
}
