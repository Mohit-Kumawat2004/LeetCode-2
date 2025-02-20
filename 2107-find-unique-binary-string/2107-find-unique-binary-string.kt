class Solution {
    fun findDifferentBinaryString(nums: Array<String>): String {
    val sb = StringBuilder()
    nums.forEachIndexed { index, s ->
        val c = if (s[index] == '0') '1' else '0'
        sb.append(c)
    }

    return sb.toString()
}
}