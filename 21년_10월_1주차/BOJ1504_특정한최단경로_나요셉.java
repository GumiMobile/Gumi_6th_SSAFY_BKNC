package com.js.pekah.algorithms.d1009;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Path implements Comparable<Path> {
	int to;
	int dist;
	
	public Path(int to, int dist) {
		this.to = to;
		this.dist = dist;
	}
	
	@Override
	public int compareTo(Path o) {
		return dist - o.dist;
	}
}

public class BOJ1504_특정한최단경로_나요셉 {
	static int N, E;
	static List<Path> lst[];
	static int pass1, pass2;
	static int result;
	static PriorityQueue<Path> q;
	static Path d[];
	static boolean visited[];
	
	public static int solve(int start, int end) {
		q = new PriorityQueue<>();
		d = new Path[N + 1];
		visited = new boolean[N + 1];
		
		for (int i = 0; i <= N; i++) {
			if (i == start) d[i] = new Path(i, 0);
			else d[i] = new Path(i, Integer.MAX_VALUE);
		}
		
		q.offer(new Path(start, 0));
		
		while (!q.isEmpty()) {
			Path v = q.poll();
			
			visited[v.to] = true;
			
			for (Path next : lst[v.to]) {
				if (d[next.to].dist > d[v.to].dist + next.dist) {
					d[next.to].dist = d[v.to].dist + next.dist;
					
					q.offer(d[next.to]);
				}
			}
			
			visited[v.to] = true; 
		}
		
		return d[end].dist;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		lst = new ArrayList[N + 1];
		for (int i = 0; i <= N; i++) {
			lst[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int dist = Integer.parseInt(st.nextToken());
			
			lst[from].add(new Path(to, dist));
			lst[to].add(new Path(from, dist));
		}
		
		st = new StringTokenizer(br.readLine());
		pass1 = Integer.parseInt(st.nextToken());
		pass2 = Integer.parseInt(st.nextToken());
		
		int result1 = solve(1, pass1) + solve(pass1, pass2) + solve(pass2, N);
		int result2 = solve(1, pass2) + solve(pass2, pass1) + solve(pass1, N);
		
		if (result1 >= 987654321 && result2 >= 987654321) result = -1;
		else result = Math.min(result1, result2);
		
		System.out.println(result1 + " " + result2);
		System.out.println(Integer.MAX_VALUE);
		System.out.println(result);
		
	}
}
