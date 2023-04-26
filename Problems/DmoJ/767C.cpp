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
int n;

struct line{
    int m, b;
    line(int m_, int b_){
        m = m_, b = b_;
    }

    int intersect(line o){
        return (o.b - b) / (m - o.m);
    }
};

// lightning mcqueen kawchaw
int main()
{
    boost();

    cin >> n;
    

    return 0;
}
