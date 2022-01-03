package com.js.pekah.algorithms.d1006;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node> {
	int to;
	int dist;
	
	public Node(int to, int dist) {
		this.to = to;
		this.dist = dist;
	}

	@Override
	public int compareTo(Node n) {
		return Integer.compare(this.dist, n.dist);
	}
}

public class BOJ1753_최단경로_나요셉 {
	static int V, E;
	static int start;
	static List<Node> lst[];
	static int from, to, dist;
	static PriorityQueue<Node> pq;
	static boolean check[];
	static Node D[];
	
	public static void solve() {
		for (int i = 1; i <= V; i++) {
			if (i == start) D[i] = new Node(i, 0);
			else D[i] = new Node(i, Integer.MAX_VALUE);
		}
		
		pq.add(D[start]);
		
		while (!pq.isEmpty()) {
			Node v = pq.poll();
			
			if (D[v.to].dist < v.dist) continue;
			
			for (Node next : lst[v.to]) {
				if (D[next.to].dist > D[v.to].dist + next.dist) {
					D[next.to].dist = D[v.to].dist + next.dist;
					
					pq.remove(D[next.to]);
					pq.add(D[next.to]);
				}
			}
			
			check[v.to]= true; 
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		start = Integer.parseInt(br.readLine());
		
		lst = new ArrayList[V + 1];
		pq = new PriorityQueue<>();
		check = new boolean[V + 1];
		
		for (int i = 1; i <= V; i++) {
			lst[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			dist = Integer.parseInt(st.nextToken());
			
			lst[from].add(new Node(to, dist));
		}
		
		D = new Node[V + 1];
		
		solve();
		
		for (int i = 1; i <= V; i++) {
			if (D[i].dist == Integer.MAX_VALUE) sb.append("INF").append("\n");
			else sb.append(D[i].dist).append("\n");
		}
		System.out.println(sb);
	}
}
