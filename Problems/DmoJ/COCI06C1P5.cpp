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

const int MN = 20;
const int MOD = 1e9 + 7;
int n, q;
double prob[MN][MN], dp[1 << MN];

// lightning mcqueen kawchaw
int main()
{
    boost();

    cin >> n;
    for(int i = 0; i < n; i++){
        for(int j = 0; j < n; j++){
            double a;
            cin >> a;
            prob[i][j] = a * 0.01;
        }
    }

    // state: dp[msk] represents the probablity of success when the msk agents are occupied

    dp[0] = 1;

    for(int mission = 0; mission < n; mission ++){
        for(int agent = 0; agent < n; agent ++){
            for(int msk = 0; msk < (1 << n); msk++){
                if(__builtin_popcount(msk) != mission)    continue;
                if(msk & (1 << agent))    continue;

                int newmsk = msk | (1 << agent);
                dp[newmsk] = max(dp[newmsk], dp[msk] * prob[agent][mission]);
            }
        }
    }
    

    // print last in dp
    cout << fixed << setprecision(6) << dp[(1 << n) - 1] * 100 << endl;

    return 0;
}
