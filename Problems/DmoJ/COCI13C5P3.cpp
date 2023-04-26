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

const int MN = 1e6+5;
string s1, tnt;
deque<char> stk;

// lightning mcqueen kawchaw
int main()
{
    boost();

    cin >> s1 >> tnt;
    for(int i = 0; i < s1.size(); i++){
        stk.pb(s1[i]);
        bool flag = true;
        if(stk.size() >= tnt.size()){
            for(int i = stk.size() - tnt.size(), j = 0; j < tnt.size(); i++, j++){
                if(stk[i] != tnt[j])    {flag = false; break;}
            }
            if(flag){
                for(int i = 0; i < tnt.size(); i++)   stk.pop_back();
            }
        }
    }
    if(stk.empty()) cout << "FRULA";
    else for(int i = 0; i < stk.size(); i++)    cout << stk[i];

    cout << endl;

    return 0;
}
