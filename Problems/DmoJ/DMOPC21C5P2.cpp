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

// lightning mcqueen kawchaw
int main()
{
    boost();

    cin >> n;
    if(n <= 4){
        if(n == 1)  cout << 1 << endl;
        if(n == 2)  cout << -1 << endl;
        if(n == 3)  cout << "1 3 2" << endl;
        if(n == 4)  cout << "1 3 2 4" << endl;
    }else{
        cout << "1 3 2 4 ";
        for(int i = 5; i < n; i++){
            cout << i << " ";
        }
        cout << n << endl;
    }
    

    return 0;
}
