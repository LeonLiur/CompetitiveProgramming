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

const int MN = 1005;
int n, m;
char grid[MN][MN];

// lightning mcqueen kawchaw
int main()
{
    boost();

    cin >> n >> m;
    
    for(int i = 1; i <= n; i++){
        for(int j = 1; j <= m; j++){
            cin >> grid[i][j];
        }
    }

    for(int i = 1; i <= n; i++){
        for(int j = 1; j <= m; j++){
            if(grid[i][j] == 'W'){
                grid[i - 1][j] = grid[i - 1][j] == 'W'? 'W': 'C';
                grid[i + 1][j] = grid[i + 1][j] == 'W'? 'W': 'C';
                grid[i][j - 1] = grid[i][j - 1] == 'W'? 'W': 'C';
                grid[i][j + 1] = grid[i][j + 1] == 'W'? 'W': 'C';
            }
        }
    }

    for(int i = 1; i <= n; i++){
        for(int j = 1; j <= m; j++){
            cout << grid[i][j];
        }
        cout << endl;
    }

    return 0;
}
