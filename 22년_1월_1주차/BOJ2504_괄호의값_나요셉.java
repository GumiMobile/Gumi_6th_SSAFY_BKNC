package js.pekah.algorithms.d220115;

import java.util.Scanner;
import java.util.Stack;

public class BOJ2504_괄호의값_나요셉 {
	static String str;
	static Stack<Character> stack;
	static int result;
	static int temp;
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		str = sc.next();
		stack = new Stack<>();
		temp = 1;
		
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			
			if (c == '(') {
				stack.add(c);
				temp *= 2;
			} else if (c == '[') {
				stack.add(c);
				temp *= 3;
			} else if (c == ')') {
				if (stack.size() == 0 || stack.get(stack.size() - 1) == '[') {
					result = 0;
					break;
				}
				
				if (str.charAt(i - 1) == '(') result += temp;
				
				stack.pop();
				temp /= 2;
				
			} else {
				if (stack.size() == 0 || stack.get(stack.size() - 1) == '(') {
					result = 0;
					break;
				}
				
				if (str.charAt(i - 1) == '[') result += temp;
				
				stack.pop();
				temp /= 3;
			}
		}
		
		if (stack.size() != 0) {
			System.out.println(0);
		} else {
			System.out.println(result);
		}
	}
}
