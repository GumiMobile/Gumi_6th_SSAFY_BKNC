import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA4008_숫자만들기_백동열 {
	
	static int N;
	static int num_arr[];
	static int cnt[];
	static int opt[];
	static int min;
	static int max;
	
	static void permutation(int index) {
		
		if (index == N - 1) {
			int sum = calc();
			
			if (min > sum) {
				min = sum;
			}
			if (max < sum) {
				max = sum;
			}
		}
		
		for (int i = 0; i < 4; i++) {
			if (cnt[i] > 0) {
				cnt[i]--;
				opt[index] = i;
				permutation(index + 1);
				cnt[i]++;
				
			}
		}
		
	}
	
	static int calc() {
		
		int sum = num_arr[0];
		
		int idx = 1;
		
		for (int i = 0; i < N - 1; i++) {
			switch(opt[i]) {
				case 0:
					sum += num_arr[idx++];
					break;
				case 1:
					sum -= num_arr[idx++];
					break;
				case 2:
					sum *= num_arr[idx++];
					break;
				case 3:
					sum /= num_arr[idx++];
					break;
			}
		}
		
		return sum;
		
	}

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		int result[] = new int[T + 1];
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
		
			N = Integer.parseInt(br.readLine());
			cnt = new int[4];
			num_arr = new int[N];
			max = Integer.MIN_VALUE;
			min = Integer.MAX_VALUE;
			opt = new int[N - 1];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 4; i++) {
				cnt[i] = Integer.parseInt(st.nextToken());
			}
			
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < N; i++) {
				num_arr[i] = Integer.parseInt(st2.nextToken());
			}
			
			permutation(0);
			
			result[test_case] = max - min;
		} 
		
		for (int i = 1; i <= T; i++) {
			System.out.print("#" + i + " " + result[i]);
			System.out.println();
		}
		
	}
	
}
