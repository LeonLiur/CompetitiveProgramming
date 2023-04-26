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

const int MN = 1e5 + 5;
int t, res[MN], carry;
string a, b;
bool neg;
char arr[MN], brr[MN], rrr[MN];

// lightning mcqueen kawchaw
int main()
{
    boost();

    cin >> t;
    while(t--){
        cin >> a >> b;
        bool neg1 = a.at(0) == '-';
        bool neg2 = b.at(0) == '-';
        neg = neg1 ^ neg2;
        if(neg1) a = a.substr(1, a.size() - 1);
        if(neg2) b = b.substr(1, b.size() - 1);

        // cout << a.size() << " - " << b.size() << endl;

        if(a.size() > b.size()){
            for(int i = 0; i < a.size() - b.size(); i++){
                arr[max(a.size(), b.size()) - i - 1] = a.at(i);
                brr[max(a.size(), b.size()) - i - 1] = '0';
            }
            for(int i = 0; i < b.size(); i++){
                arr[max(a.size(), b.size()) - (a.size() - b.size() + i) - 1] = a.at(a.size() - b.size() + i);
                brr[max(a.size(), b.size()) - (a.size() - b.size() + i) - 1] = b.at(i);
            }
            
        }else if(a.size() < b.size()){
            for(int i = 0; i < b.size() - a.size(); i++){
                arr[max(a.size(), b.size()) - i - 1] = '0';
                brr[max(a.size(), b.size()) - i - 1] = b.at(i);
            }
            for(int i = 0; i < a.size(); i++){
                arr[max(a.size(), b.size()) - (b.size() - a.size() + i) - 1] = a.at(i);
                brr[max(a.size(), b.size()) - (b.size() - a.size() + i) - 1] = b.at(b.size() - a.size() + i);
            }
            
        }else{
            for(int i = 0; i < a.size(); i++){
                arr[max(a.size(), b.size()) - i - 1] = a.at(i);
                brr[max(a.size(), b.size()) - i - 1] = b.at(i);
            }
        }

        for(int i = 0; i < max(a.size(), b.size()); i++){
            res[i] = arr[i] - '0' + brr[i] - '0' + carry;
            string s = to_string(res[i]);
            if(s.size() == 1){
                rrr[i] = s.at(0);
                carry = 0;
            }else{
                rrr[i] = s.at(1);
                carry = 1;
            }
        }

        if(carry == 1)  rrr[max(a.size(), b.size())] = '1';


        // for(int i = 0; i < max(a.size(), b.size()); i++){
        //     cout << arr[i];
        // }
        // cout << endl;

        // for(int i = 0; i < max(a.size(), b.size()); i++){
        //     cout << brr[i];
        // }
        // cout << endl;

        if(neg) cout << "-";
        if(rrr[max(a.size(), b.size())] == '1') cout << "1";

        for(int i = 0; i < max(a.size(), b.size()); i++){
            cout << rrr[max(a.size(), b.size()) - 1 - i];
        }
        
        cout << endl;

    }

    return 0;
}
