package LEETCODE

class Longest_Substring_Without_Repeating_Characters2 {
    fun lengthOfLongestSubstring(s: String): Int {
        var max: Int = 0
        var sub: String = ""

        for (i in 0..s.length - 1) {
            if (sub.contains(s[i])) {
                val idx = sub.indexOf(s[i])
                sub = sub.substring(idx + 1) + s[i]
            } else {
                sub += s[i]
                max = Math.max(sub.length, max)
            }
            println(sub)
        }

        return max
    }
}

fun main() {
    Longest_Substring_Without_Repeating_Characters2().lengthOfLongestSubstring("abcabcbb")
}