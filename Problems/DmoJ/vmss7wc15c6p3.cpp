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
const int mini = ~maxi;

const int MN = 4e5 + 5;
int n, vis[MN];
ll ans = mini, p[MN];
vi adj[MN];

int dfs(int cur, int par){
    vis[cur] = 1;
    for(int nxt : adj[cur]){
        if(vis[nxt] == 1 || nxt == par) continue;
        p[cur] += dfs(nxt, cur);
    }

    ans = max(ans, p[cur]);
    return p[cur];
}

// lightning mcqueen kawchaw
int main()
{
    boost();

    cin >> n;
    for(int i = 0, a, b; i < n - 1; i++){
        cin >> a >> b;
        adj[a].pb(b);
        adj[b].pb(a);
    }

    for(int i = 0; i < n; i++){cin >> p[i + 1];}
    
    dfs(1, 0);

    cout << ans << endl;

    return 0;
}
