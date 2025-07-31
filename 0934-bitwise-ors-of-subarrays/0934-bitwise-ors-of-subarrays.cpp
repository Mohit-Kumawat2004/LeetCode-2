
class Solution {
    private:
    //Now let's talk about the correct approach for the problem
    //it is a new and awesome concept for dynamic programming which also tells how broad dynamic programming is
    //this is problem of rolling set (which is included in dynamic programming)
    //the same algorithm can be applied to multiple problems
public:
    int subarrayBitwiseORs(vector<int>& arr) {
        unordered_set<int>ans;
        unordered_set<int>prev;
        int n=arr.size();
        for(int i=0;i<n;i++)
        {
            unordered_set<int>next;
            next.insert(arr[i]);
            for(auto p:prev)
            {
                next.insert((arr[i] | p));
            }

            for(auto n:next)
            {
                ans.insert(n);
            }

            prev=next;
        }

        return ans.size();
    }
};