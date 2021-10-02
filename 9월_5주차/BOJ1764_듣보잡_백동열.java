import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ1764_듣보잡_백동열 {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		HashSet<String> name_list = new HashSet<>();
		ArrayList<String> result_list = new ArrayList<>();
		
		for (int i = 0; i < n; i++) {
			name_list.add(br.readLine());
		}
		
		for (int i = 0; i < m; i++) {
			String str = br.readLine();
			
			if (name_list.contains(str)) {
				result_list.add(str);
			}
		}
		
		Collections.sort(result_list);
		System.out.println(result_list.size());
		for (int i = 0; i < result_list.size(); i++) {
			System.out.println(result_list.get(i));
		}
	}

}
