package Archiving.PROGRAMMERS

class 최댓값과_최솟값 {
    fun solution(s: String): String {
        return s.split(" ").map{ it.toInt() }.let{ "${it.minOrNull()} ${it.maxOrNull()}" }
    }
}