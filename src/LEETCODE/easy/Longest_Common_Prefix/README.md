# 문제 링크
https://leetcode.com/problems/longest-common-prefix/description/?envType=featured-list&envId=top-interview-questions

## 설계
1. strs 배열을 sort 한다. 그럼 알파벳 순으로 정렬된다.
   * 정렬을 한 이유는 알파벳 순으로 정렬되어있기 때문에 첫번째 문자열과 마지막 문자열만 비교하면 된다.
2. 첫번째 문자열과 마지막 문자열의 character를 차례대로 일치하는지 검사한다.

### 시간 복잡도
1. strs 배열을 sort 하는데 O(Nlog(N))이 소요된다. 이유는 quicksort, mergesort, heapsort와 같은 sorting algorithm들은 평균적으로 O(Nlog(N))이 소요되기 때문이다.
2. 첫번째 문자열과 마지막 문자열의 character를 차례대로 일치하는지 검사하는데 O(N)이 소요된다. 이유는 문자열의 길이만큼 for문을 돌기 때문이다. 

그러므로 O(Nlog(N)) + O(N) = O(Nlog(N))이다.

### 공간 복잡도

## 고생한 점
