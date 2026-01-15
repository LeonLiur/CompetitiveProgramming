#include <bits/stdc++.h>
// https://codeforces.com/contest/2178/problem/D

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

const int MN = 2e5 + 5;
int n, t, m, a[MN];


int main() {
    boost();
    cin >> t;
    while (t--) {
        cin >> n >> m;
        unordered_map<int, int> value_to_ind;
        for(int i = 0; i < n; i++){
            cin >> a[i];
            value_to_ind[a[i]] = i + 1;
        }

        if(m > n/2){
            cout << -1 << endl;
            continue;
        }

        sort(a, a+n);

        
        if(m > 0){
            int consume_start = n - 2 * m, surviving_start = n - m;
            cout << consume_start + m << endl;
            for(int i = 0; i < consume_start; i++){
                // cout << i << " " << i + 1 << endl;
                cout << value_to_ind[a[i]] << " " << value_to_ind[a[i + 1]] << endl;
            }
            for(int j = 0; j < m; j++){
                // cout << surviving_start + j << " " << consume_start + j << endl;
                cout << value_to_ind[a[surviving_start + j]] << " " << value_to_ind[a[consume_start + j]] << endl;
            }
        }else{
            int consume_start = n - 2;
            ll sum = 0;
            for(int i = n - 2; i >= 0; i--){
                sum += a[i];
                consume_start = i;
                if(sum >= a[n - 1]){
                    break;
                }
            }

            if(consume_start == 0 && sum < a[n - 1]){
                cout << -1 << endl;
                continue;
            }

            cout << max(consume_start, 0) + n - 1 - consume_start << endl;

            for(int i = 0; i < consume_start; i++){
                cout << value_to_ind[a[i]] << " " << value_to_ind[a[i + 1]] << endl;
            }
            
            for(int i = consume_start; i < n - 1; i++){
                cout << value_to_ind[a[i]] << " " << value_to_ind[a[n - 1]] << endl;
            }
        }
    }

    return 0;
}
