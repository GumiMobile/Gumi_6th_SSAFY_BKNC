package com.js.pekah.algorithms.d1020;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2559_수열_나요셉 {
	static int N, K;
	static int arr[];
	static int result, start, end, sum, count;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[N+1];
		result = Integer.MIN_VALUE;
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		while (end < N) {
			
			if (count == K) {
				result = Math.max(result, sum);
				sum -= arr[start++];
				count--;
			} 
			else {
				sum += arr[end++];
				count++;
			}
		}
		
		System.out.println(result);
	}
}
