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

const int MN = 100005;
int n, m, q, a, b, c, par[MN], rnk[MN];
ll d;

struct edge{
    int s, e, v;
    bool og;
    edge(int s_, int e_, int v_, bool og_){
        s = s_;
        e = e_;
        v = v_;
        og = og_;
    }
};

edge edgeList[MN];

int find(int x){
    if(par[x] == -1)    return x;
    return par[x] = find(par[x]);    
}

int unite(int a, int b){
    int pa = find(a);
    int pb = find(b);
    if(pa != pb){
        if(rnk[a] > rnk[b])   par[b] = pa;
        else if(rnk[b] > rnk[a])   par[a] = pb;
        else par[b] = pa, rnk[pa]++;
    }
}

bool compareEdge(edge a, edge b){return a.v < b.v;}

// lightning mcqueen kawchaw
int main()
{
    boost();

    cin >> n >> m >> d;
    for(int i = 0; i < m; i++){
        cin >> a >> b >> c;
        edgeList[i] = edge(a, b, c, i < n-1);
    }
    memset(par, -1, sizeof(par));
    memset(rnk, 0, sizeof(memset));

    // sort()
    

    return 0;
}
