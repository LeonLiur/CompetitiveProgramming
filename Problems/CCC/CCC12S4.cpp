#include <bits/stdc++.h>

using namespace std;

#define endl "\n"
#define mp make_pair
#define pb push_back
#define boost() cin.tie(0); cin.sync_with_stdio(0)
typedef long long ll;
typedef vector<int> vi;
typedef pair<int, int> pii;
typedef pair<ll, ll> pll;

const int maxi = 2147483647;
const int mini = -2147483647;

const int MN = 8;
const int expo[] = {1, 7, 128, 2187, 16384, 78125, 279936, 823543};
int n, start[MN];

struct state{
    vector<int> curBoard[MN];
    int moves;
    int id;

    state(vector<int> curBoard_[MN], int moves_, int id_){
        for(int i = 0; i < MN; i++){
            for(int j = 0; j < curBoard_[i].size(); j++){
                curBoard[i].pb(curBoard_[i][j]);
            }
        }
        moves = moves_;
        id = id_;
    }
};

set<int> visited;

bool checkEnd(vector<int> board[MN]){
    for(int i = 0; i < n; i++){
        if(board[i].empty() || board[i].size() != 1 || board[i][0] != i + 1)    return false;
    }
    return true;
}

int toID(vector<int> board[MN]){
    int res = 0;
        for (int i = 0; i < 8; i++) {
            for (int j : board[i]) {
                res += i * expo[j];
                // ret[j] = i;
            }
        }
        return res;
}

int bfs(){
    queue<state> q;

    vector<int> startBoard[MN];
    int resStart = 0;
    for(int i = 0; i < 8; i++){
        startBoard[i].pb(start[i]);
        resStart += i * expo[start[i]];
    }

    q.push(state(startBoard, 0, resStart));

    while(!q.empty()){
        state cur = q.front();
        q.pop();
        vector<int> curBoard[MN];
        for(int i = 0; i < MN; i++){
            for(int j = 0; j < cur.curBoard[i].size(); j++){
                curBoard[i].pb(cur.curBoard[i][j]);
            }
        }
        
        int curMoves = cur.moves;
        int id = cur.id;

        if(visited.contains(id))    continue;
        else    visited.insert(id);

        if(checkEnd(curBoard))    return curMoves;

        for(int i = 0; i < n; i++){
            if(curBoard[i].empty()) continue;
            if(i >= 1){
                int leftTop = curBoard[i - 1].size() - 1;
                int curTop = curBoard[i].size() - 1;

                if(curBoard[i - 1].empty()){
                    curBoard[i - 1].pb(curBoard[i][curTop]);
                    curBoard[i].erase(curBoard[i].begin() + curTop);
                    q.push(state(curBoard, curMoves + 1, toID(curBoard)));
                    leftTop++;
                    curTop--;
                    curBoard[i].pb(curBoard[i - 1][leftTop]);
                    curBoard[i-1].erase(curBoard[i - 1].begin() + leftTop);
                }
                else if(curBoard[i - 1][leftTop] > curBoard[i][curTop]){
                    curBoard[i - 1].pb(curBoard[i][curTop]);
                    curBoard[i].erase(curBoard[i].begin() + curTop);
                    q.push(state(curBoard, curMoves + 1, toID(curBoard)));
                    leftTop++;
                    curTop--;
                    curBoard[i].pb(curBoard[i - 1][leftTop]);
                    curBoard[i-1].erase(curBoard[i - 1].begin() + leftTop);
                }
            }
            if(i <= n - 2){
                int rightTop = curBoard[i + 1].size() - 1;
                int curTop = curBoard[i].size() - 1;

                if(curBoard[i + 1].empty()){
                    curBoard[i + 1].pb(curBoard[i][curTop]);
                    curBoard[i].erase(curBoard[i].begin() + curTop);
                    q.push(state(curBoard, curMoves + 1, toID(curBoard)));
                    rightTop++;
                    curTop--;
                    curBoard[i].pb(curBoard[i + 1][rightTop]);
                    curBoard[i + 1].erase(curBoard[i + 1].begin() + rightTop);
                }
                else if(curBoard[i + 1][rightTop] > curBoard[i][curTop]){
                    curBoard[i + 1].pb(curBoard[i][curTop]);
                    curBoard[i].erase(curBoard[i].begin() + curTop);
                    q.push(state(curBoard, curMoves + 1, toID(curBoard)));
                    rightTop++;
                    curTop--;
                    curBoard[i].pb(curBoard[i + 1][rightTop]);
                    curBoard[i + 1].erase(curBoard[i + 1].begin() + rightTop);
                }
            }
        }
    }
    return -1;
}

// lightning mcqueen kawchaw
int main()
{
    boost();
    while(1){
        cin >> n;
        if(n == 0)  break;
        for(int i = 0; i < n; i++){
            cin >> start[i];
        }
        
        int ans = bfs();
        if(ans == -1)   cout << "IMPOSSIBLE" << endl;
        else    cout << ans << endl;

        visited.clear();
    }
}
