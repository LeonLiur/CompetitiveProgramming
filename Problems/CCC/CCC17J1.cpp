#include <iostream>

using namespace std;

int main()
{
int n,m;
cin >> n >> m;
if(n > 0){
    if(m > 0){
    cout << 1 << endl;
    }else{
    cout << 4 << endl;
    }
}else{
    if(m > 0){
    cout << 2 << endl;
    }else{
    cout << 3 << endl;
    }
}
return 0;
}