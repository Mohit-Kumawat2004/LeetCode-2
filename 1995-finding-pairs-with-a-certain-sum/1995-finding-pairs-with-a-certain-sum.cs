public class FindSumPairs {
    private int[] v1, v2;
    Dictionary<int, int> freq = new();
    public FindSumPairs(int[] nums1, int[] nums2) {
        v1 = nums1;
        v2 = nums2;
        foreach(int val in nums2) {
            freq[val] = freq.GetValueOrDefault(val, 0) + 1;
        }
    }
    
    public void Add(int index, int val) {
        int oldValue = v2[index];
        v2[index] += val;
        freq[oldValue]--;
        if (freq[oldValue] == 0) {
            freq.Remove(oldValue);
        }
        freq[v2[index]] = freq.GetValueOrDefault(v2[index], 0) + 1;
    }
    
    public int Count(int tot) {
        int result = 0;
        foreach(int val in v1) {
            result += freq.GetValueOrDefault(tot - val, 0);
        }
        return result;
    }
}

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs obj = new FindSumPairs(nums1, nums2);
 * obj.Add(index,val);
 * int param_2 = obj.Count(tot);
 */