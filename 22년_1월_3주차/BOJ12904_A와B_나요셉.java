package com.js.pekah.algorithms.d0117;

import java.util.Scanner;

public class BOJ12904_A와B_나요셉 {
	static String s, t;
	static int result;
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		s = sc.next();
		t = sc.next();
			
		while (true) {
			
			if (s.length() == t.length()) {
				if (s.equals(t)) result = 1;
				break;
			}
			
			char c = t.charAt(t.length() - 1);
			
			t = t.substring(0, t.length() - 1);
			
			if (c == 'B') {
				StringBuffer sb = new StringBuffer(t);
				t = sb.reverse().toString();
			}
			
		}
		
		System.out.println(result);
	}
}
