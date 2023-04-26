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

const int MN = 0;
const ll MOD = 1e9+7;
int n;
string s;

unordered_map<char, int> m;

// lightning mcqueen kawchaw
int main()
{
    boost();

    cin >> s;
    for(char c : s) m[c]++;

    ll ans = 1;
    for(auto k : m) ans = ans * (k.second + 1) % MOD;

    cout << ans << endl;

    return 0;
}
