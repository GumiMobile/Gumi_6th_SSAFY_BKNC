package com.ssafy.algorithm.d0831;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA1247_최적경로_나요셉 {
	static int N;
	static Point[] customer;
	static Point company;
	static Point home;
	static boolean visited[];
	static int result;
	
	public static int getDistance(int x, int y, int cx, int cy) {
		return Math.abs(x-cx) + Math.abs(y-cy);
	}
	
	public static void dfs(int cur, int x, int y, int count) {
		if (cur == N) {
			count += getDistance(x, y, company.x, company.y);
			result = Math.min(result, count);
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				dfs(cur + 1, customer[i].x, customer[i].y , count + getDistance(x, y, customer[i].x, customer[i].y));
				visited[i] = false;
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input1247.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			customer = new Point[N];
			visited = new boolean[N];
			result = Integer.MAX_VALUE;
			
			st = new StringTokenizer(br.readLine());
			company = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			home = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			
			int k = 0;
			for (int i = 4; i < 4+N; i++) {
				customer[k++] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			
			dfs(0, home.x, home.y, 0);
			
			System.out.println("#" + tc + " " + result);
		}
	}
}
