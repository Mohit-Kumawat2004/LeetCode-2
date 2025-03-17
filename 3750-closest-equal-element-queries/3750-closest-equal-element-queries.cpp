class Solution {
public:
    vector<int> solveQueries(vector<int>& nums, vector<int>& queries) {
        int n = nums.size();
        unordered_map<int, vector<int>> mp;
        for (int i = 0; i < n; i++) {
            mp[nums[i]].push_back(i);
        }
        for (auto &p : mp) {
            sort(p.second.begin(), p.second.end());
        }
        vector<int> ans;
        for (int q : queries) {
            int v = nums[q];
            auto &vec = mp[v];
            if (vec.size() < 2) {
                ans.push_back(-1);
            } else {
                int pos = lower_bound(vec.begin(), vec.end(), q) - vec.begin();
                int left = (pos - 1 + vec.size()) % vec.size();
                int right = (pos + 1) % vec.size();
                int d1 = abs(q - vec[left]);
                d1 = min(d1, n - d1);
                int d2 = abs(q - vec[right]);
                d2 = min(d2, n - d2);
                ans.push_back(min(d1, d2));
            }
        }
        return ans;
    }
};