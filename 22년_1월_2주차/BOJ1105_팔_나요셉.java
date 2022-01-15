package js.pekah.algorithms.d220115;

import java.util.Scanner;

public class BOJ1105_팔_나요셉 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		String l = sc.next();
		String r = sc.next();
		
		int result = 0;
		
		if (l.length() == r.length()) {
			for (int i = 0; i < l.length(); i++) {
				if (l.charAt(i) == r.charAt(i) && l.charAt(i) == '8') {
					result++;
				} else if (l.charAt(i) != r.charAt(i)) {
					break;
				}
			}
		}
		
		System.out.println(result);
	}
}
