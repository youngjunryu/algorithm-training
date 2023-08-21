# 문제번호. 문제제목
https://leetcode.com/problems/sqrtx/description/?envType=featured-list&envId=top-interview-questions

## 설계
우선 x가 0인지 1인지 확인하는 조건문을 넣어주고, 맞다면 x를 반환한다.

검색 범위를 1부터 x까지 셋업하고, 이분 탐색을 시작한다.

left + (right - left) / 2 라고 선언한 이유는 계산할 때 integer 오버플로우가 발생할 수 있기 때문이다.

이분 탐색을 진행하며 mid * mid 가 x보다 크다면 right를 mid - 1로 설정하고, mid * mid 가 x보다 작다면 left를 mid + 1로 설정한다.

left가 right보다 커질 때까지 반복하고, right 값을 반환한다.

### 시간 복잡도
O(logN)
이진 탐색이 각 단계마다 1/2씩 줄어들기 때문에 O(logN)이다.

### 공간 복잡도
O(1)
계산하는동안 검색 범위나 중간 값을 저장하기 위한 변수만 사용하기 때문에 O(1)이다.

## 고생한 점
