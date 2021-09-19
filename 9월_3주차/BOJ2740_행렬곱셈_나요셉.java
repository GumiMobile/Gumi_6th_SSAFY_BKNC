package com.js.pekah.algorithms.d0918;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2740_행렬곱셈_나요셉 {
	static int a[][];
	static int b[][];
	static int result[][];
	static int row, col;
	static int row2, col2;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		
		a = new int[row][col];
		
		for (int i = 0; i < row; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < col; j++) {
				a[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		
		row2 = Integer.parseInt(st.nextToken());
		col2 = Integer.parseInt(st.nextToken());
		
		b = new int[row2][col2];
		
		for (int i = 0; i < row2; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < col2; j++) {
				b[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		result = new int[row][col2];
		
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col2; j++) {
				int sum = 0;
				for (int k = 0; k < col; k++) {
					sum += a[i][k] * b[k][j];
				}
				result[i][j] = sum;
			}
		}
		
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col2; j++) {
				System.out.print(result[i][j] + " ");
			}
			System.out.println();
		}
	}
}
