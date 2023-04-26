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

struct step{
    step(int x_, int y_, ll value_, int stepsTaken_){
        x = x_;
        y = y_;
        value = value_;
        stepsTaken = stepsTaken_;
    }
    int x, y, stepsTaken;
    ll value;
};

struct compare{
    bool operator()(step const& p1, step const& p2){
        return p1.value > p2.value;
    }
};

const int MN = 1505;
int n, m, k;
ll OGgrid[MN][MN];
pair<ll, int> grid[MN][MN];
bool visited[MN][MN];
ll a;
priority_queue<step, vector<step>, compare> pq;
queue<step> q;

void bfs(){
    while(!q.empty()){
        step cur = q.front();
        q.pop();

        // cout << cur.value << endl;

        if(cur.stepsTaken > k)  continue;
        if(OGgrid[cur.x][cur.y] == 0 || cur.stepsTaken == 0){
            if(grid[cur.x][cur.y].second > cur.stepsTaken){
                grid[cur.x][cur.y].second = cur.stepsTaken;
                grid[cur.x][cur.y].first = cur.value;
            }else if(grid[cur.x][cur.y].second == cur.stepsTaken && grid[cur.x][cur.y].first > cur.value){
                grid[cur.x][cur.y].first = cur.value;
            }
        

            if(visited[cur.x][cur.y])   continue;
            visited[cur.x][cur.y] = true;

            if(cur.x + 1 <= n - 1){
                q.push(step(cur.x + 1, cur.y, cur.value, cur.stepsTaken + 1));
                // cout << "a" << endl;
            }
            if(cur.x - 1 >= 0){
                q.push(step(cur.x - 1, cur.y, cur.value, cur.stepsTaken + 1));
                // cout << "b" << endl;
            }
            if(cur.y + 1 <= m - 1){
                q.push(step(cur.x, cur.y + 1, cur.value, cur.stepsTaken + 1));
                // cout << "c" << endl;
            }
            if(cur.y - 1 >= 0){
                q.push(step(cur.x, cur.y - 1, cur.value, cur.stepsTaken + 1));
                // cout << "d" << endl;
            }
        }
    }    
}

// lightning mcqueen kawchaw
int main()
{
    boost();

    cin >> n >> m >> k;

    for(int i = 0; i < n; i++){
        for(int j = 0; j < m; j++){
            cin >> a;
            OGgrid[i][j] = a;
            grid[i][j] = mp(a, maxi);
            if(a == 0)  grid[i][j].first = LLONG_MAX;
        }
    }

    for(int i = 0; i < n; i++){
        for(int j = 0; j < m; j++){
            if(OGgrid[i][j] == 0)   continue;
            pq.push(step(i, j, OGgrid[i][j], 0));
        }
    }

    while(!pq.empty()){
        step cur = pq.top();
        pq.pop();
        q.push(cur);
    }

    bfs();

    for(int i = 0; i < n; i++){
        for(int j = 0; j < m; j++){
            cout << (grid[i][j].first==LLONG_MAX?0:grid[i][j].first) << " ";
        }
        cout << endl;
    }
    

    return 0;
}