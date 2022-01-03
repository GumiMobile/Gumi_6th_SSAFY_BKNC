package com.js.pekah.algorithms.d1012;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ11723_집합_나요셉 {
	static int N;
	static String op;
	static int num;
	static int S;
	static StringBuilder sb;
	
	public static void solve(String op, int num) {
		switch(op) {
		case "add": {
			S |= (1 << num);
			break;
		}
		case "remove": {
			S &= ~(1 << num);
			break;
		}
		case "check": {
			if ((S & ( 1 << num)) == (1 << num)) sb.append(1);
			else sb.append(0);
			break;
		}
		case "toggle": {
			S ^= (1 << num);
			break;
		}
		case "all": {
			S = (1 << N) - 1;
			break;
		}
		case "empty": {
			S = 0;
			break;
		}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			op = st.nextToken();
			num = 0;
			
			if (!op.equals("all") && !op.equals("empty")) 
				num = Integer.parseInt(st.nextToken());
			
			solve(op, num);
		}
		
		System.out.println(sb);
	}
}
