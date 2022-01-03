import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA1221_GNS_백동열 {
	
	static String number[] = {"ZRO", "ONE", "TWO", "THR", "FOR", "FIV", "SIX", "SVN", "EGT", "NIN"};
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		String result[] = new String[T + 1];
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
		
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			
			String string_num = st1.nextToken();
			int num = Integer.parseInt(st1.nextToken());
			int arr[] = new int[num];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < num; i++) {
				String str = st.nextToken();
				switch(str) {
				case "ZRO":
					arr[i] = 0;
					break;
				case "ONE":
					arr[i] = 1;
					break;
				case "TWO":
					arr[i] = 2;
					break;
				case "THR":
					arr[i] = 3;
					break;
				case "FOR":
					arr[i] = 4;
					break;
				case "FIV":
					arr[i] = 5;
					break;
				case "SIX":
					arr[i] = 6;
					break;
				case "SVN":
					arr[i] = 7;
					break;
				case "EGT":
					arr[i] = 8;
					break;
				case "NIN":
					arr[i] = 9;
					break;
				}
			}
			
			Arrays.sort(arr);
			
			String result_str = "";
			
			for (int i = 0; i < num; i++) {
				result_str += number[arr[i]] + " ";
			}
			
			
			result[test_case] = result_str;

		}
		
		for (int i = 1; i <= T; i++) {
			System.out.println("#" + i);
			System.out.println(result[i]);
		}
		
	}
}
