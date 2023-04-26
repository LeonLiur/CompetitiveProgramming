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

struct sandwich{
    int start, end, length, value;
    sandwich(int start_, int end_, int length_, bool normal){
        start = start_;
        end = end_;
        length = length_;
        if(normal)  value = findVal();
        else    value = end_ - start_ + 1;
    }
    int findVal(){
        if((end - start) % 2 == 1)          return ((end - start) >> 1) + 1;
        else return (end - start) >> 1;
    }
};

bool comp(sandwich a, sandwich b){
    return a.value > b.value;
}

const int MN = 1e6 + 5;
int n, k;
string s;
vector<int> ones;
vector<sandwich> subway;
bool used[MN];

// lightning mcqueen kawchaw
int main()
{
    boost();

    cin >> n >> k >> s;
    for(int i = 0; i < n; i++){
        if(s.at(i) == '1')    ones.pb(i);
    }

    // for(int one : ones){
    //     cout << one << endl;
    // }
    
    // count corner cases after
    if(ones[0] != 0)    subway.pb(sandwich(0, ones[0] - 1, ones[0], false));
    if(ones[0] != ones[1] - 1) subway.pb(sandwich(0, ones[1] - 1, ones[1], true));

    for(int i = 2; i < ones.size(); i++){
        if(ones[i - 2] + 1 == ones[i - 1] && ones[i] - 1 == ones[i - 1])    continue;
        subway.pb(sandwich(ones[i - 2] + 1, ones[i] - 1, ones[i] - 1 - ones[i - 2] - 1, true));
    }
    subway.pb(sandwich(ones[ones.size() - 2] + 1, s.size() - 1, s.size() - 1 - ones[ones.size() - 2] + 1, true));
    subway.pb(sandwich(ones[ones.size() - 1] + 1, s.size() - 1, s.size() - 1 - ones[ones.size() - 1] + 1, false));
    

    sort(subway.begin(), subway.end(), comp);

    for(sandwich s : subway){
        cout << "start: " << s.start << " | end: " << s.end << " | value: " << s.value << endl;
    }

    ll ans = 0;
    int counted = 0;
    int counter = 0;

    while(counted < k){
        sandwich cur = subway[counter];
        counter++;
        if(!used[cur.start] && !used[cur.end]){
            for(int i = cur.start; i <= cur.end; i++) used[i] = true;
            cout << "TAKEN: start: " << cur.start << " | end: " << cur.end << " | value: " << cur.value << endl;

            ans += cur.value;
            counted += 1;
        }
    }

    cout << ans << endl;

    return 0;
}
