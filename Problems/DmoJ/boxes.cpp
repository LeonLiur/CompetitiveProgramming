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
    int n, a, b, pre, ans;
    vector<pii> v;

    // lightning mcqueen kawchaw
    int main()
    {
        boost();

        cin >> n;
        for(int i = 0; i < n; i++){
            cin >> a >> b;
            v.pb(mp(a, b));
        }
        sort(v.begin(), v.end(), greater <>());
        pre = v[0].first;
        ans = v[0].second;
        for(int i = 1; i < n; i++){
            ans += v[i].first < pre?v[i].second:0;
            pre = v[i].first;
        }

        cout << ans << endl;

        return 0;
    }
