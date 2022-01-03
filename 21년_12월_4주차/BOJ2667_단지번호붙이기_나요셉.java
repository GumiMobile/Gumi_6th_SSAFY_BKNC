package com.js.pekah.algorithms.d1220;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

// 22:06 ~ 22:40

public class BOJ2667_단지번호붙이기_나요셉 {
	static int N;
	static int arr[][];
	static boolean visited[][];
	static List<Integer> result;
	static int count;
	
	static int dx[] = {-1, 1, 0, 0};
	static int dy[] = {0, 0, -1, 1};
	
	public static void dfs(int x, int y) {
		visited[x][y] = true;
		
		for (int i = 0; i < 4; i++) {
			int xx = x + dx[i];
			int yy = y + dy[i];
			
			if (xx < 0 || xx >= N || yy < 0 || yy >= N) continue;
			
			if (arr[xx][yy] == 1 && !visited[xx][yy]) {
				dfs(xx, yy);
				count++;
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		visited = new boolean[N][N];
		result = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				arr[i][j] = str.charAt(j) - '0';
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i][j] == 1 && !visited[i][j]) {
					count = 1;
					dfs(i, j);
					result.add(count);
				}
			}
		}
		
		Collections.sort(result);
		
		System.out.println(result.size());
		
		for (int i : result) {
			System.out.println(i);
		}
	}
}
