#include <bits/stdc++.h>

using namespace std;

#define ll long long

ll fpow(ll b, ll p){
    if(p == 0)  return 1;
    ll half = fpow(b, p >> 1);
    if((b & 1) == 0)    return half * half;
    else    return half * half * b;
}

int main() {
    cin.tie(0), cin.sync_with_stdio(0);
    
    string s1, s2;
    cin >> s1 >> s2;
    
    long long hsh1 = 0, hsh2 = 0, X = 131, highestPow = fpow(X, s2.size() - 1);
    
    for(char x : s2)    hsh2 = hsh2 * X + x;
    
    for(int i = 0; i < s2.size(); i++){
        hsh1 = hsh1 * X + s1.at(i);
    }
    
    if(hsh1 == hsh2){
        cout << 0 << endl;
        return 0;
    }
    
    for(int i = s2.size(); i < s1.size(); i++){
        hsh1 = hsh1 * X + s1.at(i);
        hsh1 -= highestPow * s1.at(i - s2.size());
        
        if(hsh1 == hsh2){
            cout << i - s2.size() << endl;
            return 0;
        }
    }
    
    cout << -1 << endl;
    
    return 0;
}