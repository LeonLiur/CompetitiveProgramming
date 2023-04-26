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
    ll min, gcd;
    int countGCD;

    // Node(ll a, ll b, int c){
    //     min = a;
    //     gcd = b;
    //     countGCD = c;
    // }
};

Node st[MN * 4];

ll gcd(ll x, ll y){
    return x == 0? y : gcd(y % x, x);
}

Node merge(Node x, Node y){
    ll newMin = min(x.min, y.min);
    ll newGCD = gcd(x.gcd, y.gcd);
    Node m;
    m.min = newMin;
    m.gcd = newGCD;
    m.countGCD = 0;
    if(m.gcd == x.gcd)  m.countGCD += x.countGCD;
    if(m.gcd == y.gcd)  m.countGCD += y.countGCD;

    return m;
}

void build(int l, int r, int index){
    if(l == r){
        Node m;
        m.min = arr[l];
        m.gcd = arr[l];
        m.countGCD = 1;
        st[index] = m;
        return;
    }

    int mid = (l + r) >> 1;
    build(l, mid, index * 2);
    build(mid + 1, r, index * 2 + 1);
    st[index] = merge(st[index * 2], st[index * 2 + 1]);
}

void update(int l, int r, int target, int value, int index){
    if(l == r){
        Node m;
        m.min = value;
        m.gcd = value;
        m.countGCD = 1;
        st[index] = m;
        return;
    }
    int mid = (l + r) >> 1;
    if(target <= mid)    update(l, mid, target, value, index * 2);
    else    update(mid + 1, r, target, value, index * 2 + 1);
    
    st[index] = merge(st[index * 2], st[index * 2 + 1]);
}

Node query(int l, int r, int targetL, int targetR, int index){
    if(l > targetR || r < targetL){
        Node m;
        m.min = 9223372036854775807;
        m.gcd = 0;
        m.countGCD = 0;
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
        if(c == 'C'){
            cin >> a >> b;
            update(1, n, a, b, 1);
        }else if(c == 'M'){
            cin >> a >> b;
            cout << query(1, n, a, b, 1).min << endl;
        }else if(c == 'G'){
            cin >> a >> b;
            cout << query(1, n, a, b, 1).gcd << endl;
        }else{
            cin >> a >> b;
            cout << query(1, n, a, b, 1).countGCD << endl;
        }
    }

    return 0;
}
