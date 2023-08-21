# 문제번호. 문제제목
https://leetcode.com/problems/single-number/description/?envType=featured-list&envId=top-interview-questions

## 설계
해설을 보니 아래와 같은 XOR 연산을 이용한 방법이 있었다.
같은 수가 나오면 0, 다른 수가 나오면 1이 나오는 XOR 연산을 이용하면, 결국에는 한 번만 나오는 수만 남게 된다.

### 시간 복잡도
O(N)

### 공간 복잡도
O(1)

## 코드
```java
class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;
        for(int i = 0; i < nums.length; i++) {
            result = result^nums[i];
        }
        return result;
    }
}
```

## 고생한 점
