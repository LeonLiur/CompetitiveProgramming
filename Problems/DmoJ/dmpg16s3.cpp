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

const int MN = 1e5 + 5;
ll n, m, r, hasStop[MN], rocket, normal, tot;

// lightning mcqueen kawchaw
int main()
{
    boost();

    cin >> n >> r >> m;
    for(int i = 0, a; i < r; i++){
        cin >> a;
        hasStop[a] = 1;
    }
    for(int i = 0, a; i < m; i++){
        cin >> a;
        if(hasStop[a]){
            rocket++;
        }else{
            normal++;
        }
    }

    if(rocket <= normal){
        tot += normal / 2.0 * (normal + 1);
        tot += rocket / 2.0 * (rocket + 1);
        cout << tot << endl;
    }else{
        ll newRocket = ceil((rocket + normal) / 2.0);
        ll newNormal = rocket + normal - newRocket;
        rocket = newRocket;
        normal = newNormal;
        tot += normal / 2.0 * (normal + 1);
        tot += rocket / 2.0 * (rocket + 1);
        cout << tot << endl;
    }

    return 0;
}
