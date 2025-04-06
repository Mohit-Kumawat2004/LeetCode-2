func largestDivisibleSubset(nums []int) []int {
    sort.Ints(nums)
    n := len(nums)
    groupSize := make([]int, n)
    prevElement := make([]int, n)
    maxIndex := 0

    for i := 0; i < n; i++ {
        groupSize[i] = 1
        prevElement[i] = -1
        for j := 0; j < i; j++ {
            if nums[i]%nums[j] == 0 && groupSize[j]+1 > groupSize[i] {
                groupSize[i] = groupSize[j] + 1
                prevElement[i] = j
            }
        }
        if groupSize[i] > groupSize[maxIndex] {
            maxIndex = i
        }
    }

    var result []int
    for i := maxIndex; i != -1; i = prevElement[i] {
        result = append([]int{nums[i]}, result...)
    }
    return result
}