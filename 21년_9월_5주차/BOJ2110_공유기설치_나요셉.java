package com.js.pekah.algorithms.d0927;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2110_공유기설치_나요셉 {
	static int N, C;
	static int arr[];
	static int start, end, result, mid, value, count;
	
	public static int solve() {

		start = arr[1] - arr[0];
		end = arr[N-1] - arr[0];
		result = 1;
		
		while (start <= end) {
			mid = (start + end) / 2;
			value = arr[0];
			count = 1;
			
			for (int i = 0; i < N; i++) {
				if (arr[i] >= mid + value) {
					value = arr[i];
					count++;
				}
			}
			
			if (count >= C) {
				start = mid + 1;
				result = mid;
			} else {
				end = mid - 1;
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new int[N];
		
		for (int i = 0; i < N; i++) 
			arr[i] = Integer.parseInt(br.readLine());
		
		Arrays.sort(arr);
		System.out.println(solve());
	}
}
