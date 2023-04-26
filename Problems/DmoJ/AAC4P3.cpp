#include <bits/stdc++.h>

using namespace std;


#define endl "\n"
#define mp make_pair
#define pb push_back
#define boost() cin.tie(0), cin.sync_with_stdio(0);
typedef long long ll;
typedef vector<int> vi;
typedef pair<int, int> pii;
typedef pair<ll, ll> pll;

const int maxi = 2147483647;
const int mini = -2147483647;

const int MN = 200005;
const int MM = 25;
int n, q, m;
ll x, y, k, d, ida[MN][MM];

ll gcd(ll a, ll b) {
   if (b == 0) return a;
   return gcd(b, a % b);
}

// lightning mcqueen kawchaw
int main()
{
    boost();

    cin >> n >> m;
    
    pair<ll, ll> arrEnd[MN];
    pair<ll, ll> arrSlope[MM];
    map<ll, vector<ll> > steeps;
    for(int i = 0; i < n; i++){
        cin >> x >> y;
        arrEnd[i] = mp(x, y);
    }
    int M = m;
    int cur = 0;
    for(int i = 0; i < M; i++){
        cin >> k >> d;
        if(k < 0)  k *= -1, d *= -1;

        ll gcdd = d < 0?gcd(k, -1 * d):gcd(k, d);
        k /= gcdd;
        d /= gcdd;

        if(count(steeps[k].begin(), steeps[k].end(), d)){
            m--;
            continue;
        }
        steeps[k].pb(d);
        arrSlope[cur] = mp(k, d);
        cur++;
    }
    for(int i = 0; i < n; i++){
        x = arrEnd[i].first;
        y = arrEnd[i].second;

        for(int j = 0; j < m; j++){
            ida[i][j] = arrSlope[j].first * x - arrSlope[j].second * y;
        }
    }

    ll counter = 0;
    for(int i = 0; i < m; i++){
        map <ll, ll> freq;
        for(int j = 0; j < n; j++){
            freq[ida[j][i]]++;
        }
        for(auto &entry : freq){
            counter += entry.second * (entry.second - 1) / 2;
        }
    }

    cout << counter << endl;

    return 0;
}
