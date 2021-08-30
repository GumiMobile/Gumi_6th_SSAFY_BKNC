#include <iostream>
#include <queue>

using namespace std;

int n, m, h;
int arr[100][100][100];
int temp[100][100][100];
bool visited[100][100][100];
int dx[6] = { 0, 0, 0, 0, -1, 1 };
int dy[6] = { 0, 0, 1, -1, 0, 0 };
int dz[6] = { 1, -1, 0, 0, 0, 0 };
int result_cnt = 0;
queue<pair<pair<pair<int, int>, int>, int>> q;


int main(void) {

    cin >> m >> n >> h;

    for (int k = 0; k < h; k++) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                cin >> arr[k][i][j];
                temp[k][i][j] = arr[k][i][j];
            }
        }
    }

    int ct = 0;

    for (int k = 0; k < h; k++) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[k][i][j] == 1) {
                    visited[k][i][j] = true;
                    q.push({ {{i, j}, k}, ct + 1 });
                }
            }
        }
    }


    while (!q.empty()) {

        int x = q.front().first.first.first;
        int y = q.front().first.first.second;
        int z = q.front().first.second;
        int cnt = q.front().second;

        if (result_cnt < cnt) {
            result_cnt = cnt;
        }

        q.pop();

        for (int i = 0; i < 6; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            int nz = z + dz[i];

            if (nx >= 0 && nx < n && ny >= 0 && ny < m && nz >= 0 && nz < h) {
                if (!visited[nz][nx][ny]) {
                    if (temp[nz][nx][ny] == 0) {
                        visited[nz][nx][ny] = true;
                        temp[nz][nx][ny] = 1;
                        q.push({ {{nx, ny}, nz }, cnt + 1 });
                    }
                }
            }
        }

    }

    bool notComplete = false;

    for (int k = 0; k < h; k++) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (temp[k][i][j] == 0) {
                    notComplete = true;
                }
            }
        }
    }

    if (notComplete) {
        cout << -1 << '\n';
    }
    else {
        cout << result_cnt - 1 << '\n';
    }
    
}