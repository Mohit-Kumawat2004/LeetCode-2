impl Solution {
    pub fn min_number_operations(target: Vec<i32>) -> i32 {
        let n=target.len();
        let mut ans=target[0];
        for i in 1..n{
            ans+=(target[i]-target[i-1]).max(0);
        }
        ans
    }
}