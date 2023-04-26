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

const int MN = 1e5+5;
int n, q, t;
bool isPrime[MN];
bool dp[MN];
int heights[MN];
vi primes;

// precompute prime array
void preComp(){
    memset(isPrime, 1, sizeof(isPrime));
    isPrime[0] = 0;
    isPrime[1] = 0;
    for(int i = 2; i < sqrt(MN - 4); i++){
        if(isPrime[i]){
            for(int j = i * i; j < MN - 5; j+= i){
                isPrime[j] = 0;
            }
        }
    }

    for(int i = 1; i<= MN - 5; i++){
        heights[i] = i;
        if(isPrime[i])  primes.pb(i);
    }
}

void checkDP(){
    dp[1] = 0;
    for(int i = 2; i <= MN - 4; i++){
        // jump from i to j
        for(int j : primes){
            int neww = i - j;
            if(neww <= 0)    break;
            if(heights[neww] >= heights[i]) continue;

            if(!dp[neww]){
                dp[i] = 1;
                // cout << "setting " << i << " as winnable with " << neww << " as new" << endl;
                break;
            }
        }
    }

    // cout << "dp: ";
    // for(int i = 1; i <= 10; i++) cout << dp[1] << " ";
    // cout << endl;
}

// lightning mcqueen kawchaw
int main()
{
    boost();

    preComp();
    checkDP();
    cin >> t;
    while(t--){
        cin >> n;
        if(n <= 2){
            cout << -1 << endl;
            continue;
        }
        for(int i = 1; i <= n; i++){
            heights[i] = i;
        }


        if(dp[n]){
            for(int i = 1; i < n; i++){
                cout << heights[i] << " ";
            }
            
            cout << heights[n] << endl;
        }else{

            heights[n - 1] = n;
            heights[n] = n - 1;

            if(dp[n - 1]){
                for(int i = 1; i < n; i++){
                    cout << heights[i] << " ";
                }
                
                cout << heights[n] << endl;
            }else{
                for(int i = 1; i <= n; i++){
                    if(i == n - 2){
                        cout << n << " ";
                    }else if(i == n - 1){
                        cout << n - 2 << " ";
                    }else if(i == n){
                        cout << n - 1 << endl;
                    }else{
                        cout << i << " ";
                    }
                }
            }
        }
        // memset(dp, 0, MN);
    }


    return 0;
}