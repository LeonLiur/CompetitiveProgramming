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

const int MN = 10005;
int n, k, q;

// lightning mcqueen kawchaw
int main()
{
    boost();

    cin >> n >> k;

    string s;
    cin >> s;
    char a = s.at(0);
    char b = s.at(1);

    for(int i = 0; i < n; i++){
        cin >> s;
        char x = s.at(0);
        char y = s.at(1);
        
        if(x != a){
            cout << 0 << endl;
            return 0;
        }
    }
    
    cout << 2 << endl;

    return 0;
}
