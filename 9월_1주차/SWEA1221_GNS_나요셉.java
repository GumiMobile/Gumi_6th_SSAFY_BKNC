package com.ssafy.algorithm.d0902;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA1221_GNS_나요셉 {
	static int N;
	static String tc;
	static String arr[] = {"ZRO", "ONE", "TWO", "THR", "FOR", "FIV", "SIX", "SVN", "EGT", "NIN"};
	static int count[];
	static String num = "";
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			tc = st.nextToken();
			N = Integer.parseInt(st.nextToken());
			count = new int[10];
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				num = st.nextToken();
				
				switch(num) {
				case "ZRO": count[0]++; break;
				case "ONE": count[1]++; break;
				case "TWO": count[2]++; break;
				case "THR": count[3]++; break;
				case "FOR": count[4]++; break;
				case "FIV": count[5]++; break;
				case "SIX": count[6]++; break;
				case "SVN": count[7]++; break;
				case "EGT": count[8]++; break;
				case "NIN": count[9]++; break;
				}
			}
			
			System.out.println(tc);
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < count[i]; j++) {
					System.out.print(arr[i] + " ");
				}
			}
			System.out.println();
		}
	}
}
