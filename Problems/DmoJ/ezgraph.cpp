#include <bits/stdc++.h>

using namespace std;
#define read(type) readInt<type>() // Fast read
#define ll long long
#define nL "\n"
#define pb push_back
#define mk make_pair
#define pii pair<int, int>
#define vi vector<int>
#define all(x) (x).begin(), (x).end()
#define umap unordered_map
#define uset unordered_set
#define MOD 1000000007
#define imax INT_MAX
#define imin INT_MIN


/** END OF TEMPLATE**/
int32_t main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    int n, q, t, a, b, c;
    cin >> n >> q;
    vector<pair<int, int> > adj[n + 1];
    int power[n + 1];

    for(int i = 0; i < n; i++)  cin >> power[i];

    for(int i = 0; i < q; i++){
        cin >> t;
        if(t == 1){
            cin >> a >> b;
            adj[a].push_back(make_pair(b, power[b]));
            adj[b].push_back(make_pair(a, power[a]));
        }else if(t == 2){
            cin >> a;
            cout << "QUERY 2: " << adj[a].size() + 1 << endl;
        }else{
            cin >> a;
            int sum = power[a];
            for(int j = 0; j < adj[a].size(); j++){
                sum += adj[a].at(j).second;
                // cout << "adding " << adj[a].at(j).second << " ";
            }
            cout << "QUERY 3: " << sum << endl;
        }
    }

    for(int i = 0; i < n + 1; i++){
        cout << "[";
        for(int j = 0; j < adj[i].size(); j++){
            cout << "(" << adj[i].at(j).first << "," << adj[i].at(j).second << "), ";
        }
        cout << "]" << endl;
    }

    return 0;
} 

