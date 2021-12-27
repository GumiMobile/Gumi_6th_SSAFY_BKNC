package com.js.pekah.algorithms.d1227;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 22:43 ~ 23:05

public class BOJ2579_계단오르기_나요셉 {
	static int n;
	static int arr[];
	static int dp[];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		arr = new int[n+1];
		dp = new int[n+1];
		
		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		dp[1] = arr[1];
		
		if (n >= 2) {
			dp[2] = arr[1] + arr[2];
		}
		
		for (int i = 3; i <= n; i++) {
			dp[i] = Math.max(dp[i-2], dp[i-3] + arr[i-1]) + arr[i];
		}
		
		System.out.println(dp[n]);
	}
}
