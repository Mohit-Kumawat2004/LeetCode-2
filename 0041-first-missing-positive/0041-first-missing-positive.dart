class Solution {

int firstMissingPositive(List<int> nums) {
  int n = nums.length;  

  // Step 1: Ensure that all numbers are within the valid range [1, n]
  for (int i = 0; i < n; i++) {
    while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
      // Swap nums[i] with the number at its correct position (nums[i] - 1)
      int temp = nums[i];
      nums[i] = nums[temp - 1];
      nums[temp - 1] = temp;
    }
  }
    
  // Step 2: Find the first index where nums[i] != i + 1
  for (int i = 0; i < n; i++) {
    if (nums[i] != i + 1) {
      return i + 1;
    }
  }

  // If all numbers are in their correct places, the missing number is n + 1
  return n + 1;
}


}
