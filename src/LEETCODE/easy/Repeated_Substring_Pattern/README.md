# 문제번호. 문제제목
https://leetcode.com/problems/repeated-substring-pattern/description/

## 설계
내가 푼 방식은 시간 복잡도가 O(n^2)가 나오지만, 해설에 시간 복잡도가 O(n)인 방식이 있어서 정리해보려한다.

1. s의 두 복사본을 연결하고 첫 번째 문자와 마지막 문자를 제거한다.
2. s가 새로운 만든 문자열 내에 포함된다면, s는 반복되는 문자열의 패턴을 가지고 있다.

코드는 아래와 같다.

## 코드
````java
public class Solution {
    public boolean repeatedSubstringPattern(String s) {
        String doubled = s + s;
        String sub = doubled.substring(1, doubled.length() - 1);
        return sub.contains(s);
    }
}
````

### 시간 복잡도

### 공간 복잡도

## 고생한 점
