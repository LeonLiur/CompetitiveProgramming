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

const int MN = 1000005;
int n, q;

// lightning mcqueen kawchaw
int main()
{
    boost();

    cin >> n;

    if(n < 5){
        if(n == 1) cout << 1 << endl;
        else cout << -1 << endl;
    }else if(n == 5){
        cout <<"1 3 5 4 2" << endl;
    }else{
        for(int i = 1; i <= n; i+=2){
            if(i == 5)  continue;
            cout << i << " ";
        }
        cout << 5 << " " << 4 << " ";
        for(int i = 2; i <= n; i+= 2){
            if(i == 4)  continue;
            if(i == n || i == n - 1)    cout << i << endl;
            else cout << i << " ";
        }
    }
    

    return 0;
}
