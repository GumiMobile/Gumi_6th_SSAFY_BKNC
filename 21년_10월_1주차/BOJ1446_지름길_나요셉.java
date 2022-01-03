package com.js.pekah.algorithms.d1005;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

class Node implements Comparable<Node>{
	int to = Integer.MAX_VALUE; 
	int dist;
	
	public Node(int to, int dist) {
		this.to = to;
		this.dist = dist;
	}
	
	@Override
	public int compareTo(Node n) {
		return Integer.compare(this.to, n.to);
	}
}

public class BOJ1446_지름길_나요셉 {
	static int N, D;
	static int from, to, dist;
	static int d[];
	static List<Node> lst[] = new List[10001];
	
	public static int solve() {
		for (int i = 0; i < D + 1; i++) {
			if (i >= D) break;
			
			d[i+1] = Math.min(d[i]+1, d[i+1]);
			
			for (Node l : lst[i]) {
				if (l.to > D) continue;
				
				if (d[l.to] > l.dist + d[i]) {
					d[l.to] = l.dist + d[i];
				}
			}
		}
		
		return d[D];
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());

		for (int i = 0; i < 10001; i++) {
			lst[i] = new ArrayList<Node>();
		}
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			dist = Integer.parseInt(st.nextToken());
			
			lst[from].add(new Node(to, dist));
		}
		
		d = new int[D + 1];
		Arrays.fill(d, Integer.MAX_VALUE);
		
		d[0] = 0;
		
		System.out.println(solve());
	}
}
