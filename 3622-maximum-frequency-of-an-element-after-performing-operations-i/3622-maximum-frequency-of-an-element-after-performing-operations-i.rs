impl Solution {
    pub fn max_frequency(nums: Vec<i32>, k: i32, num_operations: i32) -> i32 {
        let mut max_val = *nums.iter().max().unwrap() + k + 2;
        let mut count = vec![0; max_val as usize];

        for &v in &nums {
            count[v as usize] += 1;
        }

        for i in 1..max_val as usize {
            count[i] += count[i - 1];
        }

        let mut res = 0;
        for i in 0..max_val as usize {
            let left = if i as i32 - k < 0 { 0 } else { (i as i32 - k) as usize };
            let right = ((i as i32 + k).min(max_val - 1)) as usize;

            let mut total = count[right];
            if left > 0 {
                total -= count[left - 1];
            }

            let mut freq = count[i];
            if i > 0 {
                freq -= count[i - 1];
            }

            let extra = (num_operations as usize).min(total - freq);
            res = res.max(freq + extra);
        }

        res as i32
    }
}
