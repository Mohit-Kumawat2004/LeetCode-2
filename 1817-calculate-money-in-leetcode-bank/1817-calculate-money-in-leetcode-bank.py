class Solution:
    def totalMoney(self, n: int) -> int:
        weeks = n // 7
        if not weeks:
            return n * (n + 1) // 2
        else:
            i = weeks + 1
            x = sum(i + j for j in range(n % 7))
            return weeks * 28 + ((weeks - 1) * weeks // 2) * 7 + x