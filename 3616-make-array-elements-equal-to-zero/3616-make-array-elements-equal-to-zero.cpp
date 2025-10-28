class Solution {
public:
    int countValidSelections(vector<int>& nums) {
        int left = 0;
        int total = 0;
        int count=0;
        for(auto i:nums){
            total+=i;
        }
        for(int i=0;i<nums.size();i++){
            int right = total - left - nums[i];
            if(nums[i]==0){
                 if (left == right) count += 2;
                 else if (abs(left - right) == 1) count += 1;
            }
            left+=nums[i];
        }
        return count;
    }
};