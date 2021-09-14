package com.js.pekah.algorithms.d0914;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ2447_별찍기_나요셉 {
	static String visited[][];
	
	public static void solve(int x, int y, int size) {
		if (size == 1) {
			if (visited[x][y] != " ") visited[x][y] = "*";
		}
		else {
			int div_size = size / 3;
			for (int i = x + div_size; i < x + (div_size * 2); i++) {
				for (int j = y + div_size; j < y + (div_size * 2); j++) {
					visited[i][j] = " ";
				}
			}
			
			for (int i = x; i < x + size; i+=div_size) {
				for (int j = y; j < y + size; j+=div_size) {
					solve(i, j, div_size);
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		visited = new String[N][N];
		
		solve(0, 0, N);
		
		for (String[] a : visited) {
			for (String b : a) sb.append(b);
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
}
