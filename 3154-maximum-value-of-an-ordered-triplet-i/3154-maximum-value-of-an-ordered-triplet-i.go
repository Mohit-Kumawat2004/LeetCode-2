func maximumTripletValue(nums []int) int64 {
	n := len(nums)
	var res int64 = 0
	for i := 0; i < n; i++ {
		for j := i + 1; j < n; j++ {
			for k := j + 1; k < n; k++ {
				res = max(res, int64(nums[i]-nums[j])*int64(nums[k]))
			}
		}
	}
	return res
}