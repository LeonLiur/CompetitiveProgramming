#include <bits/stdc++.h>

using namespace std;

#define endl "\n"
#define mp make_pair
#define pb push_back
#define boost() cin.tie(0), cin.sync_with_stdio(0);
typedef long long ll;
typedef vector<int> vi;
typedef pair<int, int> pii;
typedef pair<ll, ll> pll;

const int maxi = 2147483647;
const int mini = -2147483647;

const int MN = 10005, MK = 15;
int n, q, k;
bool cor[MK];
bool active[MK];

// lightning mcqueen kawchaw
int main()
{
    boost();

    for(int i = 0; i < MK; i++) active[i] = 0;

    cin >> n >> k;

    if(n == 1){
        cout << k << endl;
        return 0;
    }

    int counter = 0;

    for(int i = 0; i < n; i++){
        string s;
        cin >> s;
        for(int j = 0; j < k; j++){
            if(i == 0){
                cor[j] = s.at(j) == 'T';
                continue;
            }
            if(active[j])   continue;
            bool x = s.at(j) == 'T';
            if((x ^ cor[j]) == 1) counter++, active[j] = true;
        }
    }
    
    cout << k - counter << endl;

    return 0;
}
