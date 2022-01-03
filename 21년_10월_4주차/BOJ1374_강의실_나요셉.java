package com.js.pekah.algorithms.d1027;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node {

	int classNum;
	int start;
	int end;
	
	Node(int classNum, int start, int end) {
		this.classNum = classNum;
		this.start = start;
		this.end = end;
	}
}

public class BOJ1374_강의실_나요셉 {
	static int N;
	static List<Node> list;
	static PriorityQueue<Integer> pq;
	static int result = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		list = new ArrayList<Node>();
		pq = new PriorityQueue();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			int classNum = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			list.add(new Node(classNum, start, end));
		}
		
		Collections.sort(list, new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) {
				return o1.start - o2.start;
			}
			
		});
		
		for (int i = 0; i < N; i++) {
			Node v = list.get(i);
			System.out.println(v.classNum + " " + v.start + " " + v.end);
		}
		
		for (int i = 0; i < N; i++) {
			while (!pq.isEmpty() && pq.peek() <= list.get(i).start) {
				pq.poll();
			}
			
			pq.add(list.get(i).end);
			result = Math.max(result, pq.size());
		}
		
		System.out.println(result);
	}
}
