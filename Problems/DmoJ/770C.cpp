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

const int MN = 0;
int t, n, m;

// lightning mcqueen kawchaw
int main()
{
    boost();

    cin >> t;
    while(t--){
        cin >> n >> m;
        if(m == 1){
            cout << "YES" << endl;
            for(int i = 1; i <= n; i++) cout << i << endl;
        }else if(n == 1){
            cout << "NO" << endl;
        }else{
            if((n & 1) == 1){
                cout << "NO" << endl;
            }else{
                cout << "YES" << endl;
                int nxtOdd = 1;
                int nxtEven = 2;
                for(int i = 1; i <= n; i++){
                    if((i & 1) == 0){
                        for(int i = 1; i < m; i++){
                            cout << nxtEven << " ";
                            nxtEven += 2;
                        }
                        cout << nxtEven << endl;
                        nxtEven += 2;
                    }else{
                        for(int i = 1; i < m; i++){
                            cout << nxtOdd << " ";
                            nxtOdd += 2;
                        }
                        cout << nxtOdd << endl;
                        nxtOdd += 2;
                    }
                }
            }
        }
    }
    

    return 0;
}
