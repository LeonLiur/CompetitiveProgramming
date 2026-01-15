#include <bits/stdc++.h>
// https://codeforces.com/contest/2178/problem/B

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

string s;

int main() {
    boost();
    cin >> t;
    while (t--) {
        cin >> s;
        bool left_side_s = s[0] == 's', right_side_s = false;
        int u_count = 0, needed = 0;

        // read left to right
        for (int i = 0; i < s.length(); i++) {
            char c = s.at(i);

            if (u_count > 0) {
                // if read u, increase u count
                if (c == 'u') {
                    u_count += 1;
                    right_side_s = false;
                }
                // if read s
                else {
                    right_side_s = true;
                    if (left_side_s) {
                        needed += u_count / 2;
                    } else {
                        needed += (u_count + 1) / 2;
                    }
                    // cout << "consumed " << u_count << "u's" << endl;
                    // cout << "new needed: " << needed << endl;

                    u_count = 0;
                    left_side_s = true;
                }
            } else {
                if (c == 'u') {
                    u_count += 1;
                    right_side_s = false;
                } else {
                    left_side_s = true;
                }
            }
        }

        if (!right_side_s && !left_side_s) {
            needed += (u_count / 2) + 1;
        } else if (!right_side_s) {
            needed += (u_count + 1) / 2;
        }

        cout << needed << endl;
    }

    return 0;
}

// ONE SIDED ODD: n / 2 + 1
// TWO SIDED ODD: n / 2

// ONE SIDED EVEN: n / 2
// TWO SIDED EVEN: n / 2

// Observe: EVERY u must be surrounded with two s
// u, su, us, sus               ->    change u into s
// uu, suu, uus, suus           ->
// uuu, suuu, uuus, suuus       ->
// uuuu, suuuu, uuuus, suuuus   ->

// su         -> 1
// us         -> 1
// sus        -> 0
// uu         -> 2
// suu        -> 1
// uus        -> 1
// suus       -> 2
// uuu        -> 2
// suuu       -> 2
// uuus       -> 2
// suuus      -> 1
// uuuu       -> 3
// suuuu      -> 2
// uuuus      -> 2
// suuuus     -> 2
// uuuuu      -> 3
// suuuuu     -> 3
// uuuuus     -> 3
// suuuuus    -> 2
