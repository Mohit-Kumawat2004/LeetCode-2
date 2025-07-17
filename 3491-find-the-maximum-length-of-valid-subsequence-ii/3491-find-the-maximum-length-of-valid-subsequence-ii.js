/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var maximumLength = function(nums, k) {
    
    let maxLength = 0;
    // Create a 2D array of size k x k initialize with 0
    const dp = Array.from({ length: k }, () => Array(k).fill(0));

    for(let num of nums){
        let rem=num%k;

        for(let i=0; i<k; i++){
        
            let target=(i-rem+k)%k
            dp[rem][target]=dp[target][rem]+1;

            maxLength = Math.max(maxLength, dp[rem][target]);
        }
    }
    return maxLength;
};