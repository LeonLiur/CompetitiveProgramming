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
int t, n, k;
string s;

bool checksym(string s){
    for(int i = 0; i < s.size() / 2; i++){
        if(s.at(i) != s.at(s.size() - 1 - i))   return false;
    }

    return true;
}

// lightning mcqueen kawchaw
int main()
{
    boost();

    cin >> t;
    while(t--){
        cin >> n >> k >> s;
        if(k == 0){
            cout << 1 << endl;
            continue;
        }else{
            if(checksym(s)){
                cout << 1 << endl;
            }else{
                cout << 2 << endl;
            }
        }
    }
    

    return 0;
}
