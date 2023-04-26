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

const int MN = 20;
int n, m, a, b;
vector<int> adj[MN];
vector<pair<int, int>> v;

int main()
{
    boost();

    for(int i = 0; i <= n; i++){
        v.pb(mp(i, 0));
    }

    cin >> n >> m;
    while(m--){
        cin >> a >> b;
        adj[a].pb(b);
        adj[b].pb(a);
        v.at(a).second = a;
        v.at(a).first += 1;
        v.at(b).second = b;
        v.at(b).first += 1;
    }

    sort(v.begin(), v.end());

    for(int i = n + 1; i >= 1; i--){
        cout << v.at(i).second << endl;
    }


    return 0;
}
