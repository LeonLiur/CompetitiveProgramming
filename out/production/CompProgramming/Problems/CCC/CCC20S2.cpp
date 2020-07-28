#include <iostream>
#include <vector>
#include <queue>
#include <map>

using namespace std;

class Cell
{
public:
    int r;
    int c;

    Cell(int aR, int aC)
    {
        r = aR;
        c = aC;
    };

    Cell()
    {

    };
};

bool visited[1000][1000];
vector<vector<Cell>> vals(1000000);

string isPossible(Cell last_cell)
{
    queue<Cell> q;
    q.push(last_cell);
    while (!q.empty())
    {
        Cell cur = q.front();
        q.pop();
        vector<Cell> accessible = vals[cur.c * cur.r];
        for (Cell cell : accessible)
        {
            if (cell.c == 1 && cell.r == 1)
            {
                return "yes";
            }
            else if (!visited[cell.c - 1][cell.r - 1])
            {
                q.push(cell);
                visited[cell.c - 1][cell.r - 1] = true;
            }
        }
     
    }
       return "no";
}

int main()
{
    int m, n;
    cin >> m >> n;
    Cell last_cell;
    for (int i = 1; i < m + 1; i++)
    {
        for (int j = 1; j < n + 1; j++)
        {
            int val;
            cin >> val;
            Cell cell(i, j);
            vals[val].push_back(cell);

            if(i == m && j == n){
                last_cell = cell;
            }
        }
    }

    cout << isPossible(last_cell) << endl;

    return 0;
}
