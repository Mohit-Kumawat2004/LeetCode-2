class Solution {
    
    fun lenLongestFibSubseq(arr: IntArray): Int {
        val numbers = HashSet<Int>(arr.size.takeHighestOneBit() shl 2)
        for (a in arr) {
            numbers.add(a)
        }

        var max = 0
        for (i in 0 until arr.size - 2) {
            val ai = arr[i]
            for (j in i + 1 until arr.size - 1) {
                val len = dfs(numbers, ai, arr[j])
                if (len != 0) max = Math.max(max, len + 2)
            }
        }
        return max
    }

    private fun dfs(numbers: HashSet<Int>, a: Int, b: Int): Int = when {
        numbers.contains(a + b) -> 1 + dfs(numbers, b, a + b)
        else -> 0
    }
}