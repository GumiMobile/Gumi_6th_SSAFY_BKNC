package com.js.pekah.algorithms.d1015;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1182_부분수열의합_나요셉 {
	static int N, S;
	static int arr[];
	static int result;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		result = 0;
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 1; i < (1 << N); i++) {
			int sum = 0;
			for (int j = 0; j < N; j++) {
				if ((i & (1 << j)) != 0) {
					sum += arr[j];
				}
			}
			if (sum == S) result++;
		}
		
		System.out.println(result);
	}
}
