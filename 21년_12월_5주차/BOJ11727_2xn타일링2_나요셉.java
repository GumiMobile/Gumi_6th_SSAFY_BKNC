package js.pekah.algorithms.d1228;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;

public class BOJ11727_2xn타일링2 {
	static int n;
	static int dp[];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		dp = new int[n+1];
		
		for (int i = 1; i <= n; i++) {
			if (i == 1) dp[i] = 1;
			else if (i == 2) dp[i] = 3;
			else dp[i] = (dp[i-2]*2 + dp[i-1]) % 10007;
		}
		
		System.out.println(dp[n]);
	}
}
