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
    ll N, L, S;

    cin >> N >> L >> S;

    vector<pair<long, long> > used;
    umap<long, long> mapping;
    ll ind = 0;
    
    ll da[2 * N + 5];

    fill(da, da + (2*N + 5), 0);
    
    used.push_back(make_pair(0, 0));
    used.push_back(make_pair(L, 0));

    for(long i = 0; i < N; i ++){
        ll m, n, q;
        cin >> m >> n >> q;

        used.push_back(make_pair(m, q));
        used.push_back(make_pair(n + 1, - q));
    }
    sort(used.begin(), used.end());
    
    ll arr[2 * N + 2];

    for(ll i = 0; i < used.size(); i++){
        if(!mapping[used[i].first]){
            mapping[used[i].first] = ind;
            arr[ind] = used[i].first;
            ind += 1;
        }

        da[mapping[used[i].first]] += used[i].second;
        // cout << da[i] << "\t";
    
    }
    ll norm[2 * N + 5];

    norm[0] = da[0];
    ll count = 0;

    for(ll i = 1; i < ind; i++){


        norm[i] = da[i] + norm[i-1];
        count += norm[i - 1] >= S?0:arr[i] - arr[i - 1];
    }


    cout  << count << endl;

    return 0;
} 

