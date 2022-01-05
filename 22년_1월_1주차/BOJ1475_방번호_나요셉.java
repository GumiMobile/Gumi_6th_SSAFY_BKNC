package com.js.pekah.algorithms.d0105;

import java.util.Scanner;

public class BOJ1475_방번호_나요셉 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String n = Integer.toString(sc.nextInt());
		int arr[] = new int[10];
		int result = 0;
		
		for (int i = 0; i < n.length(); i++) {
			int num = n.charAt(i) - '0';
			
			if (num == 9) {
				arr[6]++;
			} else {
				arr[num]++;
			}
		}
		
		if (arr[6] % 2 == 0)
			arr[6] /= 2;
		else
			arr[6] = (arr[6] / 2) + 1;
		
		for (int i = 0; i < arr.length; i++) {
			result = Math.max(result, arr[i]);
		}
		
		System.out.println(result);
	}
}
