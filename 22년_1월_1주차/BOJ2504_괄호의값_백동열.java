package algorithm_220106;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ2504_괄호의값_백동열 {

    private static String str;

    private static int stackInner(Stack<String> stack, String a, String b, int num) {
        int result = 0;

        while(!stack.isEmpty()) {
            String recent = stack.peek();

            if (recent.equals(a)) {
                return -1;
            } else if (recent.equals(b)) {
                stack.pop();
                result *= num;
                stack.push(String.valueOf(result));
                break;
            } else {
                result += Integer.parseInt(stack.pop());
            }
        }

        return result;
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        str = br.readLine();
        Stack<String> stack = new Stack<>();
        int check = 0;
        int answer = 0;

        for (int i = 0; i < str.length(); i++) {
            char current = str.charAt(i);

            if (check == -1) {
                break;
            }

            if (current == '(' || current == '[') {
                stack.push(String.valueOf(current));
            } else {
                if (stack.isEmpty()) {
                    check = -1;
                    break;
                }

                if (current == ')') {
                    if (stack.peek().equals("(")) {
                        stack.pop();
                        stack.push("2");
                    } else {
                        check = stackInner(stack, "[", "(", 2);
                    }
                } else {
                    if (stack.peek().equals("[")) {
                        stack.pop();
                        stack.push("3");
                    } else {
                        check = stackInner(stack, "(", "[", 3);
                    }
                }
            }

        }

        while(!stack.isEmpty()) {
            if (stack.peek().equals("(") || stack.peek().equals(")") || stack.peek().equals("[") || stack.peek().equals("]")) {
                check = -1;
                break;
            }
            answer += Integer.parseInt(stack.pop());
        }

        if (check == -1) {
            System.out.println(0);
        } else {
            System.out.println(answer);
        }

    }

}
