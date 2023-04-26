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

const int MN = 1000005;
const int X = 131;
const int X2 = 97;
const int MOD = 1e9 + 7;
int n, q, ansLength;
ll hashS1, hashT1, hashS2, hashT2;

string s, t;

ll fastPower(ll b, ll p){
    if(p == 0)  return 1;
    
    ll half = fastPower(b, p / 2);
    if((p & 1) == 0)    return half * half % MOD;
    else return half * half % MOD * b % MOD;
}

// lightning mcqueen kawchaw
int main()
{
    boost();

    cin >> s >> t;
    
    for(int i = 1; i <= min(s.size(), t.size()); i++){
        hashT1 = hashT1 * X + t[i - 1];
        hashT1 %= MOD;
        hashS1 += fastPower(X, i - 1) * s[s.size() - i];
        hashS1 %= MOD;

        hashT2 = hashT1 * X2 + t[i - 1];
        hashT2 %= MOD;
        hashS2 += fastPower(X2, i - 1) * s[s.size() - i];
        hashS2 %= MOD;

        if(hashS1 == hashT1 && hashS2 == hashT2)  ansLength = i;
    }

    cout << s << t.substr(ansLength) << endl;

    return 0;
}
