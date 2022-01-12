package com.js.pekah.algorithms.d0112;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1946_신입사원_나요셉 {
	static int n;
	static int arr[];
	static int grade;
	static int result;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());
		
		for (int tc = 0; tc < t; tc++) {
			n = Integer.parseInt(br.readLine());
			arr = new int[n+1];
			result = 1;
			
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				
				arr[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());	
			}
			
			grade = arr[1];
			
			for (int k = 1; k <= n; k++) {
				if (arr[k] < grade) {
					result++;
					grade = arr[k];
				}
			}
			
			System.out.println(result);
		}
	}
}
