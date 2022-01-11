package com.js.pekah.algorithms.d0111;

import java.util.Scanner;

public class BOJ1052_물병_나요셉 {
	static int n, k;
	static int count;
	static int result;
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		k = sc.nextInt();
	
		while (true) {
			count = 0;
			int temp = n;
			while (temp != 0) {
				if (temp % 2 == 1) count++;
				temp /= 2;
			}
			
			if (count <= k) break;
			
			result++;
			n++;
		}
		
		System.out.println(result);
	}
}
