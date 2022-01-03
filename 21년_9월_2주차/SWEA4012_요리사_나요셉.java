package com.ssafy.algorithm.d0907;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA4012_요리사_나요셉 {
	static int N;
	static int arr[][];
	static boolean visited[];
	static int result;
	
	public static void cook(int cur, int count) {
		if (count == N/2) {
			int a = 0;
			int b = 0;
			
			for (int i = 0; i < N - 1; i++) {
				for (int j = i + 1; j < N; j++) {
					if (visited[i] && visited[j])
						a += arr[i][j] + arr[j][i];
					else if (!visited[i] && !visited[j])
						b += arr[i][j] + arr[j][i];
				}
			}
			
			result = Math.min(result, Math.abs(a - b));
			return;
		}
		
		for (int i = cur; i < N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				cook(i, count + 1);
				visited[i] = false;
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			visited = new boolean[N];
			result = Integer.MAX_VALUE;
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			cook(0, 0);
			
			System.out.println("#" + tc + " " + result);
		}
	}
}
