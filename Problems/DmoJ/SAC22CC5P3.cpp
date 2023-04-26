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

const int MN = 1e6 + 5;
int t, n;
ll f[MN], MOD = 1e9 + 7;

void pre(){
    f[0] = 1;
    f[1] = 0;
    for(int i = 2; i <= 1000000; i++)   f[i] = (i - 1) * (f[i - 1] + f[i - 2]) % MOD;
}

// lightning mcqueen kawchaw
int main()
{
    boost();
    pre();

    cin >> t;
    while(t--){
        cin >> n;
        cout << f[n] << endl;
    }
    

    return 0;
}
