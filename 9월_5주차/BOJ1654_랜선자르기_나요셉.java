package com.js.pekah.algorithms.d0929;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1654_랜선자르기_나요셉 {
	static int K, N;
	static int arr[];
	static long start, end, mid, result;
	
	public static void solve() {
		start = 1;
		end = arr[K-1];
		
		while (start <= end) {
			mid = (start + end) / 2;
			result = 0;
			
			for (int i = 0; i < K; i++) {
				result += arr[i] / mid;
			}
			
			if (result < N) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		
		result = end;
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		K = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		arr = new int[K];
		
		for (int i = 0; i < K; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		
		solve();
		
		System.out.println(result);
	}
}
