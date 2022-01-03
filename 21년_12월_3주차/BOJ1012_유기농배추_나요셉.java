package com.js.pekah.algorithms.d1214;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 20:38 ~ 20:55

public class BOJ1012_유기농배추_나요셉 {
	static int N, M, K;
	static int arr[][];
	static boolean visited[][];
	static Queue<Point> q;
	static int dx[] = {-1, 1, 0, 0};
	static int dy[] = {0, 0, -1, 1};
	
	static int result;
	
	public static void bfs(int x, int y) {
		q = new LinkedList<Point>();
		Point v;
		
		q.offer(new Point(x, y));
		visited[x][y] = true;
		
		while (!q.isEmpty()) {
			v = q.poll();
			
			for (int i = 0; i < 4; i++) {
				int xx = v.x + dx[i];
				int yy = v.y + dy[i];
				
				if (xx < 0 || xx >= M || yy < 0 || yy >= N) continue;
				
				if (arr[xx][yy] == 1 && !visited[xx][yy]) {
					visited[xx][yy] = true;
					q.offer(new Point(xx, yy));
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			arr = new int[M][N];
			visited = new boolean[M][N];
			result = 0;
			
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				arr[x][y] = 1;
			}
			
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					if (arr[i][j] == 1 && !visited[i][j]) {
						bfs(i, j);
						result++;
					}
				}
			}
			
			System.out.println(result);
		}
	}
}
