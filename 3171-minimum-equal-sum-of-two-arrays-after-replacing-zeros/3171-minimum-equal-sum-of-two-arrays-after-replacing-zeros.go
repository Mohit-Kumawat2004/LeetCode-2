func minSum(nums1 []int, nums2 []int) int64 {
    var nums1Sum, nums2Sum int64
    var nums1Zeroes, nums2Zeroes int

    for _, x := range nums1 {
        if x == 0 {
            nums1Zeroes++
            nums1Sum += 1 // replace 0 with 1
        } else {
            nums1Sum += int64(x)
        }
    }

    for _, x := range nums2 {
        if x == 0 {
            nums2Zeroes++
            nums2Sum += 1 // replace 0 with 1
        } else {
            nums2Sum += int64(x)
        }
    }

    if (nums1Zeroes == 0 && nums2Sum > nums1Sum) || (nums2Zeroes == 0 && nums1Sum > nums2Sum) {
        return -1
    }

    if nums1Sum > nums2Sum {
        return nums1Sum
    }
    return nums2Sum
}
