#include <iostream>

using namespace std;

int n;
int dp[1000001];


void findNum() {

	for (int i = 2; i <= n; i++) {
		dp[i] = dp[i - 1] + 1;

		if (i % 2 == 0) {
			dp[i] = min(dp[i], dp[i / 2] + 1);
		}
		if (i % 3 == 0) {
			dp[i] = min(dp[i], dp[i / 3] + 1);
		}
	}

}


 int main(void) {

	 cin >> n;

	 findNum();

	 cout << dp[n] << '\n';
    
}