package js.pekah.algorithms.d1228;

import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;

public class BOJ1932_정수삼각형_나요셉 {
	static int n;
	static int arr[][];
	static int dp[][];
	static int result;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		dp = new int[n][n];
		result = Integer.MIN_VALUE;
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j <= i; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dp[0][0] = arr[0][0];
		
		for (int i = 1; i < n; i++) {
			for (int j = 0; j <= i; j++) {
				if (j == 0) dp[i][j] = dp[i-1][j] + arr[i][j];
				else if (j == i) dp[i][j] = dp[i-1][j-1] + arr[i][j];
				else {
					dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + arr[i][j];
				}
			}
		}
		
		for (int i = 0; i < n; i++) {
			result = Math.max(result, dp[n-1][i]);
		}
		
		System.out.println(result);
	}
}
