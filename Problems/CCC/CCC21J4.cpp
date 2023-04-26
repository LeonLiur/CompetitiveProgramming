// #include <bits/stdc++.h>

// using namespace std;

// int main() {
//     string s;
//     cin >> s;
    
//     int pfL[5000005];
//     int pfM[5000005];
//     int pfS[5000005];
    
//     if(s.at(0) == 'L'){
//         pfL[1] = 1;
//         pfM[1] = 0;
//         pfS[1] = 0;
//     }
//     if(s.at(0) == 'M'){
//         pfL[1] = 0;
//         pfM[1] = 1;
//         pfS[1] = 0;
//     }
//     if(s.at(0) == 'S'){
//         pfL[1] = 0;
//         pfM[1] = 0;
//         pfS[1] = 1;
//     }
    
//     for(int i = 1; i < s.length();i++){
//         if(s.at(i) == 'L'){
//         pfL[i + 1] = 1;
//         pfM[i + 1] = 0;
//         pfS[i + 1] = 0;
//         }
//         if(s.at(i) == 'M'){
//             pfL[i + 1] = 0;
//             pfM[i + 1] = 1;
//             pfS[i + 1] = 0;
//         }
//         if(s.at(i) == 'S'){
//             pfL[i + 1] = 0;
//             pfM[i + 1] = 0;
//             pfS[i + 1] = 1;
//         }
//     }
    
//     int lEnd, mEnd;
//     lEnd = pfL[s.length()];
//     mEnd = lEnd + pfM[s.length()];
    
//     cout << pfM[lEnd] + pfS[lEnd] + (pfL[mEnd] - pfL[lEnd - 1]) + (pfS[mEnd] - pfS[lEnd - 1]) - min(pfM[lEnd], (pfL[mEnd] - pfL[lEnd - 1])) << endl;
//     return 0;
// }