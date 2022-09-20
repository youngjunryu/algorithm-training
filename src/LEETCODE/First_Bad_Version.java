package LEETCODE;

// public class First_Bad_Version {
//   public int firstBadVersion(int n) {
//     if (n == 1) {
//       return 1;
//     }
//
//     int start = 1;
//     int end = n;
//
//     while (start < end) {
//       int mid = start + (end - start) / 2;
//       if (!isBadVersion(mid)) {
//         start = mid + 1;
//       } else {
//         end = mid;
//       }
//     }
//
//     return end;
//   }
// }
