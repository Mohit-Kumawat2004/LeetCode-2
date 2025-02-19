const smallestNumber = (p) => {
    const a = [1, 2, 3, 4, 5, 6, 7, 8, 9]; // O(n)
    p = `I${p}I`; // O(n)
    for (let i = 0, j = -1; i < p.length - 1; ++i) {
        if (j == -1 && p[i + 1] == 'D') j = i;
        else if (j != -1 && p[i + 1] == 'I') {
            for (let k = i, t; j < k; ++j, --k) // reverse O(k - j)
                [a[j], a[k]] = [a[k], a[j]];
            j = -1;
        }
    }
    return a.slice(0, p.length - 1).join(''); // O(n)
};