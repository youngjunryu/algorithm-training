package Archiving.LEETCODE

class Two_Sum2 {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val result = IntArray(2)

        for (i in 0..nums.size - 1) {
            for (j in i + 1..nums.size - 1) {
                val sum = nums[i] + nums[j]
                if (sum == target) {
                    result[0] = i
                    result[1] = i
                    break
                }
            }
        }

        return result
    }
}

fun main() {
    Two_Sum2().twoSum(intArrayOf(2, 7, 11 , 15), 9)
}
