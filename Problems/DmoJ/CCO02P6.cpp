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

const int MN = 106;
int n;
double t, dt, c, dc, pit, dpit, fuel[MN], tim[MN], dp[MN];

// lightning mcqueen kawchaw
int main()
{
    boost();
    while(cin >> n >> t >> dt >> c >> dc >> pit >> dpit){
        fill(dp, dp+MN, 1e18); dp[0] = 0;
        for(int i = 0; i < n; i++){
            fuel[i] = (fuel[i - 1] + c) / (1 - dc);
            tim[i] = tim[i - 1] + t + fuel[i] * dt;
        }

        for(int i = 1; i <= n; i++){
            dp[i] = tim[i];
            for(int j = 1; j < i; j++){
                dp[i] = min(dp[i], dp[j] + tim[i -1] + pit + fuel[i - j] * dpit);
            }
        }

        printf("%d %.3f %.3f %.3f %.3f %.3f %.3f\n", n, t, dt, c, dc, pit, dpit);
    }
    
    

    return 0;
}
