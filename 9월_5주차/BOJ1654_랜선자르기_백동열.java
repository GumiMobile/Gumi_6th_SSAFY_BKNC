import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ1654_랜선자르기_백동열 {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int k = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		ArrayList<Long> lan_list = new ArrayList<Long>();
		long result = Long.MIN_VALUE;
		
		
		for (int i = 0; i < k; i++) {
			lan_list.add(Long.parseLong(br.readLine()));
		}
		
		lan_list.sort(null);
		
		long max = lan_list.get(k);
		long min = 1;
		
		while(min <= max) {
			
			long mid = (min + max) / 2;
			
			long cnt = 0;
			
			for (int i = 0; i < k; i++) {
				cnt += lan_list.get(i) / mid;
			}
			
			if (cnt < n) {
				max = mid - 1;
			} else {
				min = mid + 1;
				result = result < mid ? mid : result;
			}
			
		}
		
		System.out.println(result);
		
		
	}

}
