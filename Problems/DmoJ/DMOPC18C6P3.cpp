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

const int MN = 200005;
int n, m, q, a, b, components = 0;
bool visited[MN];
vi adj[MN];

void dfs(int cur){
    visited[cur] = true;
    for(int k : adj[cur]){
        if(visited[k])  continue;
        dfs(k);
    }
}

// lightning mcqueen kawchaw
int main()
{
    boost();

    cin >> n >> m;

    for(int i = 0; i < m; i++){
        cin >> a >> b;
        adj[a].pb(b);
        adj[b].pb(a);
    }

    for(int i = 1; i <= n; i++){
        if(visited[i])  continue;
        dfs(i);
        components++;
    }

    if(m == n - components || m == n - components + 1){
        cout << "YES" << endl;
    }else{
        cout << "NO" << endl;
    }

    return 0;
}
