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

const int MN = 1e6 + 5;
int n, k;
string s;
vector<int> ones;

int findVal(int a){
        if(a % 2 == 1)          return ((a) >> 1) + 1;
        else return ((a) >> 1);
    }

// lightning mcqueen kawchaw
int main()
{
    boost();

    cin >> n >> k >> s;
    for(int i = 0; i < n; i++){
        if(s.at(i) == '1')    ones.pb(i);
    }

    int ans = 0;
    if(ones[0] != 0)    ans = max(ans, findVal(ones[0]));
    // cout << ans << endl;

    if(ones[1] - 1 != ones[0])    ans = max(ans, findVal(ones[1] - 1 + 1 - 1));
    // cout << ans << endl;

    for(int i = 2; i < ones.size(); i++){
        ans = max(ans, findVal(ones[i] - (ones[i - 2] + 1) - 1));
    }
    
    ans = max(ans, findVal((int) n - ones[ones.size() - 1] - 1));
    // cout << ans << endl;
    ans = max(ans, findVal((int) n - ones[ones.size() - 2] - 1 - 1));
    

    cout << ans << endl;

    return 0;
}
