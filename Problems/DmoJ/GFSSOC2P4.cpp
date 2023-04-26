#include <bits/stdc++.h>

using namespace std;

#define endl "\n"
#define mp make_pair
#define pb push_back
#define boost() cin.tie(0); cin.sync_with_stdio(0)
typedef long long ll;
typedef vector<int> vi;
typedef pair<int, int> pii;
typedef pair<ll, ll> pll;

const int maxi = 2147483647;
const int mini = -2147483647;

const int MN = 500005, MM = 500005;
const ll inf = 0x3f3f3f3f;
int n, m, a, b, w, d;

priority_queue<pii, vector<pii>, greater<pii>> pq;
vector<pii> adj[MN], adj2[MN];
vector<pair<pii, int>> edgeList;

ll dist1[MN], dist2[MN];

void dijkstra(int start, ll* d, vector<pii>* graph){
    while(!pq.empty())    pq.pop();
    pq.push(mp(0, start));
    d[start] = 0;

    while(!pq.empty()){
        pii cur = pq.top();
        pq.pop();

        int vertex = cur.second; 

        for(auto next : graph[vertex]){
            int next_cost = next.second;
            int next_vertex = next.first;

            if(d[next_vertex] > d[vertex] + next_cost){
                d[next_vertex] = d[vertex] + next_cost;
                pq.push(mp(d[next_vertex], next_vertex));
            }
        }
    }
}

// lightning mcqueen kawchaw
int main()
{
    boost();

    cin >> n >> m;    

    while(m--){
        cin >> a >> b >> w;
        adj[a].pb(mp(b, w));
        adj2[b].pb(mp(a, w));
    }
    cin >> d;

    edgeList.pb(mp(mp(1, 1),0));

    while(d--){
        cin >> a >> b >> w;
        edgeList.pb(mp(mp(a, b), w));
    }

    memset(dist1, inf, sizeof(dist1));
    memset(dist2, inf, sizeof(dist2));
    
    dijkstra(1, dist1, adj);
    dijkstra(n, dist2, adj2);

    ll shortest = inf;
    
    for(auto edge : edgeList){
        pii from_to = edge.first;
        int cost = edge.second;

        ll ans = dist1[from_to.first] + dist2[from_to.second] + cost;
        if(ans < shortest)  shortest = ans;
    }

    if(shortest == inf) cout << -1 << endl;
    else cout << shortest << endl;

    return 0;
}
