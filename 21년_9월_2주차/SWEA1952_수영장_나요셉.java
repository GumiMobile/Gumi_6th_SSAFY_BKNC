package com.ssafy.algorithm.d0906;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA1952_수영장_나요셉 {
	static int ticket[];
	static int arr[];
	static int min;
	
	public static void dfs(int price, int month) {
		if (month >= 12) {
			min = Math.min(min, price);
			return;
		}
		
		dfs(price + (arr[month] * ticket[0]), month + 1);
		dfs(price + ticket[1], month + 1);
		dfs(price + ticket[2], month + 3);
		dfs(price + ticket[3], month + 12);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			ticket = new int[4];
			arr = new int[12];
			min = Integer.MAX_VALUE;
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 4; i++) {
				ticket[i] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 12; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			dfs(0, 0);
			
			System.out.println("#" + tc + " " + min);
		}
	}
}
