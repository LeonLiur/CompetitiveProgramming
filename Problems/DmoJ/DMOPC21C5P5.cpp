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

const int MN = 0;
int n, valBest, valCur;

vi best_perm, cur_perm, base;
set<int> primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 69, 71, 73, 79, 83, 89, 97};

void value(){
    for(int i = 1; i < n; i++){
        if(primes.contains(abs(best_perm[i] - best_perm[i - 1]))){
            valBest += abs(best_perm[i] - best_perm[i - 1]);
        }
        if(primes.contains(abs(cur_perm[i] - cur_perm[i - 1]))){
            valCur += abs(cur_perm[i] - cur_perm[i - 1]);
        }
    }

}

// lightning mcqueen kawchaw
int main()
{
    boost();

    cin >> n;
    for(int i = 1; i <= n; i++) base.pb(i);

    
    

    return 0;
}
