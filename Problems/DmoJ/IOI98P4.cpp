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
#define y1 baguette
#define y2 croissant

const int maxi = 2147483647;
const int mini = -2147483648;

struct event {
    int y1, y2, x, type;

    event(int y1_, int y2_, int x_, int type_){
        y1 = y1_;
        y2 = y2_;
        x = x_;
        type = type_;
    }
};

const int MN = 5e3 + 5, MC = 2e4 + 5;
int n, x1, y1, x2, y2, layers[MC];
vector<event> v1, v2;



bool comp(event a, event b){
    if(a.x != b.x)  return a.x < b.x;
    return a.type < b.type;
}

int solve(vector<event> v){
    int ret = 0;
    for(event e : v){
        if(e.type == 1){
            // start event
            for(int i = e.y1; i < e.y2; i++)  if(layers[i] == 0)  ret++;
            for(int i = e.y1; i < e.y2; i++)    layers[i] ++;
        }else{
            // end event
            for(int i = e.y1; i < e.y2; i++)    layers[i] --;
            for(int i = e.y1; i < e.y2; i++)  if(layers[i] == 0)  ret++;
        }
    }

    return ret;
}

// orz orz orz orz
int main()
{
    boost();

    cin >> n;
    for(int i = 0; i < n; i++){
        cin >> x1 >> y1 >> x2 >> y2;
        x1 += 10000;
        x2 += 10000;
        y1 += 10000;
        y2 += 10000;
        v1.pb(event(y1, y2, x1, 1));
        v2.pb(event(x1, x2, y1, 1));
        v1.pb(event(y1, y2, x2, 2));
        v2.pb(event(x1, x2, y2, 2));
    }

    sort(v1.begin(), v1.end(), comp);
    sort(v2.begin(), v2.end(), comp);

    cout << solve(v1) + solve(v2) << endl;
    

    return 0;
}
