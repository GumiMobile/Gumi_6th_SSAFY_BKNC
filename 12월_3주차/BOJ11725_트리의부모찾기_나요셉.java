package com.js.pekah.algorithms.d1213;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 20:21 ~ 21:07

public class BOJ11725_트리의부모찾기_나요셉 {
	static int N;
	static List<Integer> lst[];
	static int result[];
	
	public static void dfs(int start, int parent) {
		
		result[start] = parent;
		
		for (int l : lst[start]) {
			if (l != parent) {
				dfs(l, start);
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		lst = new ArrayList[N+1];
		result = new int[N+1];
		
		for (int i = 1; i <= N; i++) {
			lst[i] = new ArrayList<Integer>();
		}
		
		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			lst[from].add(to);
			lst[to].add(from);
		}
		
		dfs(1, 0);
		
		for (int i = 2; i < result.length; i++) {
			System.out.println(result[i]);
		}
	}
}
