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

const int TEAMS = 4;
const int TOTALGAMES = 6;
int n, scoresa[TEAMS + 1], T, G;
bool playeda[TEAMS + 1][TEAMS + 1];
int ans;
set<string> setstr;

bool favWin(int scores[5]){
    int max = mini;
    int maxInd = -1;
    string s = "";
    for(int i = 1; i < 5; i++){
        s += scores[i];
        if(scores[i] > max){
            max = scores[i];
            maxInd = i;
        }
    }

    if(max == scores[T]){
        for(int i = 1; i < 5; i++){
            if(scores[i] == max && i != maxInd){
                return false;
            }
        }

        if(setstr.contains(s))  return false;
        setstr.insert(s);

        return true;
    }else{
        return false;
    }
}

void dfs(int gamesPlayed, bool played[5][5], int scores[5]){
    // cout << gamesPlayed << endl;
    // for(int x : scores) cout << x << " ";
    // cout << endl << "-----" << endl;
    if(gamesPlayed == TOTALGAMES){
        if(favWin(scores)){
            ans += 1;
        }

        return;
    }
    for(int team1 = 1; team1 < 5; team1++){
        for(int team2 = team1 + 1; team2 < 5; team2++){
            if(played[team1][team2])  continue;
            played[team1][team2] = true;
            played[team2][team1] = true;

            scores[team1] += 3;
            dfs(gamesPlayed + 1, played, scores);
            scores[team1] -= 3;
            scores[team2] += 3;
            dfs(gamesPlayed + 1, played, scores);
            scores[team2] -= 3;
            scores[team2] += 1;
            scores[team1] += 1;
            dfs(gamesPlayed + 1, played, scores);
            scores[team1] -= 1;
            scores[team2] -= 1;
            
            played[team1][team2] = false;
            played[team2][team1] = false;
        }
    }
}

// lightning mcqueen kawchaw
int main()
{
    boost();

    cin >> T >> G;
    for(int i = 0, a, b, c, d; i < G; i++){
        cin >> a >> b >> c >> d;
        playeda[a][b] = true;
        playeda[b][a] = true;
        if(c == d){
            scoresa[a] += 1;
            scoresa[b] += 1;
        }else if(c < d){
            scoresa[b] += 3;
        }else{
            scoresa[a] += 3;
        }
    }

    dfs(G, playeda, scoresa);
    cout << ans << endl;

    return 0;
}
