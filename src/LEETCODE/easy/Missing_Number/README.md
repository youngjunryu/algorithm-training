# 문제
https://leetcode.com/problems/missing-number/description/?envType=featured-list&envId=top-interview-questions%3FenvType%3Dfeatured-list&envId=top-interview-questions

## 설계
XOR 연산 아이디어를 가지고 문제를 풀어야 한다.

a^b^b = a, 같은 숫자의 XOR 연산은 그 숫자들을 제거하고 오리지날 숫자를 도출해낼 수 있다.

1. i = 0부터 배열의 길이만큼 반복
2. a^b^b 에서 첫 번째 b가 i, 두 번째 b가 배열에 속한 값.
3. 마지막에는 결국 배열에 없는 값이 나오게 된다.

### 시간 복잡도
O(1)

### 공간 복잡도
O(n)

## 고생한 점
