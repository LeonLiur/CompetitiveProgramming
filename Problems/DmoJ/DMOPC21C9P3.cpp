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

const int MN = 3e3 + 5;
int n, m, q, dist[MN][MN], visited[MN];
vi adj[MN];

void bfs(int star, int dis[]){
    queue<int> q;
    memset(visited, 0, sizeof(visited));
    q.push(star);
    visited[star] = 1;
    while(!q.empty()){
        int cur = q.front();
        q.pop();
        for(int n : adj[cur]){
            if(!visited[n]){
                q.push(n);
                visited[n] = 1;
                dis[n] = dis[cur] + 1;
            }
        }
    }
}

// lightning mcqueen kawchaw
int main()
{
    boost();

    cin >> n >> m;
    for(int i = 0; i < m; i++){
        int a, b;
        cin >> a >> b;
        adj[a].pb(b);
        adj[b].pb(a);
    }
    for(int i = 0; i < n; i++)  bfs(i, dist[i]);
    
    for(int i = 1, s, t, x, u, v, y; i<=q; i++){
        cin >> s >> t >> x >> u >> v >> y;
        if(dist[s][t] <= x || dist[u][v] <= y || dist[s][u] + dist[t][v] + 2 <= x + y || dist[t][u] + dist[s][v] + 2 <= x + y){
            cout << "YES" << endl;
        }else{
            cout << "NO" << endl;
        }
    }

    return 0;
}