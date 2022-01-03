import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ3273_두수의합_백동열 {
	
	private static int n;
	private static int x;
	private static ArrayList<Integer> arr_list;
	private static int result;
	
	private static void twoPointer() {
		
		int start = 0;
		int end = n - 1;
		
		while (true) {
			
			if (start >= end) {
				break;
			}
			
			int sum = arr_list.get(start) + arr_list.get(end);
			
			if (sum == x) {
				result++;
				start++;
				end--;
			} else if (sum < x) {
				start++;
			} else {
				end--;
			}
			
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		arr_list = new ArrayList<Integer>();
		
		result = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < n; i++) {
			arr_list.add(Integer.parseInt(st.nextToken()));
		}
		
		Collections.sort(arr_list);
		
		x = Integer.parseInt(br.readLine());
		
		twoPointer();
		
		System.out.println(result);
		
	}
}
