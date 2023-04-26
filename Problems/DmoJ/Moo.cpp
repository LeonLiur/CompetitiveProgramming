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
string a, b;
int n;

// lightning mcqueen kawchaw
int main()
{
    boost();

    cin >> n;
    string a (n, "moo");
    cin >> b;

    cout << a << " " << b << endl;

    if(a.find(b)){
        cout << "yes" << endl;
    }else{
        cout<< "no" << endl;
    }
    return 0;
}
