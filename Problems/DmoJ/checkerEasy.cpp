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

const int MN = 3005;
int n, m, black[MN][MN], white[MN][MN], a, b, c, d;

// lightning mcqueen kawchaw
int main()
{
    boost();

    cin >> n >> m >> a >> b >> c;

    while(a != 0){
        if(((a + b) & 1 ) == 0){
            black[a][b] = c;
        }else{
            white[a][b] = c;
        }
        cin >> a >> b >> c;    
    }

    for(int i = 1; i <= n; i++){
        for(int j = 1; j <= m; j++){
            black[i][j] = black[i][j] + black[i - 1][j] + black[i][j-1] - black[i-1][j-1];
            white[i][j] = white[i][j] + white[i - 1][j] + white[i][j-1] - white[i-1][j-1];
        }
    }

    // for(int i = 1; i <= n; i++){
    //     for(int j = 1; j <= m; j++){
    //         cout << black[i][j] << endl;
    //         cout << white[i][j] << endl;
    //     }
    // }
    
    cin >> a >> b >> c >> d;

   
    while(a != 0){
        int blackSum = black[c][d] - black[a - 1][d] - black[c][b - 1] + black[a-1][b-1];
        int whiteSum = white[c][d] - white[a - 1][d] - white[c][b - 1] + white[a-1][b-1];

        if(((a + b) & 1 ) == 0){
            cout << blackSum - whiteSum << endl;    
        }else{
            cout << whiteSum - blackSum << endl;
        }
        cin >> a >> b >> c >> d;
    }
    


    return 0;
}
