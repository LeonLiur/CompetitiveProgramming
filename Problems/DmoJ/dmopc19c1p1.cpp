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

const int MN = 0;
int m;
ll n, a, b, t, ans;

// lightning mcqueen kawchaw
int main()
{
    boost();

    cin >> m;
    while(m--){
        cin >> n >> a >> b >> t;
        ans = (t + n * b) % (a + b) == 0 ? (t + n * b) / (a + b) : (t + n * b) / (a + b) + 1;
        if(ans >= 0 && ans <= n){
            cout << ans << endl;
        }else{
            cout << -1 << endl;
        }
    }
    

    return 0;
}
