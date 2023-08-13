package Archiving.LEETCODE

class Logest_Palindromic_Substring {
    fun longestPalindrome(s: String): String {
        var dp = Array(1000) { Array(1000) { false } }
        var answer = ""

        for (i in 0..s.length - 1) {
            dp[i][i] = true

            if (answer.isBlank()) {
                answer = s.substring(i, i + 1)
            }

            if (i == s.length - 1) {
                break
            }

            if (s[i] === s[i + 1]) {
                dp[i][i + 1] = true
                if (answer.length < 2) {
                    answer = s.substring(i, i + 2)
                }
            }
        }

        for (i in 2..s.length - 1) {
            for (j in 0..s.length - i - 1) {
                if (s[j] == s[j + i] && dp[j + 1][j + i - 1]) {
                    dp[j][j + i] = true
                    if (answer.length < i + 1) {
                        answer = s.substring(j, j + i + 1)
                    }
                }
            }
        }

        print(answer)

        return answer
    }
}

fun main() {
    Logest_Palindromic_Substring().longestPalindrome("cbbd")
}