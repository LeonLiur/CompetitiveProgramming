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

const int MN = 105;
int n;
vi a;
set<int> ss;

// lightning mcqueen kawchaw
int main() {
    boost();

    cin >> n;
    for (int i = 0, a; i < n * n; i++) {
        cin >> a;
        if(ss.contains(a))  ss.erase(a);
        else    ss.insert(a);
    }
    for(int x : ss){
        a.pb(x / 2);
    }

    sort(a.begin(), a.end());
    for(int i = 0; i < a.size() - 1; i++){
        cout << a.at(i) << " ";
    }

    cout << a.at(a.size() - 1) << endl;
    

    return 0;
}
