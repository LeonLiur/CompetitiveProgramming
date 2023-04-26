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

const int MN = 1e6 + 5;
int n, digits[MN];
string s;

// lightning mcqueen kawchaw
int main()
{
    boost();

    cin >> n >> s;
    for(int i = 0; i < n; i++){
        digits[i] = s.at(i) - '0';
    }

    for(int i = 1; i < n; i++){
        if(digits[i] > digits[i - 1]){
            int buff = digits[i];
            digits[i] = digits[i - 1];
            digits[i - 1] = buff;
            break;
        }
    }

    for(int i = 0; i < n; i++){
        cout << digits[i];
    }
    

    return 0;
}
