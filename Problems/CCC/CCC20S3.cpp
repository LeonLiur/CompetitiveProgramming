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

const int MN = 0;
const ll MOD = 1e9 + 7;
const ll X1 = 131;
const ll X2 = 97;
int n, q, freq[26], nFreq[26];
string s, h;
ll highestPow1, highestPow2;

set<pll> setHash;

bool checkequal(int a[26], int b[26]){
    for(int i = 0; i < 26; i++) if(a[i] != b[i])    return false;

    return true;
}

ll fpow(ll b, ll p){
    if(p == 0)  return 1;
    ll half = fpow(b, p >> 1);
    if((p & 1) == 0)    return half * half % MOD;
    else return half * half % MOD * b % MOD;
}

// lightning mcqueen kawchaw
int main()
{
    boost();

    cin >> s >> h;
    if(s.size() > h.size()){
        cout << 0 << endl;
        return 0;
    }

    highestPow1 = fpow(X1, s.size());
    highestPow2 = fpow(X2, s.size());
    ll hash1 = 0;
    ll hash2 = 0;
    for(int i = 0; i < s.size(); i++){
        int c = s.at(i) - 'a';
        nFreq[c]++;

        int d = h.at(i) - 'a';
        freq[d]++;
        hash1 = hash1 * X1 % MOD + d;
        hash1 %= MOD;

        hash2 = hash2 * X2 % MOD + d;
        hash2 %= MOD;
    }

    if(checkequal(freq, nFreq))     setHash.insert(mp(hash1, hash2));

    for(int i = s.size(); i < h.size(); i++){
        int past = h.at(i - s.size()) - 'a';
        int neww = h.at(i) - 'a';
        hash1 %= MOD;
        hash1 = hash1 * X1 % MOD + neww;
        hash1 %= MOD;
        hash1 -= highestPow1 % MOD * past % MOD;
        hash1 %= MOD;
        hash1 += MOD;
        hash1 %= MOD;

        hash2 %= MOD;
        hash2 = hash2 * X2 % MOD + neww;
        hash2 %= MOD;
        hash2 -= highestPow2 % MOD * past % MOD;
        hash2 %= MOD;
        hash2 += MOD;
        hash2 %= MOD;
        freq[past] --;
        freq[neww] ++;
        if(checkequal(freq, nFreq)){
            setHash.insert(mp(hash1, hash2));
        }
    }  

    cout << setHash.size() << endl;
    

    return 0;
}
