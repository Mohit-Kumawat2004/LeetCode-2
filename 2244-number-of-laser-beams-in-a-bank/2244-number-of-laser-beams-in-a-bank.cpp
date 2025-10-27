class Solution {
public:
    int numberOfBeams(vector<string>& bank) {
        int ans = 0, prev = 0;
        for (auto& str : bank) {
            int curr = 0;
            for (char ch : str) {
                if (ch == '1') curr++;
            }
            ans += curr * prev;
            if (curr > 0) prev = curr;
        }
        return ans;
    }
};