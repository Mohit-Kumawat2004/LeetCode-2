const mod: number = 1000000007;

function goodSubtreeSum(vals: number[], par: number[]): number {
    let ans: number = 0;
    const adj: number[][] = Array.from({ length: par.length }, () => []);
    
    // Build adjacency list
    for (let i = 1; i < par.length; i++) {
        adj[i].push(par[i]);
        adj[par[i]].push(i);
    }

    // Cache digit arrays for unique values
    const digitCache: Map<number, { mask: number, valid: boolean }> = new Map();
    function getDigitInfo(val: number): { mask: number, valid: boolean } {
        if (digitCache.has(val)) return digitCache.get(val)!;
        const dig: number[] = Array(10).fill(0);
        let temp = val;
        while (temp) {
            dig[temp % 10]++;
            temp = Math.floor(temp / 10);
        }
        const valid = dig.every(count => count <= 1);
        let mask = 0;
        for (let j = 0; j < 10; j++) {
            if (dig[j]) mask |= (1 << j);
        }
        const info = { mask, valid };
        digitCache.set(val, info);
        return info;
    }

    function dfs(node: number, parent: number): number[] {
        const subtree: number[] = [node];
        const { mask: nodeMask, valid: nodeValid } = getDigitInfo(vals[node]);

        // Process children
        for (const ele of adj[node]) {
            if (ele !== parent) {
                const sub = dfs(ele, node);
                subtree.push(...sub);
            }
        }

        // Initialize DP array
        const dp: number[] = Array(1024).fill(0);
        dp[0] = 0; // Base case: empty subtree sum

        // Process each node in subtree
        for (const ele of subtree) {
            const { mask, valid } = getDigitInfo(vals[ele]);
            if (!valid) continue; // Skip nodes with duplicate digits

            // Update DP for all masks
            for (let i = 1023; i >= 0; i--) {
                if (dp[i] === 0 && i !== 0) continue; // Skip uninitialized states
                if (!(i & mask)) { // Check if masks are compatible
                    dp[i | mask] = Math.max(dp[i | mask], dp[i] + vals[ele]);
                }
            }
        }

        // Update global answer with max DP value
        let maxSum = 0;
        for (let i = 0; i < 1024; i++) {
            if (dp[i] > 0) maxSum = Math.max(maxSum, dp[i]);
        }
        ans = (ans + maxSum) % mod;

        return subtree;
    }
    
    dfs(0, -1);
    return ans;
}