#include <bits/stdc++.h>
// https://codeforces.com/contest/2178/problem/C

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

const int MN = 2e5 + 5;
int n, t;

ll a[MN], psa[MN], abs_psa[MN], largest_w = mini;

int main() {
    boost();
    cin >> t;
    while (t--) {
        cin >> n;
        for (int i = 0; i < n; i++) {
            cin >> a[i];
            psa[i] = (i > 0 ? psa[i - 1] : 0) + a[i];
            abs_psa[i] = (i > 0 ? abs_psa[i - 1] + abs(a[i]) : a[i]);
        }

        largest_w = -psa[n - 1] + a[0];

        for (int i = 1; i < n; i++){
            largest_w = max(largest_w, abs_psa[i - 1] + -(psa[n - 1] - psa[i]));
        }

        cout << largest_w << endl;
    }

    return 0;
}

// // lightning mcqueen kawchaw
// int main()
// {
//     boost();

//     cin >> t;

//     while(t--){
//         cin >> n;
//         for(int i = 0; i < n; i++)  cin >> a[i];

//         int remaining_children = n, first_index=0, second_index=1, first_h =
//         a[first_index], second_h = a[second_index]; ll x = 0;

//         while (remaining_children > 2){
//             if(first_h > 0){
//                 x += first_h;
//                 first_index = second_index;
//                 second_index = second_index + 1;
//             }else if (second_h < 0){
//                 x -= second_h;
//                 second_index = second_index + 1;
//             }else if(abs(first_index) > abs(second_index)){
//                 x -= second_h;
//                 second_index = second_index + 1;
//             }else{
//                 x += first_h;
//                 first_index = second_index;
//                 second_index = second_index + 1;
//             }
//             remaining_children -= 1;
//             first_h = a[first_index];
//             second_h = a[second_index];
//         }

//         x += max(first_h, -1 * second_h);

//         cout << x << endl;
//     }

//     return 0;
// }

// // Observation: we don't actually need to consider what's coming after the
// first two children,
// // because regardless of which one we remove, the third child becomes the
// second child
// // therefore should we not simply consider the first two?

// // First positive, second positive, first < second -> taking first is
// strictly better
// // first positive, second positive, first > second -> taking first is
// strictly better
// // first positive, second negative                 -> taking second is
// strictly better
// // first negative, second positive,                ->  |first| > |second|  ->
// take second
// //                                                     |first| < |second|  ->
// take first
// // first negative, second negative, first < second -> taking second is
// strictly better
// // first negative, second negative, first > second -> taking second is
// strictly better

// // 7 -6 -1 -8 -8
// // 7 -1 3 -8 5

// // 7 -6 -3 -8 -8 -5
// // second -> first -> second -> second -> second

// // 7 -6 -3 -10 -8 -5 1
// // second -> first -> second -> second -> second

// // 5 -10 -6 -1 -> 16 take second
// // 5 -10 -3 -8 -> 15 take first

// // first positive, second negative
// // 10 -5 -3    take second state transition -> 5 + (10 -3 same)
// // 10 -5 -8    take first state transition  -> 10 + (-5 -3 same)

// // let's say it's not possible to just look at the first 2 and we need future
// clues. could we just look at the first 3?

// // 10 -5 -3 take first -> end up with max(10 + (-5), 10 - (-3))
// // take second -> end up with max (-5 + 10, -5 - (-3))

// // DP state:
// // dp(i, j) = max(-a[j] + dp(i, j+1), a[i] + dp(j, j+1))
