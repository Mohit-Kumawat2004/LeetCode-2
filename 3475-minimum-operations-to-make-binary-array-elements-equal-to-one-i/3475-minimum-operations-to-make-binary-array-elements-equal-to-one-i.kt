class Solution {
    fun minOperations(nums: IntArray): Int {
        var count = 0
        val n = nums.size

        for (i in 0 until n - 2) {
            if (nums[i] == 0) {
                nums[i] = nums[i] xor 1
                nums[i + 1] = nums[i + 1] xor 1
                nums[i + 2] = nums[i + 2] xor 1
                count++
            }
        }

        return if (nums[n - 2] == 1 && nums[n - 1] == 1) count else -1
    }
}