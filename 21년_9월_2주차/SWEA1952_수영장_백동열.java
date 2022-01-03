import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA1952_수영장_백동열 {
	
	static int ticket[];
	static int arr[];
	static int result_min;
	
	
	static void findTotalArr(int month, int sum) {
		
		if (month > 12) {
			result_min = result_min > sum ? sum : result_min;
			return;
		}
		
		if (arr[month] == 0) {
			findTotalArr(month + 1, sum);
		} else {
			
			findTotalArr(month + 1, sum + arr[month] * ticket[0]);
			
			findTotalArr(month + 1, sum + ticket[1]);
			
			findTotalArr(month + 3, sum + ticket[2]);
		}
		
	}
	
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		int result[] = new int[T + 1];
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			
			ticket = new int[4];
			arr = new int[13];
			result_min = Integer.MAX_VALUE;
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			
			for (int i = 0; i < 4; i++) {
				ticket[i] = Integer.parseInt(st.nextToken());
			}
			
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			for (int i = 1; i <= 12; i++) {
				arr[i] = Integer.parseInt(st2.nextToken());
			}
			
			result_min = ticket[3];
			
			findTotalArr(1, 0);
			
			
			result[test_case] = result_min;
			
		}
		
		for (int i = 1; i <= T; i++) {
			System.out.print("#" + i + " " + result[i]);
			System.out.println();
		}
		
	}
}
