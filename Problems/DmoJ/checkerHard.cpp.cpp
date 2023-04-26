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

const int MN = 3005;
int n, m, q, a, b, c, d, e;


class FenwickTree{
private:
    vector<vector<int>> ft;

public:
    int LSB(int x){
        return x & (-x);
    }

    ll query(int x, int y){
        // cout << "query2: " << x << " | " << y << endl;
        ll sum = 0;
        for(int x_ = x; x_ > 0; x_ -= LSB(x_)){
            // cout << "iteration" << endl;
            for(int y_ = y; y_ > 0; y_ -= LSB(y_)){
                sum = sum + ft[x_][y_];
            }
        }
        return sum;
    }

    ll query(int x1, int y1, int x2, int y2){
        return (query(x2, y2) - query(x1 - 1, y2) - query(x2, y1 - 1) + query(x1 - 1, y1 - 1));
    }

    void update(int x, int y, int value){
        for(int x_ = x; x_ < MN; x_ += LSB(x_)){
            for(int y_ = y; y_ < MN; y_ += LSB(y_)){
                ft[x_][y_] += value;
            }
        }
    }

    FenwickTree(){
        ft.assign(MN, vi (MN, 0));
    }
};

// lightning mcqueen kawchaw
int main()
{
    boost();

    cin >> n >> m >> a;
    
    FenwickTree ft1;
    FenwickTree ft2;

    int t1[MN][MN];

    while(a != 0){
        if(a == 1){
            cin >> b >> c >> d;
            if((b + c) % 2 == 0){
                ft1.update(b, c, d - t1[b][c]);
                t1[b][c] = d;
            }else{
                ft2.update(b, c, d - t1[b][c]);
                t1[b][c] = d;
            }
        }else if(a == 2){
            cin >> b >> c >> d >> e;
            ll ans1 = ft1.query(b, c, d, e);
            ll ans2 = ft2.query(b, c, d, e);
            if((b + c) % 2 == 0){
                cout << ans1 - ans2 << endl;
            }else{
                cout << ans2 - ans1 << endl;
            }
        }
        cin >> a;
    }
    return 0;
}
