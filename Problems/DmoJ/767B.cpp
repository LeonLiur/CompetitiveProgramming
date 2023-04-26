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

const int MN = 0;
int n;
ll l, r, k;

// lightning mcqueen kawchaw
int main()
{
    boost();

    cin >> n;
    while(n--){
        cin >> l >> r >> k;
        ll op = 0;
        if(l == r){
            if(l == 1)  op = k + 1;
            else op = 0;
        }else if(((l + r) & 1) == 0){
            // even even
            if((l & 1) == 0){
                op = (r - l) >> 1;
            }else{
                op = ((r  - l) >> 1) + 1;
            }
        }else{
            op = ((r - l) >> 1) + 1;
        }

        if(op <= k) cout << "YES" << endl;
        else    cout << "NO" << endl;
    }
    

    return 0;
}
