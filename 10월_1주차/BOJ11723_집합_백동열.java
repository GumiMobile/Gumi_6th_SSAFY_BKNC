import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ11723_집합_백동열 {
	
	private static HashSet<Integer> arr_list;
	private static StringBuilder sb = new StringBuilder();
	
	static void check(int num) {
		
		if (arr_list.contains(num)) {
			sb.append("1\n");
		} else {
			sb.append("0\n");
		}
	}
	
	static void add(int num) {
		arr_list.add(num);
	}
	
	static void remove(int num) {
		arr_list.remove(num);
	}
	
	static void toggle(int num) {
		if (arr_list.contains(num)) {
			arr_list.remove(num);
		} else {
			arr_list.add(num);
		}
	}
	
	static void all() {
		arr_list.clear();
		for (int i = 1; i <= 20; i++) {
			arr_list.add(i);
		}
	}
	
	static void empty() {
		arr_list.clear();
	}
	
	
	public static void main(String[] args) throws Exception {
		
		arr_list = new HashSet<Integer>();
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			String order = st.nextToken();
			
			switch(order) {
			case "add" :
				int add_n = Integer.parseInt(st.nextToken());
				add(add_n);
				break;
			case "remove" :
				int remove_n = Integer.parseInt(st.nextToken());
				remove(remove_n);
				break;
			case "check" :
				int check_n = Integer.parseInt(st.nextToken());
				check(check_n);
				break;
			case "toggle" :
				int toggle_n = Integer.parseInt(st.nextToken());
				toggle(toggle_n);
				break;
			case "all" :
				all();
				break;
			case "empty" :
				empty();
				break;
			default:
					break;
			}
		}
		
		
		System.out.println(sb.toString());
		
	}

}
