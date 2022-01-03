package com.ssafy.algorithm.d0908;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA1953_탈주범검거_나요셉 {
	static int N, M, R, C, L;
	static int arr[][];
	static boolean visited[][];
	static Queue<Point> q;
	static int result;
	static int dx[] = {-1, 1, 0, 0};
	static int dy[] = {0, 0, -1, 1};
	static int times;
	
	public static void bfs() {
		q = new LinkedList<>();
		q.offer(new Point(R, C));	// 시작
		visited[R][C] = true;		// 방문 처리
		
		while (!q.isEmpty()) {
			int l = q.size();
			if (times >= L) return;	// L 시간 만큼 지나면 종료
			
			for (int k = 0; k < l; k++) {
				Point v = q.poll();	// 큐에서 하나씩 꺼냄
				int x = v.x;
				int y = v.y;
				
				for (int i = 0; i < 4; i++) {
					// 4방 탐색
					int xx = x + dx[i];
					int yy = y + dy[i];
					
					// 범위 벗어나면 continue
					if (xx < 0 || xx >= N || yy < 0 || yy >= M) continue;
					// 이미 방문한 위치이거나 값이 0일 경우 continue
					if (visited[xx][yy] || arr[xx][yy] == 0) continue;
					
					switch(i) {
					case 0:
						// 상
						if (arr[x][y] == 1 || arr[x][y] == 2 || arr[x][y] == 4 || arr[x][y] == 7) {
							// 상향이면서 다음 위치의 하향이 연결되어있으면
							if (arr[xx][yy] == 1 || arr[xx][yy] == 2 || arr[xx][yy] == 5 || arr[xx][yy] == 6) {
								visited[xx][yy] = true;
								q.offer(new Point(xx, yy));
								result++;
							}
						}
						break;
					case 1:
						// 하
						if (arr[x][y] == 1 || arr[x][y] == 2 || arr[x][y] == 5 || arr[x][y] == 6) {
							if (arr[xx][yy] == 1 || arr[xx][yy] == 2 || arr[xx][yy] == 4 || arr[xx][yy] == 7) {
								visited[xx][yy] = true;
								q.offer(new Point(xx, yy));
								result++;
							}
						}
						break;
					case 2:
						// 좌
						if (arr[x][y] == 1 || arr[x][y] == 3 || arr[x][y] == 6 || arr[x][y] == 7) {
							if (arr[xx][yy] == 1 || arr[xx][yy] == 3 || arr[xx][yy] == 4 || arr[xx][yy] == 5) {
								visited[xx][yy] = true;
								q.offer(new Point(xx, yy));
								result++;
							}
						}
						break;
					case 3:
						// 우
						if (arr[x][y] == 1 || arr[x][y] == 3 || arr[x][y] == 4 || arr[x][y] == 5) {
							if (arr[xx][yy] == 1 || arr[xx][yy] == 3 || arr[xx][yy] == 6 || arr[xx][yy] == 7) {
								visited[xx][yy] = true;
								q.offer(new Point(xx, yy));
								result++;
							}
						}
						break;
					}
				}
			}
			times++;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 세로
			M = Integer.parseInt(st.nextToken()); // 가로
			R = Integer.parseInt(st.nextToken()); // 세로 시작지점
			C = Integer.parseInt(st.nextToken()); // 가로 시작지점
			L = Integer.parseInt(st.nextToken()); // 시간
			
			arr = new int[N][M];
			visited = new boolean[N][M];
			result = 1;
			times = 1;
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			bfs();
			
			System.out.println("#" + tc + " " + result);
		}
	}
}
