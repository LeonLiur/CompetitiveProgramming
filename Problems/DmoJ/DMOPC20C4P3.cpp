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
#define y2 croisant 

const int maxi = 2147483647;
const int mini = -2147483648;

struct event{
    // type 1 is chord
    // type 2 is roomba
    int type;
    ll x, y;
};

bool comp(event a, event b){
    if(a.x != b.x)  return a.x < b.x;
    return a.type > b.type;
}

const int MN = 4e5 + 5;
int n, m;
ll x1, y1, x2, y2, st[MN * 4];
map<ll, ll> mapping;
vector<event> v;
pair<ll,ll> roombas[MN], chords[MN];
vector<ll> ys;

void update(int l, int r, int x, ll val, int index){
    if(l == r){
        st[index] += val;
        return;
    }
    int mid = (l + r) >> 1;
    if(x <= mid)    update(l, mid, x, val, index * 2);
    else    update(mid + 1, r, x, val, index * 2 + 1);
    st[index] = st[index * 2] + st[index * 2 + 1];
}

ll query(int l, int r, int targetL, int targetR, int index){
    if(r < targetL || l > targetR)  return 0;
    if(r <= targetR && l >= targetL)    return st[index];
    int mid = (l + r) >> 1;
    return query(l, mid, targetL, targetR, index * 2) + query(mid + 1, r, targetL, targetR, index * 2 + 1);
}

// lightning mcqueen kawchaw
int main()
{
    boost();

    cin >> n >> m;
    for(int i = 0; i < n; i++){
        cin >> roombas[i].first >> roombas[i].second;
        ys.pb(roombas[i].second);
        v.pb({1, roombas[i].first, roombas[i].second});
    }

    for(int i = 0; i < m; i++){
        cin >> chords[i].first >> chords[i].second;
        ys.pb(chords[i].second);
        v.pb({2, chords[i].first, chords[i].second});
    }

    sort(ys.begin(), ys.end());
    ys.erase(unique(ys.begin(),  ys.end()), ys.end());

    for(int i = 0; i < ys.size(); i++)  mapping[ys[i]] = i + 1;
    for(int i = 0; i < n; i++) update(1, ys.size(), mapping[roombas[i].second], 1, 1);
    
    sort(v.begin(), v.end(), comp);
    
    ll ans = 0;

    for(event e : v){
        // if seen roomba
        if(e.type == 1){
            update(1, ys.size(), mapping[e.y], -1, 1);
        }else{
            ans += query(1, ys.size(), 1, mapping[e.y], 1);
        }
    }

    cout << ans << endl;
    

    return 0;
}
