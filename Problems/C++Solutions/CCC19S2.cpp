#include <iostream>
#include <vector>
#include <cmath>

using namespace std;
bool isPrime(int toTest);

int main()
{
    int n, q;
    cin >> n;
    for (int i = 0; i < n; i++)
    {
        cin >> q;
        for (int j = 3; j <= q; j++)
        {
            if (isPrime(j) && isPrime(2*q - j)){
                cout << j << endl;
                break;
            }
        }
    }
    return 0;
}

bool isPrime(int toTest)
{
    for (int i = 0; i < floor(sqrt(toTest)) + 1; i++)
    {
        if (toTest % i == 0)
        {
            return false;
        }
    }

    return true;
}