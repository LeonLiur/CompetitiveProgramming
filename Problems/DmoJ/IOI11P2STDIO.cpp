#include <bits/stdc++.h>

using namespace std;

#define endl "\n"
#define mp make_pair
#define pb push_back
#define boost() cin.tie(0), cin.sync_with_stdio(0)
typedef long long ll;
typedef vector<int> vi;
typedef pair<int, int> pii;
typedef pair<ll, ll> pll;


const int MN = 2e5 + 5;
ll n, k, a, b, c, sz[MN];
ll ans = 0x3f3f3f3f;
bool visited[MN];
vector<pii> adj[MN];
map<ll, ll> mapping;

int size_of(int cur, int par){
    sz[cur] = 1;
    for(auto nxt_node : adj[cur]){
        int nxt = nxt_node.first;
        if(visited[nxt] || nxt == par)  continue;
        sz[cur] += size_of(nxt, cur);
    }
    return sz[cur];
}

int get_centroid(int cur, int par, int threshold){
    for(auto nxt_node : adj[cur]){
        int nxt = nxt_node.first;
        if(visited[nxt] || nxt == par)  continue;
        if(sz[nxt] > threshold)   return get_centroid(nxt, cur, threshold);
    }

    return cur;
}

void global_dfs(int cur, int par, int len, int cnt){
    if(mapping.count(k - len))   ans = min(ans, mapping[k - len] + cnt);

    for(auto nxt_node : adj[cur]){
        int nxt = nxt_node.first;
        if(!visited[nxt] && nxt != par){
            global_dfs(nxt, cur, len + nxt_node.second, cnt + 1);
        }
    }
    
}

void local_dfs(int cur, int par, int len, ll cnt){
    mapping[len] = mapping.count(len)? min(mapping[len], cnt) : cnt;
    
    for(auto nxt_node : adj[cur]){
        int nxt = nxt_node.first;
        if(!visited[nxt] && nxt != par){
            local_dfs(nxt, cur, len + nxt_node.second, cnt + 1);
        }
    }
}

void solve_dfs(int cur){
    cur = get_centroid(cur, 0, size_of(cur, 0) >> 1);

    mapping.clear();
    mapping[0] = 0;
    for(auto nxt_node : adj[cur]){
        if(visited[nxt_node.first]) continue;

        global_dfs(nxt_node.first, cur, nxt_node.second, 1);
        local_dfs(nxt_node.first, cur, nxt_node.second, 1);
    }

    visited[cur] = true;

    for(auto nxt_node : adj[cur]){
        if(visited[nxt_node.first]) continue;
        solve_dfs(nxt_node.first);
    }
}

int best_path(int N, int K, int H[][2], int L[]){
    n = N, k = K;
    for(int i = 0,a, b, c; i < n - 1; i++){
        a = H[i][0];
        b = H[i][1];
        c = L[i];

        a++;
        b++;
        adj[a].pb(mp(b, c));
        adj[b].pb(mp(a, c));
    }


    solve_dfs(1);
    return ans > n? -1 : ans;
}