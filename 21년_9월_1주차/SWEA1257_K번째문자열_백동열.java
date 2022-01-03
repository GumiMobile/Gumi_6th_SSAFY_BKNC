import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SWEA1257 {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		String result[] = new String[T + 1];
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			
			int index = Integer.parseInt(br.readLine());
			String input = br.readLine();
			
			String[] suffix_arr = new String[input.length()];
			int[] LCP = new int[input.length()];
			
			for (int i = 0; i < input.length(); i++) {
				suffix_arr[i] = input.substring(i);
			}
			
			Arrays.sort(suffix_arr);
			
			
			for (int i = 1; i < input.length(); i++) {
				String prev = suffix_arr[i - 1];
				String cur = suffix_arr[i];
				int j = 0;
				while(j < prev.length() && j < cur.length() && prev.charAt(j) == cur.charAt(j)) {
					j++;
				}
				LCP[i] = j;
			}
			
			String str = "";
			
			int cnt = 0;
			for (int i = 0; i < input.length(); i++) {
				cnt += suffix_arr[i].length() - LCP[i];
				if (cnt >= index) {
					str += suffix_arr[i].substring(0, suffix_arr[i].length() - (cnt - index));
					break;
				}
			}
			if (cnt < index) {
				str = "none";
			}
			
			result[test_case] = str;
			
		}
		
		for (int i = 1; i <= T; i++) {
			System.out.print("#" + i + " " + result[i]);
			System.out.println();
		}
		
	}

}
