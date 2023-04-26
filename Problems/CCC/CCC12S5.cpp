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

const int MN = 28;
int r, c, q, a, b, res = 0;
int dp[MN][MN];

// lightning mcqueen kawchaw
int main()
{
    boost();

    cin >> r >> c >> q;
    while(q--){
        cin >> a >> b;
        dp[a - 1][b - 1] = -1;
    }

    for(int i = 0; i < r; i++){
        for(int j = 0; j < c; j++){
            if(dp[i][j] == -1){
                dp[i][j] = 0;
            }
            else if(i == 0 && j == 0){
                dp[i][j] = 1;
            }
            else if(i == 0){
                dp[i][j] = dp[i][j - 1];
            }
            else if(j == 0){
                dp[i][j] = dp[i - 1][j];
            }
            else{
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
            }
        }
    }

    for(int i = 0; i < r; i++){
        for(int j = 0; j < c; j++){
            cout << dp[i][j] << " ";
        }
        cout << endl;
    }

    cout << dp[r-1][c-1] << endl;
    

    return 0;
}