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

const int MN = 1e6;
ll n;
int l, llist[2001];
ll lengths[4005];

// lightning mcqueen kawchaw
int main()
{
    boost();

    cin >> n;
    for(int i = 0; i < n; i++){
        cin >> l;
        llist[l] ++;
    }

    int maxL = 0;
    int curMax = 0;

    for(int l1 = 1; l1 < 2001; l1++){
        for(int l2 = l1; l2 < 2001; l2++){
            if(l1 == l2){
                lengths[l1 + l2] += (llist[l1] >> 1);
            }else{
                lengths[l1 + l2] += min(llist[l1], llist[l2]);
            }
        }
    }
    
    maxL = *max_element(lengths, lengths + 4005);

    int counter = 0;
    for(int i = 0; i < 4005; i++){
        if(lengths[i] == maxL)  counter++;
    }

    cout << maxL << " " << counter << endl;

    return 0;
}
