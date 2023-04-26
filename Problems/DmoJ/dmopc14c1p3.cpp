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
double n, s, cur_avg, cur_len;

// lightning mcqueen kawchaw
int main()
{
    boost();

    cin >> n;
    cur_len = 0;
    for(int i = 0, a; i < n; i++){
        cin >> a;
        cur_avg = (cur_avg * cur_len + a) / (cur_len + 1);
        cur_len++;
    }
    cin >> s;
    for(int i = 0, a; i < s; i++){
        cin >> a;
        cur_avg = (cur_avg * cur_len + a) / (cur_len + 1);
        cur_len++;
        cout << cur_avg << endl;
    }
    

    return 0;
}
