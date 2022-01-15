package js.pekah.algorithms.d220115;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Meeting implements Comparable<Meeting> {
	int start;
	int end;
	
	Meeting (int start, int end) {
		this.start = start;
		this.end = end;
	}
	
	@Override
	public int compareTo(Meeting m) {
		if (this.end > m.end) return 1;
		else if (this.end == m.end) {
			if (this.start > m.start) return 1;
			else return -1;
		}
		else return -1;
	}
}

public class BOJ1931_회의실배정_나요셉 {
	static int n;
	static Meeting arr[];
	static int count;
	static int cur_end;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		arr = new Meeting[n];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			
			arr[i] = new Meeting(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			
		}
		
		Arrays.sort(arr);
		
		count = 1;
		cur_end = arr[0].end;
		for (int i = 1; i < arr.length; i++) {
			Meeting next = arr[i];
			
			if (cur_end <= next.start) {
				cur_end = next.end;
				count++;
			}
		}
		
		System.out.println(count);
	}
}
