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

const ll MN = 1e6 + 5;
int n;
ll psa[MN];

// lightning mcqueen kawchaw
int main()
{
    boost();

    cin >> n;
    for(int i = 1; i <= n; i++){
        int k;
        cin >> k;
        psa[i] = psa[i - 1] + k;
        // cout << psa[i] << endl;
    }

    
    for(int i = 1; i < n; i++){
        ll l, r;
        l = psa[i];
        r = psa[n] - l;
        // cout << l << " " << r << endl;
        if(l == r){
            cout << i << endl;
            return 0;
        }
    }

    cout << "Andrew is sad." << endl;

    return 0;
}
