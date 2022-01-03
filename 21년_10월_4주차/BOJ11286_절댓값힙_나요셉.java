package com.js.pekah.algorithms.d1025;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ11286_절댓값힙_나요셉 {
	static int N;
	static PriorityQueue<Integer> pq;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		pq = new PriorityQueue<Integer>((o1, o2) -> {
			int num1 = Math.abs(o1);
			int num2 = Math.abs(o2);
			
			if (num1 == num2) 
				return o1 > o2 ? 1 : -1;
			return num1 - num2;
			
		});
		
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			
			if (num == 0) {
				if (!pq.isEmpty()) System.out.println(pq.poll());
				else System.out.println(0);
			} else {
				pq.offer(num);
			}
		}
	}
}
