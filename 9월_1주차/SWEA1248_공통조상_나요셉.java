package com.ssafy.algorithm.d0831;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Node {
	int data;
	int parent;
	int left;
	int right;
	
	Node(int data) {
		this.data = data;
		this.parent = 0;
		this.left = 0;
		this.right = 0;
	}
}

public class SWEA1248_공통조상_나요셉 {
	static int V, E;
	static int node1, node2;
	static Node nodes[];
	static List<Integer> visited;
	static int parent;
	static int size;
	
	public static void getSize(int node) {
		size++;
		
		int left = nodes[node].left;
		int right = nodes[node].right;
		
		if (left != 0 && right != 0) {
			getSize(left);
			getSize(right);
		} else if (left != 0) getSize(left);
		else if (right != 0) getSize(right);
	}
	
	public static void find(int node) {
		int p = nodes[node].parent;
		
		if (p == 0 || parent != 0) return;
		
		if (visited.contains(p)) parent = p;
		else visited.add(p);
		
		find(p);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			node1 = Integer.parseInt(st.nextToken());
			node2 = Integer.parseInt(st.nextToken());
			nodes = new Node[V+1];
			visited = new ArrayList<>();
			parent = 0;
			size = 0;
			
			for (int i = 1; i <= V; i++) nodes[i] = new Node(i);
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < E; i++) {
				int parent = Integer.parseInt(st.nextToken());
				int child = Integer.parseInt(st.nextToken());
				
				if (nodes[parent].left == 0) nodes[parent].left = child;
				else nodes[parent].right = child;
				nodes[child].parent = parent;
			}
			
			find(node1);
			find(node2);
			
			getSize(parent);
			
			System.out.println("#" + tc + " " + parent + " " + size);
		}
	}
}
