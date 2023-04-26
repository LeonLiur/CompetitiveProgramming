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
int h1, w1, h2, w2, dp[3][305][3][305];

int fun(int h1, int w1, int h2, int w2){
    if(h1 == 1 && w1 == 1 && h2 == 1 && w2 == 1)    return 0;
    // reference the dp variable; dont have to type dp[h1][w1][h2][w2] every time
    int &ret = dp[h1][w1][h2][w2];
    if(ret != -1)   return ret;
    ret = 0;

    // o1
    for(int k = 1; k < w1; k++) ret |= !fun(h1, k, h1, w1-k);
    for(int k = 1; k < w2; k++) ret |= !fun(h2, k, h2, w2-k);
    if(h1 == 2) ret |= !fun(1, w1, 1, w1);
    if(h2 == 2) ret |= !fun(1, w2, 1, w2);

    // o2
    for(int k = 1; k < 11 && k < w1; k++)   ret |= !fun(h1, w1 - k, h2, w2);
    for(int k = 1; k < 11 && k < w2; k++)  ret |= !fun(h1, w1, h2, w2-k);
    if(h1 == 2) ret |= !fun(1, w1, h2, w2);
    if(h2 == 2) ret |= !fun(h1, w1, 1, w2);

    return ret;
}

// lightning mcqueen kawchaw
int main()
{
    boost();

    cin >> h1 >> w1 >> h2 >> w2;
    memset(dp, -1, sizeof(dp));
    cout << (fun(h1, w1, h2, w2) ? "W" : "L");
    cout << endl;
    

    return 0;
}
