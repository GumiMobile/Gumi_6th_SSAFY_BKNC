package com.js.pekah.algorithms.d0918;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ18222_투에모스문자열_나요셉 {
	static long N;
	
	public static long solve(long n) {
		if (n == 0) return 0;
		if (n == 1) return 1;
		
		if (n % 2 != 0) return 1 - solve(n/2);
		else return solve(n/2);
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Long.parseLong(br.readLine());
		
		System.out.println(solve(N-1));
	}
}
