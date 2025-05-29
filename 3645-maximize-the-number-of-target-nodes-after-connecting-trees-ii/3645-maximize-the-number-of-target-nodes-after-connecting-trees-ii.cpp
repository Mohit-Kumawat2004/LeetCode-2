class Solution {
    vector<int> bfs(int node,vector<vector<int>>& adj){
        int n = adj.size();
        vector<int> dist(n,INT_MAX);
        dist[node] = 0;
        queue<int> q;
        q.push(node);
        while(!q.empty()){
            auto node = q.front();
            int cost = dist[node];
            q.pop();
            if(cost > dist[node]) continue;
            for(auto& bro:adj[node]){
                int curr = 1+cost;
                if(curr < dist[bro]){
                    dist[bro] = curr;
                    q.push(bro);
                }
            }
        }
        return dist;
    }
public:
    vector<int> maxTargetNodes(vector<vector<int>>& edges1, vector<vector<int>>& edges2) {
        int n = edges1.size();
        int m = edges2.size();
        vector<vector<int>> adj(n+1);
        vector<vector<int>> bdj(m+1);

        for(auto& edge:edges1){
            adj[edge[0]].push_back(edge[1]);
            adj[edge[1]].push_back(edge[0]);
        }
        for(auto& edge:edges2){
            bdj[edge[0]].push_back(edge[1]);
            bdj[edge[1]].push_back(edge[0]);
        }

        vector<int> first = bfs(0,adj);
        vector<int> second = bfs(0,bdj);
        int c1 = 0,c2 = 0;
        for(int i=0;i<=n;i++){
            if(first[i] % 2 == 0) c1++;
        }

        for(int i=0;i<=m;i++){
            if(second[i] % 2 == 1) c2++;
        }

        int val = max(c2,m+1-c2);

        vector<int> res(n+1,0);
        for(int i=0;i<=n;i++){
            if(first[i] % 2 == 0){
                res[i] = c1+val;
            }
            else{
                res[i] = n+1-c1+val;
            }
        }

        return res;
        
    }
};