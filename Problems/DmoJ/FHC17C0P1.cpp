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
int n;
string res;
double p, x, y;

// lightning mcqueen kawchaw
int main()
{
    boost();

    cin >> n;

    for(int i = 1; i <= n; i++){
        cin >> p >> x >> y;
        double dis = sqrt((x-50)*(x-50) + (y-50)*(y-50));
        if(p==0){
            cout << "Case #" << i << ": " << "white" << endl;
        }
        else if(p <= 25){
            if(x <= 50 + dis*sin(p/100*2*M_PI) && y>= 50 + dis*cos(p/100*2*M_PI)){
                res = "black";
            }else{
                res = "white";
            }

            cout << "Case #" << i << ": " << res << endl;
        }else if(p <= 50){
            if(x >= 50 + dis*sin(p/100*2*M_PI) && y>= 50 + dis*cos(p/100*2*M_PI)){
                res = "black";
            }else{
                res = "white";
            }

            cout << "Case #" << i << ": " << res << endl;
        }else if(p <= 75){
            if(x >= 50 + dis*sin(p/100*2*M_PI) && y<= 50 + dis*cos(p/100*2*M_PI)){
                res = "black";
            }else{
                res = "white";
            }

            cout << "Case #" << i << ": " << res << endl;
        }else{
            if(x <= 50 + dis*sin(p/100*2*M_PI) && y<= 50 + dis*cos(p/100*2*M_PI)){
                res = "black";
            }else{
                res = "white";
            }

            cout << "Case #" << i << ": " << res << endl;
        }
       
    }
    

    return 0;
}
