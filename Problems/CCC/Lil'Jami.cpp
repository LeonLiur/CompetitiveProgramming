#include <iostream>

using namespace std;

int N, K, Q, Ki;

int main()
{
    cin >> N >> K;
    int arr[N] = {0};
    int psa[N+1] = {0};

    for(int i = 0; i < K; i++){
        cin >> Ki;
        arr[Ki] += 1;
    }

    psa[0] = 0;
    
    for (int i = 1; i < N + 1; i++)
    {
        psa[i] = psa[i - 1] + arr[i - 1];
    }

    cin >> Q;
    for(int i = 0; i < Q; i++){
            int a, b;
            cin >> a >> b;

            cout << psa[b + 1] - psa[a] << endl;
        }
    return 0;
}