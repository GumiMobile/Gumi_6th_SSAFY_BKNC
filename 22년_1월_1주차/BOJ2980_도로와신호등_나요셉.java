package com.js.pekah.algorithms.d0103;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2980_도로와신호등_나요셉 {
	static int n, l;
	static int arr[][];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		arr = new int[l+1][2];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			
			arr[d][0] = r;
			arr[d][1] = g;
		}
		
		int t = 1;
		for (int i = 1; i <= l; i++) {
			if (arr[i][0] != 0) {
				int x = t % (arr[i][0] + arr[i][1]);
				if (x >= 0 && x <= arr[i][0]) {
					t += arr[i][0] - x;
				}
			}
			t++;
		}
		
		System.out.println(t - 1);
	}
}
