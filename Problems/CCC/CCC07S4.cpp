#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
#include <array>

using namespace std;
#define read(type) readInt<type>() // Fast read
#define ll long long
#define nL "\n"
#define pb push_back
#define mk make_pair
#define pii pair<int, int>
#define a first
#define b second
#define vi vector<int>
#define all(x) (x).begin(), (x).end()
#define umap unordered_map
#define uset unordered_set
#define MOD 1000000007
#define imax INT_MAX
#define imin INT_MIN
#define exp 1e9
#define sz(x) (int((x).size()))
 
int V;
int ans;

class Graph{
public:
    Graph(int vertices);
    void add_edge(int src, int dest);
    int dfs(int src, int dest, int count);
}

void addEdge(vector<int> adj[], int a, int b){
    adj[a].push_back(b);
}

/** END OF TEMPLATE**/
int32_t main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cin >> V;
    
    int dp[V + 1];
    bool visited[V + 1];

    fill(dp, dp + sizeof(dp)/sizeof(int), 0);
    fill(visited, visited + sizeof(visited)/sizeof(bool), false);

    vector<int> adj[V + 1];

    int src, dest;
    cin >> src;
    cin >> dest;
    while(src != 0 && dest != 0){
        addEdge(adj, src, dest);

        cin >> src;
        cin >> dest;
    }
    
    return 0;
}





