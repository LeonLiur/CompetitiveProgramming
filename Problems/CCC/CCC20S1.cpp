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

const int MN = 1000005;
int n;
ll a, b;
double largest = 0;
vector<pll> v;

// lightning mcqueen kawchaw
int main()
{
    boost();

    cin >> n;
    while(n--)  cin >> a >> b, v.pb(mp(a, b));

    sort(v.begin(), v.end());
    for(int i = 1; i < v.size(); i++){
        largest = max((double) abs(v.at(i).second - v.at(i - 1).second) / (v.at(i).first - v.at(i-1).first), largest);
        cout << (double) abs(v.at(i).second - v.at(i - 1).second) << " " << (v.at(i).first - v.at(i-1).first) << endl;
    }
    cout << largest << endl;
    
    return 0;
}