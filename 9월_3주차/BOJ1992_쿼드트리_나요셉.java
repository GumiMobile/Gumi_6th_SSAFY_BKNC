package com.js.pekah.algorithms.d0915;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ1992_쿼드트리_나요셉 {
	static int arr[][];
	static StringBuilder sb;
	
	public static void solve(int x, int y, int size) {
		int cnt = 0;
		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				if (arr[i][j] == 1) cnt++;
			}
		}
		
		if (cnt == 0) sb.append(0);
		else if (cnt == size * size) sb.append(1);
		else {
			int half = size / 2;
			sb.append("(");
			solve(x, y, half);
			solve(x, y + half, half);
			solve(x + half, y, half);
			solve(x + half, y + half, half);
			sb.append(")");
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				arr[i][j] = str.charAt(j) - '0';
			}
		}
		
		solve(0, 0, N);
		
		System.out.println(sb);
	}
}
