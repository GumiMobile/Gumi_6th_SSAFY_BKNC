package com.js.pekah.algorithms.d0924;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ1463_1로만들기_나요셉 {
	static int N;
	static int dp[] = new int[1000001];
	static int cnt;
	
	public static int solve(int n) {
		if (dp[n] != 0 || n == 1) return dp[n];
		
		
		
		if (n % 3 == 0) cnt = Math.min(cnt, solve(n / 3));
		if (n % 2 == 0) cnt = Math.min(cnt, solve(n / 2));
		cnt = Math.min(cnt, solve(n - 1));
		
		dp[n] = cnt + 1;
		return dp[n];
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		dp[0] = dp[1] = 0;
		cnt = Integer.MAX_VALUE;
		
		System.out.println(solve(N));
	}
}
