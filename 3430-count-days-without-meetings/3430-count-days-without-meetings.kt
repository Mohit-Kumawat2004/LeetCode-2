class Solution {
    fun countDays(days: Int, meetings: Array<IntArray>): Int {
        meetings.sortBy { it[0] }
        var answer = 0
        var prevEnd = 0
        for (meeting in meetings) {
            if (meeting[0] > prevEnd) {
                answer += meeting[0] - prevEnd - 1
                prevEnd = meeting[1]
            } else {
                prevEnd = maxOf(prevEnd, meeting[1])
            }
        }
        if (prevEnd < days) {
            answer += days - prevEnd
        }
        return answer
    }
}