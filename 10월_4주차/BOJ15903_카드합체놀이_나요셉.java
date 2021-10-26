package com.js.pekah.algorithms.d1026;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ15903_카드합체놀이_나요셉 {
	static int n, m;
	static PriorityQueue<Long> pq;
	static long x, y;
	static long result;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		pq = new PriorityQueue<>();
		
		for (int i = 0; i < n; i++) {
			pq.add(Long.parseLong(st.nextToken()));
		}
		
		for (int i = 0; i < m; i++) {
			x = pq.poll();
			y = pq.poll();
			
			pq.add(x+y);
			pq.add(x+y);
		}
		
		for (int i = 0; i < n; i++) {
			result += pq.poll();
		}
		
		System.out.println(result);
	}
}
