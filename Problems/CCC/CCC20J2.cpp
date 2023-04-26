#include <iostream>

using namespace std;

int P, N, R;

int main()
{
    cin >> P >> N >> R;
    int infected = N;
    int old_infected = N;
    int day = 0;

    while(infected <= P){
        day ++;
        infected += old_infected * R;
        old_infected *= R;
    }
    cout << day << endl;
    return 0;
}