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
const int mini = -2147483648;

const int MN = 2e3 + 5;
const ll MOD = 1e9 + 7;
int n;
ll a[MN], res[MN], m, coeff[MN];

ll fpow(ll b, ll p){
    if(p == 0)  return 1;
    ll half = fpow(b, p >> 1);
    if((p & 1) == 1)    return half * half % MOD * b % MOD;
    else    return half * half % MOD;
}

// lightning mcqueen kawchaw
int main()
{
    boost();

    cin >> n;
    for(int i = 0; i < n; i++)  cin >> a[i];
    cin >> m;
    coeff[0] = 1;

    // cout << 1 << " ";

    for(int i = 1; i < n; i++){
        coeff[i] = coeff[i - 1] * (m + i - 1) % MOD * fpow(i, MOD - 2) % MOD;
        // cout << coeff[i] << " ";
    }

    // cout << endl;

    res[0] = a[0];
    for(int i = 1; i < n; i++){
        for(int j = i; j >= 0; j--){
            res[i] += coeff[j] * a[i - j] % MOD;
            res[i] %= MOD;
        }
    }

    for(int i = 0; i < n - 1; i++)  cout << res[i] << " ";
    cout << res[n - 1] << endl;
    

    return 0;
}
