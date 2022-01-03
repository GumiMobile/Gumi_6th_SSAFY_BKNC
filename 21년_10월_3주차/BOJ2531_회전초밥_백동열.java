import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ2531_회전초밥_백동열 {
	
	private static int N, d, k, c;
	private static int arr[];
	private static HashSet<Integer> set_list;
	private static int result;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		
		result = 0;
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		
		int start = 0;
		
		int cnt = 0;
		
		while(cnt < arr.length) {
			
			set_list = new HashSet<Integer>();
			
			if (k + start <= arr.length) {
				for (int i = start; i < k + start; i++) {
					set_list.add(arr[i]);
				}
			} else {
				int exceed = k + start - arr.length;
				
				for (int i = start; i < arr.length; i++) {
					set_list.add(arr[i]);
				}
				for (int i = 0; i < exceed; i++) {
					set_list.add(arr[i]);
				}
			}
			
			if (set_list.contains(c)) {
				result = result < set_list.size() ? set_list.size() : result;
			} else {
				result = result < set_list.size() + 1 ? set_list.size() + 1 : result;
			}
		
			cnt++;
			start++;
		}
		
		System.out.println(result);
		
	}
}
