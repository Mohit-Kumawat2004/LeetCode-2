class Solution {
public:
    int maxSum(vector<int>& arr) {
        int mx = -101, sum = 0;
        unordered_set<int> st;
        for (int x : arr) {
            if (x > 0 && !st.count(x)) {
                sum += x;
                st.insert(x);
            }
            mx = max(mx, x);
        }
        return sum > 0 ? sum : mx;
    }
};