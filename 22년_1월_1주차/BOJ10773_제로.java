package com.js.pekah.algorithms.d0102;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ10773_제로 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		int k = sc.nextInt();
		List<Integer> list = new ArrayList<Integer>();
		
		for (int i = 0; i < k; i++) {
			int num = sc.nextInt();
			if (num != 0) {
				list.add(num);
			} else {
				list.remove(list.size() - 1);
			}
		}
		
		int result = 0;
		
		for (int i : list) {
			result += i;
		}
		
		System.out.println(result);
	}
}
