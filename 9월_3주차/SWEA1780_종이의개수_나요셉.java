package com.js.pekah.algorithms.d0913;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA1780_종이의개수_나요셉 {
	static int N;
	static int arr[][];
	static int result[];
	
	public static void solve(int x, int y, int n) {
		
		boolean flag = true;
		int check = arr[x][y];
		for (int i = x; i < x + n; i++) {
			for (int j = y; j < y + n; j++) {
				if (arr[i][j] != check) {
					flag = false;
					break;
				}
			}
		}
		
		if (flag) result[arr[x][y] + 1]++;
		else {
			int next = n / 3;
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					solve(x + next * i, y + next * j, next);
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		result = new int[3];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		solve(0, 0, N);
		
		for (Integer i : result) {
			System.out.println(i);
		}
	}
}
