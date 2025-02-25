var numOfSubarrays = function(arr) {
    const mod = 1000000007; // Large prime number for modulo operation to prevent overflow
    let sum = 0; // Cumulative sum tracker
    let odd = 0, even = 0; // Counters for odd and even prefix sums
    let ans = 0; // Stores the total number of subarrays with an odd sum

    // Iterate through each element of the array
    for (let num of arr) {
        sum += num; // Add current element to cumulative sum

        if (sum % 2 === 1) { // If cumulative sum is odd
            odd++; // Increment odd count
            ans += even + 1; // Previous even sums + current subarray itself contributes to odd count
        } else { // If cumulative sum is even
            even++; // Increment even count
            ans += odd; // Any previous odd prefix sum can form a new odd subarray
        }
    }

    return ans % mod; // Return answer within modulo constraint
};