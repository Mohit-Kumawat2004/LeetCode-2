impl Solution {
    pub fn max_frequency(nums: Vec<i32>, k: i32, num_operations: i32) -> i32 {
        let mut nums = nums;
        nums.sort();
        let n = nums.len();

        let mut left = 0usize;
        let mut right = 0usize;
        let mut sum_count = 0i32;
        let mut result = 0i32;
        let mut left2 = 0usize;
        let mut sum_count2 = 0i32;
        let mut count = 0i32;
        let mut prev: Option<i32> = None;

        for &num in nums.iter() {
            if prev == Some(num) {
                count += 1;
            } else {
                prev = Some(num);
                count = 1;
            }

            while nums[left] < num - k {
                sum_count -= 1;
                left += 1;
            }

            while right < n && nums[right] <= num + k {
                sum_count += 1;
                right += 1;
            }

            result = result.max(count + (sum_count - count).min(num_operations));

            sum_count2 += 1;
            while nums[left2] < num - 2 * k {
                sum_count2 -= 1;
                left2 += 1;
            }

            result = result.max(sum_count2.min(num_operations));
        }

        result
    }
}