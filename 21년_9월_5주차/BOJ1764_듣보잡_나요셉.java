package com.js.pekah.algorithms.d1004;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ1764_듣보잡_나요셉 {
	static int N, M;
	static String arr[];
	static int start, end, mid;
	static List<String> result;
	
	public static void solve(String target) {
		start = 0;
		end = N-1;
		
		while (start <= end) {
			mid = (start + end) / 2;
			
			if (arr[mid].equals(target)) {
				result.add(target);
				return;
			} else if (arr[mid].compareTo(target) == 0) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new String[N];
		result = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			arr[i] = br.readLine();
		}
		
		Arrays.sort(arr);
		
		for (int i = 0; i < M; i++) {
			String target = br.readLine();
			solve(target);
		}
		
		Collections.sort(result);
		
		System.out.println(result.size());
		for (String s : result) {
			System.out.println(s);
		}
	}
}
