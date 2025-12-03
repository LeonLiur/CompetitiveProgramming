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

const int MN = 1e4+5;
int n, t;

// lightning mcqueen kawchaw
int main()
{
    boost();

    cin >> t;
    
    while(t--){
        cin >> n;
        ll wastes_left = n-1, non_zero = 0, x;
        for (int i = 0; i < n; i++){
            cin >> x;
            if (x > 0){
                wastes_left -= (x-1);
                non_zero += 1;
            }

        }
        cout << non_zero - (wastes_left < 0 ? 0 : wastes_left) << endl;
    }

    return 0;
}
