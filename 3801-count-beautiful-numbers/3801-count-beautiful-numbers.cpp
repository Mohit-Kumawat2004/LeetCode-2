class Solution {
public:
    struct State {
        int pos, tight, started, sum, prod;
        bool operator<(const State &other) const {
            if (pos != other.pos) return pos < other.pos;
            if (tight != other.tight) return tight < other.tight;
            if (started != other.started) return started < other.started;
            if (sum != other.sum) return sum < other.sum;
            return prod < other.prod;
        }
    };
    
    map<State, long long> memo;
    
    long long dfs(int pos, int tight, int started, int sum, int prod, const vector<int>& digits) {
        if (pos == digits.size()) {
            if (!started) return 0;
            return (prod % sum == 0 ? 1LL : 0LL);
        }
        State st{pos, tight, started, sum, prod};
        if(memo.find(st) != memo.end()) return memo[st];
        long long res = 0;
        int limit = tight ? digits[pos] : 9;
        for (int d = 0; d <= limit; d++) {
            int ntight = (tight && d == limit) ? 1 : 0;
            if (!started && d == 0) {
                res += dfs(pos + 1, ntight, 0, 0, 1, digits);
            } else if (!started && d != 0) {
                res += dfs(pos + 1, ntight, 1, d, d, digits);
            } else {
                res += dfs(pos + 1, ntight, 1, sum + d, prod * d, digits);
            }
        }
        memo[st] = res;
        return res;
    }
    
    long long countBeautiful(long long x) {
        if(x < 1) return 0;
        vector<int> digits;
        while(x) {
            digits.push_back(x % 10);
            x /= 10;
        }
        reverse(digits.begin(), digits.end());
        memo.clear();
        return dfs(0, 1, 0, 0, 1, digits);
    }
    
    int beautifulNumbers(int l, int r) {
        vector<int> kelbravion = {l, r};
        return countBeautiful(r) - countBeautiful(l - 1);
    }
};