package com.js.pekah.algorithms.d1213;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 19:51 ~ 20:19

public class BOJ2644_촌수계산_나요셉 {
	static int N, M;
	static int arr[][];
	static int start, end;
	static int result = -1;
	
	public static void dfs(int start, int count) {
		if (start == end) {
			result = count;
		}
		
		for (int i = 0; i < arr.length; i++) {
			if (arr[start][i] == 1) {
				arr[i][start] = 0;
				count++;
				dfs(i, count);
				arr[i][start] = 0;
				count--;
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N+1][N+1];
		
		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		
		M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			arr[from][to] = 1;
			arr[to][from] = 1;
		}
		
		dfs(start, 0);
		
		System.out.println(result);
	}
}
