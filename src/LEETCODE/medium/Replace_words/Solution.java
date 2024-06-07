package LeetCode.medium.Replace_words;

import java.util.List;
import java.util.StringTokenizer;

class Solution {

  public String replaceWords(List<String> dictionary, String sentence) {
    dictionary.sort((a, b) -> a.length() - b.length());
    StringBuilder sb = new StringBuilder();
    StringTokenizer st = new StringTokenizer(sentence);

    while (st.hasMoreTokens()) {
      String str = st.nextToken();
      boolean flag = false;
      for (String dick : dictionary) {
        if (str.startsWith(dick)) {
          sb.append(dick).append(" ");
          flag = true;
          break;
        }
      }

      if (!flag) {
        sb.append(str).append(" ");
      }
    }

    sb.deleteCharAt(sb.length() - 1);

    return sb.toString();
  }
}
