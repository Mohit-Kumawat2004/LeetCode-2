function maximumLength(nums) {
    let count_even = 0, count_odd = 0;
    for (let num of nums) {
        if (num % 2 === 0) count_even++;
        else count_odd++;
    }

    let even_dp = 0, odd_dp = 0;
    for (let num of nums) {
        if (num % 2 === 0)
            even_dp = Math.max(even_dp, odd_dp + 1);
        else
            odd_dp = Math.max(odd_dp, even_dp + 1);
    }

    return Math.max(count_even, count_odd, even_dp, odd_dp);
}