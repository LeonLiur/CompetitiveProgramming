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

const int MN = 105;
int q, n, k;
int a[MN];
int b[MN];
vector<pii> req;

// lightning mcqueen kawchaw
int main()
{
    boost();

    cin >> q;
    while(q--){
        cin >> n >> k;
        for(int i = 0; i < n; i++){
            cin >> a[i];
        }
        for(int i = 0; i < n; i++){
            cin >> b[i];
            req.pb(mp(a[i], b[i]));
        }

        sort(req.begin(), req.end());
        for(int i = 0; i < req.size(); i++){
            // cout << req[i].first << " | " << req[i].second << " | " << k << endl;
            if(k >= req[i].first){
                k += req[i].second;
                // cout << "new k " << k << endl;
            }else{
                break;
            }
        }

        cout << k << endl;
        req.clear();
    }
    

    return 0;
}
