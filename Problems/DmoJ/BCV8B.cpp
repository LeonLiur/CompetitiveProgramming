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
const int mini = -2147483647;

const int MN = 100005, MM = 1000005, LOG = 17;
const ll MOD = 1000000007;
vi adj[MN];
int n, a, b, x, k, q, up[MN], down[MN], bl[MN][LOG], depth[MN], t, src, dest;
ll fines[MM], ans = 0;
map<pii, int> banned;
bool one[MN];

void dfs(int cur, int par, int d){ 
    depth[cur] = d;

    bl[cur][0] = par;
    for(int i = 1; i < LOG; i++)    bl[cur][i] = bl[bl[cur][i-1]][i - 1];

    for(int nxt : adj[cur]){
        if(nxt != par) dfs(nxt, cur, d + 1);
    }
}

void dfs_psa(int cur, int par){
    for(int nxt : adj[cur]){
        if(nxt == par)    continue;
        dfs_psa(nxt, cur);

        up[cur] += up[nxt];
        down[cur] += down[nxt];

        if(banned.count(mp(cur, nxt))){
            ans = (ans + fines[down[nxt]]) % MOD;
        }
        if(banned.count(mp(nxt, cur))){
            ans = (ans + fines[up[nxt]]) % MOD;
        }
    }
}

int lca(int u, int v){
    if(depth[u] < depth[v]) swap(u, v);
    for(int i = LOG - 1; i >= 0; i--){
        if(depth[bl[u][i]] >= depth[v]) u = bl[u][i];
    }
    if(u == v)  return u;

    for(int i = LOG - 1; i >= 0; i--){
        if(bl[u][i] != bl[v][i]){
            u = bl[u][i];
            v = bl[v][i];
        }
    }

    return bl[u][0];
}

void preCompute(){
    fines[0] = 0;
    for(int i = 1; i < MM; i++){
        fines[i] = ((fines[i - 1] << 1) + 1) % MOD;
    }
}

// lightning mcqueen kawchaw
int main()
{
    boost();

    cin >> n;
    for(int i = 0; i < n - 1; i++){
        cin >> a >> b >> x;
        adj[a].pb(b);
        adj[b].pb(a);
        if(x == 1)  banned[mp(b, a)] = 1;
    }

    preCompute();
    // for(int i = 1; i <= n; i++) cout << fines[i] << " | ";
    dfs(1, 0, 0);
    
    src = 1;

    cin >> k;
    while(k--){
        cin >> dest;
        int commonAnc = lca(src, dest);
        // cout << "lca: " << commonAnc << " | src: " << src << " | dest: " << dest << endl;
        up[commonAnc] -= 1;
        up[src] += 1;

        down[commonAnc] -= 1;
        down[dest] += 1;
        src = dest;
    }

    dfs_psa(1, 0);

    cout << ans % MOD<< endl;

    return 0;
}
