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

const int MN = 1e6 + 5;
int n, q, previ[MN], nex[MN];

// lightning mcqueen kawchaw
int main()
{
    boost();

    cin >> n >> q;

    for(int i = 1; i <= n; i++){
        previ[i] = i - 1;
        nex[i] = i + 1;
    }

    while(q--){
        int l, r, k;
        cin >> l >> r >> k;

        if(previ[l] != k){
            nex[l - 1] = r + 1;
            nex[r + 1] = l - 1;

            nex[r] = k + 1;
            previ[k + 1] = r;

            previ[l] = k;
            nex[k] = l;
        }
    }

    for(int i = nex[0]; i != n + 1; i=nex[i])   cout << i << " ";
    

    return 0;
}
