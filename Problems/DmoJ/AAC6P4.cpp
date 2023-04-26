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

const int MN = 5e5 + 5;
int n;
ll a[MN], s, ans, freq[MN];

// m = number of rounds
bool check(ll m){
    ll upper = (m + 1) * s, roundNeeded = 0, lower = m * s;
    for(int i = 1; i <= n; i++){
        if(a[i] <= upper)   roundNeeded += (upper - a[i]) / s;
        if(roundNeeded > lower) {ans = lower; return true;}
    }
    memset(freq, 0, sizeof(freq));
    for(int i = 1; i <= n; i++){
        if(a[i] <= upper)   freq[a[i] % s]++;
    }
    for(int i = 1; i <= n; i++){
        roundNeeded += freq[i];
    if(roundNeeded > m*s + i)   {ans = m * s + i; return true;}
    }
    return false;
}

// lightning mcqueen kawchaw
int main()
{
    boost();

    cin >> n >> s;

    for(int i = 1; i <= n; i++)  cin >> a[i];
    sort(a + 1, a + n + 1);

    if(s >= n){
        for(int i = 1; i <=n; i++)  if(a[i] < i)    {cout << a[i] << "\n"; return 0;}
        cout << "INF" << endl;
        return 0;
    }

    ll l = 0, r = 1e10;
    while(l <= r){
        ll mid = (l + r) >> 1;
        if(check(mid))  r = mid - 1;
        else l = mid + 1;
    }

    cout << ans << endl;

    
    return 0;
}
