#include <bits/stdc++.h>

using namespace std;

// #define endl "\n"
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
int n, t, a, b;

bool grid[103][103];

// lightning mcqueen kawchaw
int main()
{
    boost();

    cin >> n >> t;
    
    while(t--){
        if(n % 2 == 1){
            // here, you would want to start
            cout << 1 << endl;
            cout << (n + 1) / 2 << " " << (n + 1) / 2 << endl;
            while(1){
                int x, y;
                cin >> x >> y;
                if(x == 0 && y == 0)    continue;
                cout << (n + 1) / 2 - (x - (n + 1) / 2) << " " << (n + 1) / 2 - (y - (n + 1) / 2) << endl;
            }
        }else{
            // here, you would not want to start
            cout << 2 << endl;
            while(1){
                int x, y;
                cin >> x >> y;
                if(x == 0 && y == 0)    continue;
                cout << n + 1 - x << " " << n + 1 - y << endl;
            }

        }
    }
    

    return 0;
}
