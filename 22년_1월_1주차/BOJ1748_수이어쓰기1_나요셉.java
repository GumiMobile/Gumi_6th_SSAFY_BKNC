package com.js.pekah.algorithms.d0109;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1748_수이어쓰기1_나요셉 {
	static int n;
	static int count;
	static int result;
	static int length;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		count = 1;
		result = 0;
		length = 10;
		
		for (int i = 1; i <= n; i++) {
			if (i == length) {
				count++;
				length *= 10;
			}
			result += count;
		}
		
		System.out.println(result);
	}
}
