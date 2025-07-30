class Solution {
public:
    int longestSubarray(vector<int>& nums) {
        int maxi = *max_element(nums.begin(), nums.end());
        int i = 0, ans = 0, res = 0, n = nums.size();
        while(i < n) {
            while(i < n && nums[i] == maxi) {
                ans++;
                i++;
            }
            res = max(ans, res);
            ans = 0;
            i++;
        }
        return res;
    }
};