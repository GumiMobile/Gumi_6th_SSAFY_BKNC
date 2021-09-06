package com.ssafy.algorithm.d0906;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA4008_숫자만들기_나요셉 {
	static int N;
	static int op[];
	static int arr[];
	static int result;
	static int max;
	static int min;
	
	public static void dfs(int idx, int num) {
		if (idx == N - 1) {
			max = Math.max(max, num);
			min = Math.min(min, num);
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			if (op[i] > 0) {
				int tmp = 0;
				int next = arr[idx + 1];
				
				if (i == 0) tmp = num + next;
				else if (i == 1) tmp = num - next;
				else if (i == 2) tmp = num * next;
				else tmp = (int) num / next;
				
				op[i]--;
				dfs(idx + 1, tmp);
				op[i]++;
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			op = new int[4];
			arr = new int[N];
			max = Integer.MIN_VALUE;
			min = Integer.MAX_VALUE;
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 4; i++) {
				op[i] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			dfs(0, arr[0]);
			
			System.out.println("#" + tc + " " + (max - min));
		}
	}
}
