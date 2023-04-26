#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
#include <map>
#include <unordered_map>
#include <stack>
#include <queue>
#include <deque>

using namespace std;
#define read(type) readInt<type>() // Fast read
#define ll long long
#define nL "\n"
#define pb push_back
#define mk make_pair
#define pii pair<int, int>
#define a first
#define b second
#define vi vector<int>
#define all(x) (x).begin(), (x).end()
#define umap unordered_map
#define uset unordered_set
#define MOD 1000000007
#define imax INT_MAX
#define imin INT_MIN
#define exp 1e9
#define sz(x) (int((x).size()))


/** END OF TEMPLATE**/
int32_t main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);


    int n, t, a, b, pointsA = 0, pointsB = 0;
    int lastSpray[8];
    fill(lastSpray, lastSpray + 8, 0);
    cin >> n;

    for(int i = 0; i < n; i++){
        cin >> t >> a >> b;
        if(a >= 1 && a <= 4){
            int add = lastSpray[a-1] == 0?100:t - lastSpray[a - 1] > 10?100:150;
            pointsA += add;
            // cout << "added " << add;
            lastSpray[a - 1] = t;
        }else{
            int add = lastSpray[a-1] == 0?100:t - lastSpray[a - 1] > 10?100:150;
            pointsB += add;
            // cout << "added " << add;
            lastSpray[a - 1] = t;
        }
    }

    cout << pointsA << " " << pointsB << endl;

    return 0;
} 

