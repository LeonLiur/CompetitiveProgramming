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

const int maxi = 2147483647;
const int mini = -2147483648;

const int MN = 1e5 + 5;
int n, sz[MN];
bool done[MN];
ll ans;
vector<pii> adj[MN];
unordered_map<int, int> mapping;
char c;

// gets all the sizes
void dfs1(int u, int par){
    sz[u] = 1;
    for(auto nxt : adj[u]){
        if(nxt.first != par && !done[nxt.first]){
            dfs1(nxt.first, u);
            sz[u] += sz[nxt.first];
        }
    }
}

int getCentroid(int u, int par, int tot){
    for(pii nxt : adj[u]){
        int v = nxt.first;
        if(v != par && !done[v] && sz[v] * 2 > tot){
            return getCentroid(v, u, tot);
        }
    }
    return u;
}

void getpath(int u, int par, int d, vi &path){
    ans += mapping[1 - d];
    ans += mapping[-1 - d];

    path.pb(d);
    for(pii e : adj[u]){
        if(e.first != par && !done[e.first]){
            getpath(e.first, u, d + e.second, path);
        }
    }
}

void solve(int root, int par){
    dfs1(root, 0);
    root = getCentroid(root, 0, sz[root]);
    done[root] = 1;
    mapping.clear();
    mapping[0] = 1;

    for(pii e : adj[root]){
        int v = e.first;
        int w = e.second;
        vi path;
        if(!done[v])    getpath(v, root, w, path);
        for(int x : path)   mapping[x] ++;
    }

    for(pii e : adj[root]){
        if(!done[e.first])  solve(e.first, root);
    }
}


// lightning mcqueen kawchaw
int main()
{
    boost();

    cin >> n;
    for(int i = 1, u, v, w; i < n; i++){
        cin >> u >> v >> c;
        w = c == 'r'?1:-1;
        adj[u].pb({v, w});
        adj[v].pb({u, w});
    }

    solve(1, 0);


    cout << ans - (n - 1) << endl;
    

    return 0;
}
