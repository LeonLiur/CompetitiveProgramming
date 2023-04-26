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

const int MN = 65540;
int n, head = 0, oc[MN], counter = 0, longestLen, longestStart, longestEnd;
vi seq;

// lightning mcqueen kawchaw
int main()
{
    boost();

    for(int i = 0; i < MN; i++){oc[i] = -1;}

    while(true){
        cin >> n;
        if(n == 0){
            int seqlen = counter - head;
            if(seqlen > longestLen){
                longestStart = head;
                longestEnd = counter - 1;
                longestLen = seqlen;
            }
            break;
        }

        seq.pb(n);
        if(oc[n] == -1){
            oc[n] = counter;
        }else{
            int seqlen = counter - head;
            if(seqlen > longestLen){
                longestStart = head;
                longestEnd = counter - 1;
                longestLen = seqlen;
            }

            head = max(head, oc[n] + 1);
            oc[n] = counter;
        }
        counter ++;
    }

    for(int i = longestStart; i <= longestEnd; i++){
        cout << seq[i] << endl;
    }
    

    return 0;
}
