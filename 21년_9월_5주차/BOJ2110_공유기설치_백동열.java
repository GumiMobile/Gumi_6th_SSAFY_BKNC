import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ2110_공유기설치_백동열 {
	
	private static int num;
	private static int modem;
	private static ArrayList<Integer> arr_list;


	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		num = Integer.parseInt(st.nextToken());
		modem = Integer.parseInt(st.nextToken());
		arr_list = new ArrayList<Integer>();
		
		for (int i = 0; i < num; i++) {
			int area = Integer.parseInt(br.readLine());
			arr_list.add(area);
		}
		
		arr_list.sort(null);
		
		int start = arr_list.get(0);
		int end = arr_list.get(arr_list.size() - 1) - arr_list.get(0);
		int result = 0;
		
		while(start <= end) {
			int mid = (start + end) / 2;
			int value = arr_list.get(0);
			int cnt = 1;
			
			for (int i = 1; i < num; i++) {
				if (arr_list.get(i) >= value + mid) {
					value = arr_list.get(i);
					cnt += 1;
				}
			}
			
			if (cnt >= modem) {
				start = mid + 1;
				result = mid;
			} else {
				end = mid - 1;
			}
		}
		
		System.out.println(result);
		
	}
	
}
