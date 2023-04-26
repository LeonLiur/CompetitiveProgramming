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

const int MN = 1049000;
int n, m, q, a, b;
ll arr[MN], wins[MN];
pair<ll, int> st[MN * 4];

void build(int l, int r, int index){
    if(l == r){
        st[index] = mp(arr[l], l);
        return;
    }

    int mid = (l + r) >> 1;
    build(l, mid, index * 2);
    build(mid + 1, r, index * 2 + 1);
    
    st[index] = max(st[index * 2], st[index * 2 + 1]);
    wins[st[index].second]++;
}

void update(int l, int r, int target, int value, int index){
    if(l == r){
        st[index] = mp(value, l);
        return;
    }
    
    int mid = (l + r) >> 1;
    if(target <= mid){
        update(l, mid, target, value, index * 2);
    }else{
        update(mid + 1, r, target, value, index * 2 + 1);
    }

    pair<ll, int> better = max(st[index * 2], st[index * 2 + 1]);
    if(better.second != st[index].second){
        wins[st[index].second] -= 1;
        wins[better.second] += 1;
    }
    st[index] = better;
}

pair<int, ll> maxQuery(int l, int r, int targetL, int targetR, int index){
    if(l > targetR || r < targetL)  return mp(-1, -1);
    if(l >= targetL && r <= targetR)    return st[index];

    // case 3
    int mid = (l + r) >> 1;
    pair<int, ll> left_max = maxQuery(l, mid, targetL, targetR, index * 2);
    pair<int, ll> right_max = maxQuery(mid + 1, r, targetL, targetR, index * 2 + 1);

    return max(left_max, right_max);
}

int dfs(int cur, int without, int i){
    if(without == m + 1){
        return 0;
    }
    if(st[cur].second == i){
        return m - without;
    }
    return dfs(cur * 2, without + 1, i) + dfs(cur * 2 + 1, without + 1, i);
}

// lightning mcqueen kawchaw
int main()
{
    boost();

    cin >> m >> q;
    n = 1 << m;

    for(int i = 1; i <= n; i++){
        cin >> arr[i];
    }

    build(1, n, 1);

    // for(int i = 1; i <= n; i++){
    //     cout << st[i].first << " | " << st[i].second << endl;
    // }
    
    while(q--){
        char c;
        cin >> c;
        if(c == 'R'){
            cin >> a >> b;
            update(1, n, a, b, 1);

            // for(int i = 1; i <= n; i++){
            //     cout << st[i].first << " | " << st[i].second << endl;
            // }

        }else if(c == 'W'){
            cout << maxQuery(1, n, 1, n, 1).second << endl;
        }else{
            cin >> a;
            cout << wins[a] << endl;
        }
    }

    return 0;
}
