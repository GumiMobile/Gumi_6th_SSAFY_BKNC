package com.js.pekah.algorithms.d1227;

import java.util.Scanner;

public class BOJ11726_2xn타일링_나요셉 {
	static int n;
	static int dp[];
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		dp = new int[n+1];
		
		for (int i = 1; i <= n; i++) {
			if (i == 1) dp[i] = 1;
			else if (i == 2) dp[i] = 2;
			else dp[i] = (dp[i-2] + dp[i-1]) % 10007;
		}
		
		System.out.println(dp[n]);
	}
}
