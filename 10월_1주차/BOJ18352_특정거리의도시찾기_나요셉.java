package com.js.pekah.algorithms.d1007;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ18352_특정거리의도시찾기_나요셉 {
	static int N, M, K, X;
	static List<Integer> lst[];
	static int d[];
	static boolean visited[];
	
	public static void solve() {
		Queue<Integer> q = new LinkedList<>();
		visited[X] = true;
		q.add(X);
		
		while (!q.isEmpty()) {
			int v = q.poll();
			
			for (int i = 0; i < lst[v].size(); i++) {
				int next = lst[v].get(i);
				
				if (!visited[next]) {
					d[next] = d[v] + 1;
					q.add(next);
					visited[next] = true;
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		lst = new ArrayList[N+1];
		for (int i = 0; i <= N; i++) {
			lst[i] = new ArrayList<>();
		}
		d = new int[N+1];
		visited = new boolean[N+1];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			lst[Integer.parseInt(st.nextToken())].add(Integer.parseInt(st.nextToken()));
		}
		
		solve();
		
		boolean check = false;
		for (int i = 0; i <= N; i++) {
			if (d[i] == K) {
				System.out.println(i);
				check = true;
			}
		}
		
		if (!check) System.out.println(-1);
	}
}
