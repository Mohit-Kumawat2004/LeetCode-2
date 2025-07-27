class Solution {
    public int countHillValley(int[] nums) {
        int count=0;
        boolean g=false;
        boolean s=false;

        for(int i=1;i<nums.length;i++){
            if(s&&nums[i]<nums[i-1]){
               count++;
               g=true;
               s=false;
            }else if(g && nums[i]>nums[i-1]){
                count++;
                s=true;
                g=false;
            }else if(nums[i]<nums[i-1]){
                g=true;
            }else if(nums[i]>nums[i-1]){
                s=true;
            }
        }return count;
    }
}