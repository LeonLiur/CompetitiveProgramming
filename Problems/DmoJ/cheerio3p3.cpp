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
ll n, m;
double k, ist;

// lightning mcqueen kawchaw
int main()
{
    boost();

    cin >> n >> m;
    for(k = 1; k <= n; k++){
        if(ceil((n - k) / 2.0 / k - 1) + 1 + k <= m){
            break;
        }
    }
    // k = ceil(sqrt(n / 2.0));
    ist = ceil((n - k) / 2.0 / k - 1);
    
    cout << k + 1 + ist << endl;
    for(ll i = 1; i <= k; i++) cout << i << " ";
    cout << 2 * k << " ";
    for(int i = 1; i <= ist; i++){
        cout << 2 * k + k * (2 * i) << " ";
    }
    cout << endl;
    return 0;
}
