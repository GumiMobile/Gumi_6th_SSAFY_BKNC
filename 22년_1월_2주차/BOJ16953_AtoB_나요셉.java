package com.js.pekah.algorithms.d0113;

import java.util.Scanner;

public class BOJ16953_AtoB_나요셉 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		long a = sc.nextInt();
		long b = sc.nextInt();
		
		int result = 1;
		
		while (a != b) {
			if (b < a) {
				result = -1;
				break;
			}
			
			String str = Long.toString(b);
			
			if (str.charAt(str.length() - 1) != '1' && b % 2 != 0) {
				result = -1;
				break;
			}
			
			if (b % 2 == 0) {
				b /= 2;
			} else {
				str = str.substring(0, str.length() - 1);
				b = Long.parseLong(str);
			}
			
			result++;
		}
		
		System.out.println(result);
	}
}
