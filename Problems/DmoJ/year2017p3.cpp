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

const int MN = 1e6 + 5;
ll k, n;
ll coolA[MN];
ll coolMax[MN];

ll cool(ll i){
    if(i == 1)  return max(coolA[1], coolA[2]);
    if(i == 2)  return max(coolA[1], coolA[2]);
    ll ret;
    // whole
    ret = coolA[i];
    // divide into 2
    ret = max(ret, coolA[i - 1] + coolA[i - 2]);
    if(i > 3)  ret = max(ret, coolA[i - 1] + cool(i - 2));
    return ret;
}

// lightning mcqueen kawchaw
int main()
{
    boost();

    cin >> k >> n;
    for(int i = 1; i <= n; i++){
        cin >> coolA[i];
        coolMax[i] = -1;
    }
    if(k > n + 1){
        cout << -1 << endl;
    }else if(k == 2){
        cout << max(coolA[1], coolA[2]) << endl;
    }else{
        cout << cool(k) << endl;
    }

    // for(int i = 1; i <= k; i++){
    //     cout << coolMax[i] << " ";
    // }
    

    return 0;
}
