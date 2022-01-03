package com.ssafy.algorithm.d0901;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

class Node implements Comparable<Node>{
	int x;
	int y;
	int val;
	
	Node(int x, int y, int val) {
		this.x = x;
		this.y = y;
		this.val = val;
	}
	
	// 우선순위 큐 비교
	@Override
	public int compareTo(Node n) {
		return this.val - n.val;
	}
}

public class SWEA1249_보급로_나요셉 {
	static int N;
	static int arr[][];
	static int depth[][];
	static final int MAX = Integer.MAX_VALUE;
	static Queue<Node> q;
	static int result;
	static int dx[] = {-1, 1, 0, 0};
	static int dy[] = {0, 0, -1, 1};
	
	public static void solve() {
		while(!q.isEmpty()) {
			Node v = q.poll();
			int x = v.x;
			int y = v.y;
			int val = v.val;
			
			// 도착지점
			if (x == N - 1 && y == N - 1) {
				if (result > val) result = val;
				break;
			}
			
			// 상하좌우 이동
			for (int i = 0; i < 4; i++) {
				int xx = x + dx[i];
				int yy = y + dy[i];
				
				if (xx < 0 || xx >= N || yy < 0 || yy >= N) continue;
				
				// 가중치 저장
				if (depth[xx][yy] > arr[xx][yy] + val) {
					depth[xx][yy] = arr[xx][yy] + val;
					q.add(new Node(xx, yy, depth[xx][yy]));
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			depth = new int[N][N];
			q = new PriorityQueue<>(); // 우선순위 큐
			result = MAX;
			
			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				for (int j = 0; j < N; j++) {
					arr[i][j] = str.charAt(j) - '0';
				}
				Arrays.fill(depth[i], MAX);	// max 값으로 초기화
			}
			
			// 시작지점
			depth[0][0] = arr[0][0];
			q.add(new Node(0, 0, arr[0][0]));
			
			solve();
			
			System.out.println("#" + tc + " " + result);
		}
	}
}
