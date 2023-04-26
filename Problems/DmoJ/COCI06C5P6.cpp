#include <bits/stdc++.h>
#include <bits/extc++.h>

using namespace std;
using namespace __gnu_pbds;

#define endl "\n"
#define mp make_pair
#define pb push_back
#define boost() cin.tie(0), cin.sync_with_stdio(0)
typedef long long ll;
typedef vector<int> vi;
typedef pair<int, int> pii;
typedef pair<ll, ll> pll;

// trutrutiktiktappop

const int maxi = 2147483647;
const int mini = -2147483648;

const int MN = 0, X1 = 31, X2 = 97, MOD = 1e9 + 7, MOD2 = 1e9+9;
int n;
string s;

ll fpow(ll b, ll p, ll m){
    if(p == 0)  return 1;
    ll half = fpow(b, p >> 1, m) % m;
    if((p & 1) == 0)    return half * half % m;
    else    return half * half % m * b % m;
}

bool check(int length){
    gp_hash_table<ll, int> strs;
    strs.clear();
    ll hsh1 = 0, hsh2 = 0, highestPow1 = 1, highestPow2 = 1;
    // cout << highestPow1 << endl;
    for(int i = 0; i < length; i++){
        hsh1 = hsh1 * X1 % MOD;
        hsh2 = hsh2 * X2 % MOD2;
        hsh1 += s[i];
        hsh2 += s[i];
        hsh1 %= MOD;
        hsh2 %= MOD2;

        highestPow1 = highestPow1 * X1 % MOD;
        highestPow2 = highestPow2 * X2 % MOD2; 
    }

    strs[hsh1 * MOD2 + hsh2] = 1;

    for(int i = length; i < s.size(); i++){
        hsh1 = hsh1 * X1 % MOD;
        hsh2 = hsh2 * X2 % MOD2;
        hsh1 += s[i];
        hsh2 += s[i];
        hsh1 -= highestPow1 * s[i - length] % MOD;
        hsh2 -= highestPow2 * s[i - length] % MOD2;
        hsh1 %= MOD;
        hsh2 %= MOD2;
        hsh1 += MOD;
        hsh2 += MOD2;
        hsh1 %= MOD;
        hsh2 %= MOD2;
        if(strs.find(hsh1 * MOD2 + hsh2) != strs.end()) return true;
        strs[hsh1 * MOD2 + hsh2] = 1;
    }
    return false;
}

// lightning mcqueen kawchaw
int main()
{
    boost();

    cin >> n >> s;

    int l = 0, r = n, mid;


    while(l < r){
        mid = (l + r + 1) >> 1;
        // cout << "mid: " << mid << endl;
        if(check(mid)){
            l = mid;
            // cout << "true" << endl;
        }
        else{
            r = mid - 1;
            // cout << "false" << endl;
        }
    }

    cout << l << endl;
    
    return 0;
}
