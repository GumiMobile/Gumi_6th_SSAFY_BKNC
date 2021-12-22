package com.js.pekah.algorithms.d1222;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 20:02 ~ 20:50

public class BOJ14502_연구소_나요셉 {
	static int n, m;
	static int arr[][];
	static int temp[][];
	static Queue<Point> q;
	static int result;
	
	static int dx[] = {-1, 1, 0, 0};
	static int dy[] = {0, 0, -1, 1};
	
	public static void bfs(int depth) {
		if (depth == 3) {
			q = new LinkedList<>();
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					temp[i][j] = arr[i][j];
				}
			}
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (temp[i][j] == 2) {
						q.add(new Point(j, i));
					}
				}
			}
			
			while (!q.isEmpty()) {
				Point v = q.remove();
				
				for (int i = 0; i < 4; i++) {
					int xx = v.x + dx[i];
					int yy = v.y + dy[i];
					
					if (xx < 0 || xx >= m || yy < 0 || yy >= n) continue;
					
					if (temp[yy][xx] == 0) {
						temp[yy][xx] = 2;
						q.add(new Point(xx, yy));
					}
				}
			}
			
			int count = 0;
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (temp[i][j] == 0) count++;
				}
			}
			
			result = Math.max(result, count);
			
			return;
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (arr[i][j] == 0) {
					arr[i][j] = 1;
					bfs(depth + 1);
					arr[i][j] = 0;
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		temp = new int[n][m];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		bfs(0);
		
		System.out.println(result);
	}
}
