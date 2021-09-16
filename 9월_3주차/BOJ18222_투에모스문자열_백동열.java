import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ18222_투에모스문자열_백동열 {
	
	static long num;
	static long arr[];
	
	static int findNum(long n) {
		
		if (n == 1) {
			return 0;
		}
		
		long temp = 0;
		
		for (int i = 0; i < arr.length; i++) {
			if (n > arr[i])
				temp = arr[i];
			else
				break;
		}
		
		return 1 - findNum(n - temp);
		
		
	}
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		num = Long.parseLong(br.readLine());
		arr = new long[64];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (long) Math.pow(2, i);
		}
		
		
		System.out.println(findNum(num));
	}

}
