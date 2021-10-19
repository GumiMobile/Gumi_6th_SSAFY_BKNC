package com.js.pekah.algorithms.d1019;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ3273_두수의합_나요셉 {
	static int N, X;
	static int arr[];
	static int result, sum, start, end;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		X = Integer.parseInt(br.readLine());
		
		Arrays.sort(arr);
		
		start = 0;
		end = N - 1;
		
		while (start < end) {
			sum = arr[start] + arr[end];
			
			if (sum == X) {
				result++;
				start++;
				end--;
			}
			else if (sum > X) end--;
			else if (sum < X) start++;
		}
		
		System.out.println(result);
	}
}
