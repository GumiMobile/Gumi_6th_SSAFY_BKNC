package com.ssafy.algorithm.d0909;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA2117_홈방범서비스_나요셉 {
	static int N, M, home;
	static int arr[][];
	static Queue<Point> q;
	static int cost[];
	static int dx[] = {-1, 1, 0, 0};
	static int dy[] = {0, 0, -1, 1};
	static boolean visited[][];
	
	public static void bfs(int x, int y) {
		// 시작지점에 집이 있으면 1 아니면 0
		int h = arr[x][y] == 1 ? 1 : 0;
		
		visited = new boolean[N][N];
		q = new LinkedList<>();
		
		q.offer(new Point(x, y));
		
		visited[x][y] = true;
		int depth = 1;
		
		while (!q.isEmpty()) {
			
			// 집 최대개수
			if ((h * M) - cost[depth] >= 0) {
				home = Math.max(home, h);
			}
			
			int l = q.size();
			// 큐 사이즈만큼 순차적으로 탐색
			for (int k = 0; k < l; k++) {
				Point v = q.poll();

				for (int j = 0; j < 4; j++) {
					int xx = v.x + dx[j];
					int yy = v.y + dy[j];
					
					if (xx < 0 || xx >= N || yy < 0 || yy >= N || visited[xx][yy]) continue;
					
					if (arr[xx][yy] == 1) h++;
					
					q.offer(new Point(xx, yy));
					visited[xx][yy] = true;
				}
			}
			depth++;
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			arr = new int[N][N];
			home = 0;
			
			// 비용 초기화
			cost = new int[arr.length * 2];
			for (int i = 1; i < cost.length; i++) {
				cost[i] = (i * i) + ((i - 1) * (i - 1));
			}
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			// 처음부터 끝까지 루프
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					bfs(i, j);
				}
			}
			
			System.out.println("#" + tc + " " + home);
		}
	}
}
