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
template<class C, typename T>
bool contains(C&& c, T e) { return find(begin(c), end(c), e) != end(c); };

const int maxi = 2147483647;
const int mini = ~maxi;

const int MN = 1e5 + 5;

int n, t;
int fibs[20];

// lightning mcqueen kawchaw
int main()
{
    boost();

    fib();

    cin >> t;

    while(t--){
        cin >> n;
        if(to_string(n).size() == 1){
            cout << "NO" << endl;
        }else if(to_string(n).size() == 2){
            if(contains(fibs, n / 10) && contains(fibs, n % 10)){
                cout << "YES" << endl;
            }else{
                cout << "NO" << endl;
            }
        }else if(to_string(n).size() == 3){
            if(contains(fibs, n / 100) && contains(fibs, n % 10)){
                cout << "YES" << endl;
            }else{
                cout << "NO" << endl;
            }
        }else if (to_string(n).size() == 4){

        }else if (to_string(n).size() == 5){

        }else{
            cout << "YES" << endl;
        }
    }


    return 0;
}

// compute fib
void fib()
{
    fibs[0] = 0;
    fibs[1] = 1;
    for(int i = 2; i < 20; i++){
        fibs[n] = fibs[n - 2] + fibs[n - 1];
    }
}

// make a method, given an array of numbers, tell if they are all prime
int check(int* arr)
{

}