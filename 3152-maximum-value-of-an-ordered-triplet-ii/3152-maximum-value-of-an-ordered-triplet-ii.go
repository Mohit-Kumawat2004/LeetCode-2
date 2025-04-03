
func maximumTripletValue(nums []int) int64 {
	n := len(nums)
	diff := make([]int64, n)
	var ma int64 = int64(nums[0])

	for i := 1; i < n; i++ {
		if int64(nums[i]) < ma {
			diff[i] = ma - int64(nums[i])
		} else {
			ma = int64(nums[i])
		}
	}

	pre := make([]int64, n)
	pre[n-1] = int64(nums[n-1])

	for i := n - 2; i >= 0; i-- {
		pre[i] = max(pre[i+1], int64(nums[i+1]))
	}

	var ans int64 = 0
	for i := 0; i < n-1; i++ {
		ans = max(ans, diff[i]*pre[i])
	}

	return ans
}