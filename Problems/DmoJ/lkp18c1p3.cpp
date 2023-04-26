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
int t, d, root_count;
vector<ll> coef;
ll res, powers[305][8], last_root, a;

vector<ll> sdiv(vector<ll> coefs, ll div){
    vector<ll> ret;
    ret.pb(coefs[0]);
    for(int i = 1; i < coefs.size(); i++){
        ret.pb(coefs[i] + (ret[i - 1] * div));
    }

    return ret;
}

// lightning mcqueen kawchaw
int main()
{
    boost();
    cin >> t;

    while(t--){
        root_count = 0;
        cin >> d;
        for(int i = 0; i < d + 1; i++){
            cin >> a;
            coef.pb(a);
        }
        for(int i = -150; i <= 150; i++){
            vector<ll> ret = sdiv(coef, i);
            if(ret[ret.size() - 1] != 0)    continue;
            // otherwise i is a root
            cout << i << " ";

            coef = ret;
            // for(auto x : coef){
            //     cout << x << "__";
            // }
            // cout << endl << "---" << endl;

            coef.pop_back();

            
            
            i--;
        }

        coef.clear();
        cout << endl;
    }



    return 0;
}
