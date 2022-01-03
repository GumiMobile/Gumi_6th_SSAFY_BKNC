import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ12015_가장긴증가하는부분수열2_백동열 {
	
	private static int n;
	private static ArrayList<Integer> num_list;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		num_list = new ArrayList<Integer>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		num_list.add(0);
		
		for (int i = 0; i < n; i++) {
			int value = Integer.parseInt(st.nextToken());
			if (num_list.get(num_list.size() - 1) < value) {
				num_list.add(value);
			} else {
				int min = 0;
				int max = num_list.size() - 1;
				
				while (min < max) {
					int mid = (min + max) / 2;
					
					if (num_list.get(mid) >= value) {
						max = mid;
					} else {
						min = mid + 1;
					}
				}
				num_list.set(max, value);
			}
		}
		
		System.out.println(num_list.size() - 1);
		
	}

}
