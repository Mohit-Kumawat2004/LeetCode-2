function maxDistinctElements(nums: number[], k: number): number {
    if (nums.length === 0) return 0;
    nums.sort((a, b) => a - b);
    let count = 0;
    let prev = -2147483648 >> 1;
    for (let a of nums) {
        let low = a - k;
        let high = a + k;
        let x = prev + 1;
        if (x < low) x = low;
        if (x <= high) {
            count++;
            prev = x;
        }
    }
    return count;
}