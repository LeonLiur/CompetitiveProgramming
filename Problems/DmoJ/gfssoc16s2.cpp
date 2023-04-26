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
ll a, b, ans = 0;
string hex_a, hex_b;

void find(int counter, int zero_flag) {
    char a_coi = hex_a.at(counter);
    char b_coi = hex_b.at(counter);

    int va, vb;
    // va is the decimal value
    if (a_coi <= '9') {
        va = a_coi - '0';
    } else {
        va = a_coi - 'a' + 10;
    }
    if (b_coi <= '9') {
        vb = b_coi - '0';
    } else {
        vb = b_coi - 'a' + 10;
    }

    int count = 0;

    if(counter != hex_a.size() - 1){
        if (va < 14 && vb > 14) count++;
        if (va < 12 && vb > 12) count++;
        if (va < 10 && vb > 10) count++;
        if (va == 0 && zero_flag == 0) count++;
        ans += count * pow(3, hex_a.size() - 1 - counter);
        cout << "va: " << va << "|vb: " << vb << "|count: " << count << endl;
    }else{
        if (va <= 14 && vb >= 14) count++;
        if (va <= 12 && vb >= 12) count++;
        if (va <= 10 && vb >= 10) count++;
        if (va == 0 && zero_flag == 0) count++;
        ans += count * pow(3, hex_a.size() - 1 - counter);
        cout << "va: " << va << "|vb: " << vb << "|count: " << count << endl;
    }


    if (((va == 0 && zero_flag == 0) || va == 10 || va == 12 || va == 14) && counter + 1 < hex_a.size()) {
        find(counter + 1, max(zero_flag, va));
    } 
    else if ((vb == 10 || vb == 12 || vb == 14) && counter + 1 < hex_a.size()) {
        find(counter + 1, max(zero_flag, va));
    }

    return;
}

// lightning mcqueen kawchaw
int main() {
    boost();

    cin >> a >> b;

    stringstream stm;
    stm << hex << a;
    string ha(stm.str());
    stringstream stm2;
    stm2 << hex << b;
    string hb(stm2.str());

    hex_a = ha;
    hex_b = hb;

    int a_len = hex_a.size();
    int b_len = hex_b.size();

    if (a_len < b_len) {
        hex_a = string(b_len - a_len, '0') + hex_a;
    }

    find(0, 0);

    cout << ans << endl;

    return 0;
}
