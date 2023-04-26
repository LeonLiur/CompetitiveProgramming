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

const int MN = 5005;
const ll MOD = 1e9 + 7;
const ll X = 131;
int n, q;
string s;

set<ll> hs;

ll fpow(ll b, ll p){
    if(p == 0)  return 1;
    ll half = fpow(b, p >> 1);
    if((p & 1) == 0) return half * half;
    else    return half * half * b;
}

// lightning mcqueen kawchaw
int main()
{
    boost();

    cin >> n;
    
    string s;
    ll ans = 1;
    set<ll> setHash;

    while(n--){
        cin >> s;
        // iterating by size of subarray
        for(int i = 1; i <= s.size(); i++){
            // starting hash
            ll hsh = 0;
            for(int j = 0; j < i; j++){
                // cout << "aa" << i << " - " << j << endl;
                hsh = hsh * X + s.at(j);
            }

            setHash.insert(hsh);

            // iterating through starting points
            for(int j = i; j < s.size(); j++){
                // cout << "bb" << i << " - " << j << endl;
                hsh = hsh * X;
                hsh += s.at(j);
                hsh -= (s.at(j - i)) * fpow(X, i);
                setHash.insert(hsh);
            }

            // all the substrings are different
            if(setHash.size() == s.size() - i + 1){
                // cout << "skipping ahead" << endl;
                ans += setHash.size();

                ans += (setHash.size()) * (setHash.size() - 1) / 2;
                setHash.clear();
                break;
            }

            // cout << setHash.size();
            ans += setHash.size();
            setHash.clear();
        }

        cout << ans << endl;
        ans = 1;
    }


    return 0;
}
