package PROGRAMMERS

import java.util.*

class JadenCase_문자열_만들기 {
    fun solution(s: String): String {
        return s.lowercase().split(" ").joinToString(" ") {
            it.replaceFirstChar {
                if (it.isLowerCase()) it.titlecase(
                    Locale.getDefault()
                ) else it.toString()
            }
        }
    }
}