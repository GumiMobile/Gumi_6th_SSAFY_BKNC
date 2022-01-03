package com.js.pekah.algorithms.d0928;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ10815_숫자카드_나요셉 {
	static int N, M;
	static int arr[];
	static int find[];
	static int start, end, mid;
	
	public static int solve(int target) {
		start = 0;
		end = N-1;
		
		while(start <= end) {
			mid = (start + end) / 2;
			
			if (arr[mid] == target) {
				return 1;
			}
			else if (arr[mid] > target) 
				end = mid - 1;
			else
				start = mid + 1;
		}
		
		return 0;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		M = Integer.parseInt(br.readLine());
		find = new int[M];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			find[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		for (int i = 0; i < M; i++) {
			System.out.print(solve(find[i]) + " ");
		}
	}
}
