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

const int MN = 100005;
int t, n;
ll x, y, arr[MN];

// lightning mcqueen kawchaw
int main()
{
    boost();

    cin >> t;
    while(t--){
        cin >> n >> x >> y;
        for(int i = 0; i < n; i++){
            cin >> arr[i];
            x += arr[i];
        }

        if((x & 1) == (y & 1)){
            cout << "Alice" << endl;
        }else{
            cout << "Bob" << endl;
        }
    }

    return 0;
}
