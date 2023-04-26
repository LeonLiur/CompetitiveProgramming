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

const int MN = 0;
int n, score = 0, ammo = 0, opp_ammo = 0;
string s;

// lightning mcqueen kawchaw
int main()
{
    boost();

    cin >> n >> s;

    for(int i = 0; i < s.size(); i++){
        char act = s.at(i);
        if(act == 'B'){
            // reload
            ammo ++;
        }else if(act == 'F'){
            // block
            if(opp_ammo >= 1){
                opp_ammo --;
            // fire
            }else{
                if(ammo >= 1){
                    score ++;
                    ammo --;
                }else{
                    ammo ++;
                }
            }
        }else{
            // fire if ammo
            opp_ammo ++;
            if(ammo >= 1){
                score ++;
                ammo --;
            }else{
                ammo ++;
            }
        }
    }

    cout << score << endl;
    

    return 0;
}
