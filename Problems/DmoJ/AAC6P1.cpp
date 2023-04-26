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
int n, k;

// lightning mcqueen kawchaw
int main()
{
    boost();

    cin >> n >> k;
    
    if((n & 1) == 1){
        while(k - (n / 2) <= 0)    k *= 2;

        for(int i = k - (n / 2); i < k + n / 2; i++){
            cout << i << " ";
        }
        cout << k + n / 2 << endl;
    }else{
        while(k - (n / 2) <= 0)    k *= 2;

        for(int i = k - (n / 2); i < k; i++)    cout << i << " ";
        for(int i = k + 1; i < k + n / 2; i++)  cout << i << " ";
        cout << k + n / 2 << endl;

    }
    

    return 0;
}
