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

const int MN = 2e5+5;
int t, n;

ll k, qs[MN], rs[MN];

// lightning mcqueen kawchaw
int main()
{
    boost();

    cin >> t;

    while(t--){
        cin >> n >> k;
        for (int i = 0; i < n; i++) cin >> qs[i];
        for (int i = 0; i < n; i++) cin >> rs[i];

        sort(qs, qs + n);
        sort(rs, rs + n);

        int q_pointer = 0, r_pointer = n - 1, sols = 0, working = 0;
        while(q_pointer < n && r_pointer >= 0){
            ll q = qs[q_pointer], r = rs[r_pointer];
            bool works = r + (r +1) * q <= k;

            if(works){
                // cout << q << "*(" << r << "-1) + " << r << " works" << endl;
                working += 1;
                q_pointer += 1;
            }else{
                if(working > 0){
                    working -= 1;
                    sols += 1;
                }
                r_pointer -= 1;
            }
        }

        if(q_pointer == n)  sols += min(working, r_pointer + 1);

        int sols_increasing_q = sols;

        // now increasing r
        r_pointer = 0, q_pointer = n - 1, sols = 0, working = 0;
        while(r_pointer < n && q_pointer >= 0){
            ll q = qs[q_pointer], r = rs[r_pointer];
            bool works = r + (r + 1) * q <= k;

            if(works){
                // cout << q << "*(" << r << "-1) + " << r << " works" << endl;
                working += 1;
                r_pointer += 1;
            }else{
                if(working > 0){
                    working -= 1;
                    sols += 1;
                }
                q_pointer -= 1;
            }
        } 

        if(r_pointer == n)  sols += min(working, q_pointer + 1);

        int sols_increasing_r = sols;

        cout << max(sols_increasing_q, sols_increasing_r) << endl;
    }
    

    return 0;
}
