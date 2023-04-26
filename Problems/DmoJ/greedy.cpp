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

const int MN = 2e5 + 5;
ll n, m, p, q, total = 0, pointer = 0, cost = 0;
pair<ll, ll> fs[MN];

// lightning mcqueen kawchaw
int main()
{
    boost();

    cin >> n >> m;
    for(int i = 0; i < n; i++){
        cin >> p >> q;
        fs[i] = mp(p, q);
    }

    sort(fs, fs + n);

    while(total < m){
        q = min(m - total, fs[pointer].second);
        total += q;
        cost += q * fs[pointer].first;
        pointer ++;
    }

    cout << cost << endl;

    return 0;
}
