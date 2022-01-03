package com.js.pekah.algorithms.d1217;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 23:00 ~ 23:20

public class BOJ1987_알파벳_나요셉 {
	static int R, C;
	static int arr[][];
	static boolean visited[];
	static int result;
	
	static int dx[] = {-1, 1, 0, 0};
	static int dy[] = {0, 0, -1, 1};
	
	public static void dfs(int x, int y, int count) {
		if (visited[arr[x][y]]) {
			result = Math.max(result, count);
			return;
		}
		
		visited[arr[x][y]] = true;
		
		for (int i = 0; i < 4; i++) {
			int xx = x + dx[i];
			int yy = y + dy[i];
			
			if (xx < 0 || xx >= R || yy < 0 || yy >= C) 
				continue;
			
			dfs(xx, yy, count + 1);
		}
		
		visited[arr[x][y]] = false;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new int[R][C];
		visited = new boolean[26];
		
		for (int i = 0; i < R; i++) {
			String temp = br.readLine();
			for (int j = 0; j < C; j++) {
				arr[i][j] = temp.charAt(j) - 'A';
			}
		}
		
		dfs(0, 0, 0);
		
		System.out.println(result);
	}
}
