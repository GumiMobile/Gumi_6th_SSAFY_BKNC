import java.util.Scanner;

public class BOJ2003_수들의합2_나요셉 {
	static int N;
	static long M;
	static int arr[];
	static int result, start, end, sum;
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextLong();
		arr = new int[N+1];
		
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		
		while (end <= N) {
			if (sum >= M) sum -= arr[start++];
			else if (sum < M) sum += arr[end++];
			
			if (sum == M) result++;
		}
		
		System.out.println(result);
	}
}
