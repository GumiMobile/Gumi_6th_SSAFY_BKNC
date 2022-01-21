package com.js.pekah.algorithms.d0121;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ1339_단어수학_나요셉 {
	static int n;
	static String arr[];
	static int num[];
	static int result;
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		arr = new String[n];
		num = new int[26];
		
		for (int i = 0; i < n; i++) {
			arr[i] = sc.next();
		}
		
		for (int i = 0; i < n; i++) {
			String temp = arr[i];
			for (int j = 0; j < temp.length(); j++) {
				num[(temp.charAt(j) - 65)] += (int) Math.pow(10,  (temp.length() - j - 1));
			}
		}
		
		Arrays.sort(num);
		
		int k = 9;
		for (int i = 25; i >= 0; i--) {
			if (num[i] == 0) break;
			
			result += num[i] * k;
			k--;
		}
		
		System.out.println(result);
	}
}
