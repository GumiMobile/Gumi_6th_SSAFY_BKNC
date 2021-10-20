import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2559_수열_백동열 {
	
	private static int N;
	private static int K;
	private static int arr[];

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int start = 0;
		int end = K - 1;
		int result = Integer.MIN_VALUE;
		
		while(end < N) {
			
			int sum = 0;
			
			for (int i = start; i <= end; i++) {
				sum += arr[i];
			}
			
			result = result < sum ? sum : result;
			
			start++;
			end++;
		}
		
		System.out.println(result);
		
	}
	
}
