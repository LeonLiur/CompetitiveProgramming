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
int n, q;

// lightning mcqueen kawchaw
int main()
{
    boost();

    cin >> q;

    while(q--){
        cin >> n;
        int m = 0;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                int value = n * i + j + 1;
                if(i > 0){
                    value += n * i + j + 1 - n;
                }
                if(i < n-1){
                    value += n * i + j + 1 + n;
                }
                if(j > 0){
                    value += n * i + j;
                }
                if(j < n - 1){
                    value += n * i + j + 2;
                }
                m = max(value, m);
            }
        }

        cout << m << endl;
    }
    

    return 0;
}
