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
const int MK = 5e4 + 5;
int n, k, psa[MN], a, freq[MK];
ll ans = 0;

// lightning mcqueen kawchaw
int main()
{
    boost();

    cin >> n >> k >> a;
    psa[0] = a;
    for(int i = 1; i < n; i++){
        cin >> a;
        psa[i] = psa[i - 1] + a;
    }

    for(int i = 0; i < n; i++){
            
    }

    cout << ans << endl;

    return 0;
}
