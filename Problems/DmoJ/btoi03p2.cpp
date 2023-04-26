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

const int MN = 1e5 + 5;
int n, p[MN], sz[MN], vis[MN], ans;
vector<int> adj[MN];

int dfs(int cur, int par){
    vis[cur] = 1;
    vector<int> useds;
    for(int nxt : adj[cur]){
        if(vis[nxt] == 1 || nxt == par) continue;
        useds.pb(dfs(nxt, cur));
    }
    sort(useds.begin(), useds.end());
    int smallest = 1;
    for(int i = 0; i < useds.size(); i++){
        // if(cur == 5){cout << useds[i] << endl;}
        if(useds[i] == smallest)    smallest++;
        if(useds[i] > smallest) break;
    }
    p[cur] = smallest;
    ans += p[cur];
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

    dfs(1, 0);

    // for(int i = 0; i < n; i++){
    //     cout << p[i] << "_";
    // }
    // cout << endl;
    cout << ans << endl;

    return 0;
}
