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
const int mini = ~maxi;

const int MN = 105;
int n, k, grid[MN][MN], pointer = 1, winner_count = 0, winning_score;
vector<pair<int, int>> scoreToNo;
vector<int> winners;

// lightning mcqueen kawchaw
int main()
{
    boost();

    cin >> n >> k;

    for(int i = 0; i < k; i++){
        for(int j = 0, a; j < n; j++){
            cin >> grid[i][j];
            if(i != 0)  grid[i][j] += grid[i - 1][j];
        }
    }

    for(int i = 0; i < n; i++){
        scoreToNo.pb(mp(grid[k - 1][i], i));
    }


    sort(scoreToNo.begin(), scoreToNo.end(), greater<>());

    winners.pb(scoreToNo[0].second);
    winning_score = scoreToNo[0].first;

    while(scoreToNo.size() > pointer && scoreToNo[pointer].first == winning_score){
        winners.pb(scoreToNo[pointer].second);
        pointer ++;
    }

    for(int i = winners.size() - 1; i >= 0; i--){
        int winner = winners[i];
        int worst_rank = -1;
        for(int i = 0; i < k; i++){
            int rank = 1;
            for(int j = 0; j < n; j++){
                if(grid[i][j] > grid[i][winner]){
                    rank += 1;
                }
            }
            worst_rank = max(worst_rank, rank);
        }
        cout << "Yodeller " << winner + 1 << " is the TopYodeller: score " << winning_score <<", worst rank " << worst_rank << endl;
    }

    

    return 0;
}
