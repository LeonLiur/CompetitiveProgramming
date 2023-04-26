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

const int MN = 1e6 + 5;
int n, m, a[MN], val[MN], out[MN], done[MN];
vi adj[MN];
ll ans;

// lightning mcqueen kawchaw
int main()
{
    boost();

    cin >> n >> m;
    for(int i = 1; i <= n; i++){
        cin >> a[i];
        val[i] = a[i];
    }
    
    for(int i = 1, u, v; i <= m; i++){
        cin >> u >> v;
        val[v] = val[v] ^ a[u];
        adj[v].pb(u);
        out[u] ++;
    }

    queue<int> q;
    for(int i = 1; i <= n; i++){
        if(out[i] == 0) q.push(i);
    }


    while(!q.empty()){
        int u = q.front();
        q.pop();

        ans += val[u];
        done[u] = true;

        for(int v : adj[u]){
            if(--out[v] == 0)   q.push(v);
        }
    }

    for(int i = 1; i <= n; i++){
        if(a[i] && !done[i]){
            cout << "-1" << endl;
            return 0;
        }
    }

    cout << ans << endl;

    return 0;
}
