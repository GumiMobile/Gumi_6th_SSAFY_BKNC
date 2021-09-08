package com.ssafy.algorithm.d0908;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA7465_창용마을무리의개수_나요셉 {
	static int N, M, start, end;
	static int arr[][];
	static boolean visited[];
	static int result;
	static Queue<Integer> q = new LinkedList<>();;
	
	public static void bfs(int cur) {
		q.offer(cur);
		visited[cur] = true;
		
		while (!q.isEmpty()) {
			int v = q.poll();
			
			for (int i = 1; i <= N; i++) {
				if (arr[v][i] == 1 && !visited[i]) {
					q.offer(i);
					visited[i] = true;
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			arr = new int[N+1][N+1];
			visited = new boolean[N+1];
			result = 0;
			
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				start = Integer.parseInt(st.nextToken());
				end = Integer.parseInt(st.nextToken());
				
				arr[start][end] = 1;
				arr[end][start] = 1;
			}
			
			for (int i = 1; i <= N; i++) {
				if (!visited[i]) {
					result++;
					bfs(i);
				}
			}
			
			System.out.println("#" + tc + " " + result);
		}
	}
}
