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
int n;

set<string> strs;
string s, t;

// lightning mcqueen kawchaw
int main()
{
    boost();
    cin >> t >> s;

    for(int i = 0; i < s.size(); i++){
        // add here
        for(char c : t){
            strs.insert(s.substr(0, i) + c + s.substr(i, s.size() - i));
        }

        // change here
        for(char c : t){
            strs.insert(s.substr(0, i) + c + s.substr(i + 1, s.size() - i));
        }

        // remove here
        string n3 = s.substr(0, i) + s.substr(i + 1, s.size() - i);
        strs.insert(n3);
    }

    for(char c : t){
            strs.insert(s + c);
        }

    for(string st : strs){
        if(st.compare(s) == 0)  continue;
        cout << st << endl;
    }
    return 0;
}
