package com.js.pekah.algorithms.d0120;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ2212_센서_나요셉 {
	static int n, k;
	static int result;
	static int arr[];
	static Integer diff[];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		k = Integer.parseInt(br.readLine());
		arr = new int[n];
		diff = new Integer[n-1];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		
		if (k >= n) {
			result = 0;
		} else {
			Arrays.sort(arr);
			
			for (int i = 0; i < n - 1; i++) {
				diff[i] = arr[i+1] - arr[i];
			}
			Arrays.sort(diff, Collections.reverseOrder());
			
			for (int i = k - 1; i < n - 1; i++) {
				result += diff[i];
			}
		}
		
		System.out.println(result);
	}
}
