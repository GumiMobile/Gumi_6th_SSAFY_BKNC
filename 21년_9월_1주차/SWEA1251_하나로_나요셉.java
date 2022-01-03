package com.ssafy.algorithm.d0901;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Node implements Comparable<Node>{
	int land;
	long dist;
	
	Node(int land, long dist) {
		this.land = land;
		this.dist = dist;
	}
	
	// 우선순위 큐 비교
	@Override
	public int compareTo(Node n) {
		return Long.compare(this.dist, n.dist);
	}
}

public class SWEA1251_하나로_나요셉 {
	static int N;
	static double E;
	static int arrX[];
	static int arrY[];
	static Queue<Node> q;
	static List<Node> l[];
	static boolean visited[];
	static long result;
	
	public static void solve(int cnt) {
		while(!q.isEmpty()) { 
			Node v = q.poll();
			
			if (visited[v.land]) continue;
			
			visited[v.land] = true;
			
			result += v.dist;
			
			if (++cnt == N) return;
			
			for (int i = 0; i < l[v.land].size(); i++) {
				Node to = l[v.land].get(i);
				if (!visited[to.land]) q.add(to);
			}
			
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stX;
		StringTokenizer stY;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			arrX = new int[N];
			arrY = new int[N];
			q = new PriorityQueue<>();
			l = new ArrayList[N];
			visited = new boolean[N];
			result = 0;
			
			for (int i = 0; i < N; i++) l[i] = new ArrayList<>();
			
			stX = new StringTokenizer(br.readLine());
			stY = new StringTokenizer(br.readLine());
			E = Double.parseDouble(br.readLine());
			
			for (int i = 0; i < N; i++) {
				arrX[i] = Integer.parseInt(stX.nextToken());
				arrY[i] = Integer.parseInt(stY.nextToken());
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (i != j) {
						l[i].add(new Node(j, (long) (Math.pow(arrX[i] - arrX[j], 2) + Math.pow(arrY[i] - arrY[j], 2))));
					}
				}
			}
			
			q.add(new Node(0, 0));
			
			solve(0);
			
			System.out.println("#" + tc + " " + Math.round(result * E));
		}
	}
}
