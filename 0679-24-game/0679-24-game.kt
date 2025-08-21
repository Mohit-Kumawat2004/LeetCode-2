class Solution {
    private fun check(p: DoubleArray): Boolean {
        val operations = arrayOf(
            { a: Double, b: Double -> a + b },
            { a: Double, b: Double -> a - b },
            { a: Double, b: Double -> a * b },
            { a: Double, b: Double -> a / b },
        )

        for (o1 in operations) {
            for (o2 in operations) {
                for (o3 in operations) {
                    if (
                        o3(o2(o1(p[0], p[1]), p[2]), p[3]) eq TARGET ||
                        o3(o1(p[0], p[1]), o2(p[2], p[3])) eq TARGET ||
                        o3(o2(p[0], o1(p[1], p[2])), p[3]) eq TARGET ||
                        o3(p[0], o2(o1(p[1], p[2]), p[3])) eq TARGET ||
                        o3(p[0], o2(p[1], o1(p[2], p[3]))) eq TARGET
                    ) return true
                }
            }
        }
        return false
    }

    fun judgePoint24(cards: IntArray): Boolean {
        val permutation = DoubleArray(cards.size)

        fun permutate(index: Int = 0): Boolean {
            if (index == permutation.size) return check(permutation)
            for (i in cards.indices) {
                if (cards[i] != -1) {
                    val value = cards[i]
                    permutation[index] = value.toDouble()
                    cards[i] = -1
                    if (permutate(index + 1)) return true
                    cards[i] = value
                }
            }
            return false
        }

        return permutate()
    }

    companion object {
        const val TARGET = 24.0
        const val EPS = 0.00000000001

        private infix fun Double.eq(other: Double) = abs(this - other) < EPS
    }
}