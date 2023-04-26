#include <bits/stdc++.h>

using namespace std;

#define endl "\n"
#define mp make_pair
#define pb push_back
#define boost() cin.tie(0), cin.sync_with_stdio(0);
typedef long long ll;
typedef vector<int> vi;
typedef pair<int, int> pii;
typedef pair<ll, ll> pll;

const int maxi = 2147483647;
const int mini = -2147483647;

const int MN = 200005;
int n, q, l, r, mid, ans = -1;
ll a, t, prefix_lcm[MN];
bool flag = false;

ll gcd(ll a, ll b) {
   if (b == 0) return a;
   return gcd(b, a % b);
}

ll lcm(ll a, ll b){
    return a * b / gcd(a, b);
}

// lightning mcqueen kawchaw
int main()
{
    boost();

    cin >> n >> q;

    cin >> prefix_lcm[0];
    
    for(int i = 1; i < n; i++){
        cin >> a;
        if(flag){
            prefix_lcm[i] = -1;
            continue;
        }
        ll newVal = lcm(prefix_lcm[i - 1], a);
        if(newVal > 1000000000) prefix_lcm[i] = -1, flag = true;
        else prefix_lcm[i] = newVal;
    }

    while(q--){
        ans = -1;
        l = 0;
        r = n - 1;
        mid = (l + r) >> 1;
        cin >> t;
        
        if(t == 0){
            cout << ans << endl;
            continue;
        }
       
        while(r >= l){
            // cout << l << " | " << mid << " | " << r << endl;
            if(prefix_lcm[mid] == -1 || t % prefix_lcm[mid] != 0){
                r = mid - 1;
            }else if(t % prefix_lcm[mid] == 0){
                l = mid + 1;
                ans = mid;
            }

            mid = (l + r) >> 1;        
        }
        ans += 2;
        if(ans == n + 1)   cout << "-1" << endl;
        else    cout << ans << endl;
    }

    return 0;
}
