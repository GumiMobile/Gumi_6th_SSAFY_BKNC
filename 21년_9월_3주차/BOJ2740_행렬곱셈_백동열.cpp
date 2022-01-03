#include <iostream>

using namespace std;

int n, m, k;
int arr1[100][100];
int arr2[100][100];
int result[100][100];

void crossNum() {

	for (int z = 0; z < n; z++) {
		for (int i = 0; i < k; i++) {
			int temp = 0;
			for (int j = 0; j < m; j++) {
				temp += arr1[z][j] * arr2[j][i];
			}
			result[z][i] = temp;
		}
	}

}

 int main(void) {

	cin >> n >> m;

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			cin >> arr1[i][j];
		}
	}

	cin >> m >> k;

	for (int i = 0; i < m; i++) {
		for (int j = 0; j < k; j++) {
			cin >> arr2[i][j];
		}
	}

	crossNum();

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < k; j++) {
			cout << result[i][j] << " ";
		}
		cout << '\n';
	}
	
	
    
}