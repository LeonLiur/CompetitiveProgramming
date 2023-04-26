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

const int MN = 100005;
int n, q;
ll a, b, arr[MN];


struct Node{
    ll ans, pre, suf, sum, actual;
};

Node st[MN * 4];

ll gcd(ll x, ll y){
    return x == 0? y : gcd(y % x, x);
}

Node merge(Node x, Node y){
    Node m;
    m.ans = max(max(x.ans, y.ans), x.suf + y.pre);
    m.pre = max(x.pre, x.sum + y.pre);
    m.suf = max(y.suf, x.suf + y.sum);
    m.sum = x.sum + y.sum;
    m.actual = max(x.actual, y.actual);
    return m;
}

void build(int l, int r, int index){
    if(l == r){
        Node m;
        m.ans = max(0ll, arr[l]);
        m.pre = max(0ll, arr[l]);
        m.suf = max(0ll, arr[l]);
        m.sum = arr[l];
        m.actual = arr[l];
        st[index] = m;
        return;
    }

    int mid = (l + r) >> 1;
    build(l, mid, index * 2);
    build(mid + 1, r, index * 2 + 1);
    st[index] = merge(st[index * 2], st[index * 2 + 1]);
}

void update(int l, int r, int target, ll value, int index){
    if(l == r){
        st[index].ans = max(0ll, value);
        st[index].pre = max(0ll, value);
        st[index].suf = max(0ll, value);
        st[index].sum = value;
        st[index].actual = value;
        return;
    }
    int mid = (l + r) >> 1;
    if(target <= mid)    update(l, mid, target, value, index * 2);
    else    update(mid + 1, r, target, value, index * 2 + 1);
    
    st[index] = merge(st[index * 2], st[index * 2 + 1]);
}

Node query(int l, int r, int targetL, int targetR, int index){
    if(l > targetR || r < targetL || r < l){
        Node m;
        m.ans = -1e9-5;
        m.pre = -1e9-5;
        m.suf = -1e9-5;
        m.actual = -1e9-5;
        m.sum = 0;
        return m;
    }
    if(l >= targetL && r <= targetR)    return st[index];

    int mid = (l + r) >> 1;
    Node left = query(l, mid, targetL, targetR, index * 2);
    Node right = query(mid + 1, r, targetL, targetR, index * 2 + 1);
    return merge(left, right);
}

// lightning mcqueen kawchaw
int main()
{
    boost();

    cin >> n >> q;
    
    for(int i = 1; i <= n; i++) cin >> arr[i];

    build(1, n, 1);

    while(q--){
        char c; 
        cin >> c;
        if(c == 'S'){
            cin >> a >> b;
            update(1, n, a, b, 1);
        }else{
            cin >> a >> b;
            Node res = query(1, n, a, b, 1);
            if(res.actual <= 0){
                cout << res.actual << endl;
            }else{
                cout << res.ans << endl;
            }
        }
    }

    return 0;
}
