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

const int MN = 2e5 + 5;
const ll MOD = 1e9 + 7;
int n;
ll teamA[MN], teamB[MN];
ll k, ans;

// lightning mcqueen kawchaw
int main()
{
    boost();

    cin >> n >> k;
    for(int i = 0; i < n; i++){
        cin >> teamA[i];
    }
    for(int i = 0; i < n; i++){
        cin >> teamB[i];
    }

    sort(teamA, teamA + n);
    sort(teamB, teamB + n);
    
    if(teamA[n - 1] < teamB[n - 1]){
        if(teamB[n - 1] - teamA[n - 1] < k){
            k -= (teamB[n - 1] - teamA[n - 1]);
            teamA[n - 1] = teamB[n - 1];
            if((k & 1) == 1){
                teamA[n - 1] += k >> 1;
                teamB[n - 1] += (k >> 1) + 1;
            }else{
                teamA[n - 1] += k >> 1;
                teamB[n - 1] += k >> 1;
            }
        }else{
            teamA[n - 1] += k;
        }
    }else if(teamB[n - 1] < teamA[n - 1]){
        if(teamA[n - 1] - teamB[n - 1] < k){
            k -= (teamA[n - 1] - teamB[n - 1]);
            teamB[n - 1] = teamA[n - 1];
            if((k & 1) == 1){
                teamA[n - 1] += k >> 1;
                teamB[n - 1] += (k >> 1) + 1;
            }else{
                teamA[n - 1] += k >> 1;
                teamB[n - 1] += k >> 1;
            }
        }else{
            teamB[n - 1] += k;
        }
    }else{
        if((k & 1) == 1){
                teamA[n - 1] += k >> 1;
                teamB[n - 1] += (k >> 1) + 1;
            }else{
                teamA[n - 1] += k >> 1;
                teamB[n - 1] += k >> 1;
            }
    }

    for(int i  = 0; i < n; i++){
        ll prod = teamA[i] * teamB[i] % MOD;
        ans += prod;
        ans %= MOD;
    }
    
    cout << ans << endl;

    return 0;
}
