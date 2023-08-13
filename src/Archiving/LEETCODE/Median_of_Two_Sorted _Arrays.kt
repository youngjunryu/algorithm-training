package Archiving.LEETCODE

class `Median_of_Two_Sorted _Arrays` {
    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        val m = nums1.size
        val n = nums2.size

        if (m > n) {
            return findMedianSortedArrays(nums2, nums1)
        }

        var left = 0
        var right = m

        while (left <= right) {
            val partitionX = (left + right) / 2
            val partitionY = (m + n + 1) / 2 - partitionX
            val maxLeftX = if (partitionX == 0) Int.MIN_VALUE else nums1[partitionX - 1]
            val minRightX = if (partitionX == m) Int.MAX_VALUE else nums1[partitionX]
            val maxLeftY = if (partitionY == 0) Int.MIN_VALUE else nums2[partitionY - 1]
            val minRightY = if (partitionY == n) Int.MAX_VALUE else nums2[partitionY]

            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                return if ((m + n) % 2 == 0) {
                    (maxOf(maxLeftX, maxLeftY) + minOf(minRightX, minRightY)) / 2.0
                } else {
                    maxOf(maxLeftX, maxLeftY).toDouble()
                }
            } else if (maxLeftX > minRightY) {
                right = partitionX - 1
            } else {
                left = partitionX + 1
            }
        }
        return 0.0
    }
}

fun main() {
    val findMedianSortedArrays =
        `Median_of_Two_Sorted _Arrays`().findMedianSortedArrays(intArrayOf(1, 3), intArrayOf(2))
    println(findMedianSortedArrays)
}
