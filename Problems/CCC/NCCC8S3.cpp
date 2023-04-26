#include <bits/stdc++.h>

using namespace std;

#define endl "\n"
#define mp make_pair
#define pb push_back
#define boost() cin.tie(0), cin.sync_with_stdio(0)
typedef signed long long ll;
typedef vector<int> vi;
typedef pair<int, int> pii;
typedef pair<ll, ll> pll;

const int maxi = 2147483647;
const int mini = -2147483647;

const int MN = 3005;
int n, q;
ll a, b;
pll p[MN];
map<pll, ll> mapping;

ll gcd(ll a, ll b){
    if(b == 0)  return a;
    else return gcd(b, a % b);
}
  
// lightning mcqueen kawchaw
int main()
{
    cin >> n;
    for(int i = 0; i < n; i++){
        cin >> a >> b;
        p[i] = mp(a, b);
    }

    ll ans = 0;
  
    for (int i = 0; i < n; i++) {
        mapping.clear();
  
        for (int j = i + 1; j < n; j++) {
            ll run = p[j].first - p[i].first;
            ll rise = p[j].second - p[i].second;
  
            ll gcdd = gcd(run, rise);
            run /= gcdd;
            rise /= gcdd;

            mapping[mp(run, rise)]++;
        }
        
        ll everyOtherEdge = 0;
  
        for (auto j : mapping){
            ans += j.second * everyOtherEdge;
            everyOtherEdge += j.second;
            // cout << "mapping for i = " << i << "(" << j.first.first << "," << j.first.second << ")" << " has count " << j.second << endl;
            // ans -= (j.second * (j.second - 1)) / 2;
        }
    }

    cout << ans << endl;


    return 0;
}
