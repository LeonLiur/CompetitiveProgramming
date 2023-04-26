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

const int MN = 105, MK = 100005;
int n, k;
bool dp[MK];
vector<int> a;

// lightning mcqueen kawchaw
int main()
{
    boost();

    cin >> n >> k;

    for(int i = 0; i < n; i++){
        int t;
        cin >> t;
        a.pb(t);
    }
    // base case
    dp[0] = 0;

    // i represents the amount of stones left on the board
    // dp[i] represents if i stones left guarantee a win
    for(int i = 1; i <= k; i++){
        for(int takeAway : a){
            if(takeAway <= i && !dp[i - takeAway]){
                dp[i] = true;
                // cout << "setting " << i << " as true for " << takeAway << endl;
            }
        }
    }

    if(dp[k]) cout << "First" << endl;
    else    cout << "Second" << endl;

    return 0;
}
