package com.js.pekah.algorithms.d1028;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ1655_가운데를말해요_나요셉 {
	static int N;
	static PriorityQueue<Integer> minHeap;
	static PriorityQueue<Integer> maxHeap;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		minHeap = new PriorityQueue<>((o1, o2) -> o1 - o2);
		maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);		
		
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			
			if (maxHeap.size() == minHeap.size()) maxHeap.add(num);
			else minHeap.add(num);
			
			if (!maxHeap.isEmpty() && ! minHeap.isEmpty()) {
				if (minHeap.peek() < maxHeap.peek()) {
					int tmp = minHeap.poll();
					minHeap.add(maxHeap.poll());
					maxHeap.add(tmp);
				}
			}
			sb.append(maxHeap.peek() + "\n");
		}
		System.out.println(sb);
	}
}
