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
int n, h;

// lightning mcqueen kawchaw
int main()
{
    boost();

    cin >> n >> h;

    for(int i = 0, x; i < n; i++){
        cin >> x;
        cout << x + 2 * h << " ";
    }

    cout << endl;
    

    return 0;
}
