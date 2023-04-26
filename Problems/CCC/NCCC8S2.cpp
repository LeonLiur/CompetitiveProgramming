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
const int mini = -2147483647;

const int MN = 0;
int n, q;
double x, y, x1, x2, ya;
double ybb;

// lightning mcqueen kawchaw
int main()
{
    boost();

    cin >> x >> y >> x1 >> ya >> x2 >> ybb;
    // cout << x << " " << y << " " << x1 << " " << x2 << " " << ya << " " << ybb << endl;
    long double ans = 0;
    if(x >= x1 && x <= x2){
        ans = min(abs(y - ya), abs(y - ybb));
    }else if(y >= ya && y <= ybb){
        // cout << "asfsd" << endl;
        ans = min(abs(x - x1), abs(x - x2));
    }else{
        if(x < x1){
            long double dist1 = sqrt((x1 - x) * (x1 - x) + (ya - y)*(ya - y));
            long double dist2 = sqrt((x1 - x) * (x1 - x) + (ybb - y) * (ybb - y));
            ans = min(dist1, dist2);
        }else{
            long double dist1 = sqrt((x2 - x)*(x2 - x) + (ya - y)*(ya - y));
            long double dist2 = sqrt((x2 - x)*(x2 - x) + (ybb - y)*(ybb - y));
            ans = min(dist1, dist2);
        }
    }
    
    cout << fixed << setprecision(3) << ans << endl;

    return 0;
}
