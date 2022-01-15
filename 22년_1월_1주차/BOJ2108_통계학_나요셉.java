package js.pekah.algorithms.d220115;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BOJ2108_통계학_나요셉 {
	static int n;
	static int avg, mid, mst, len;
	static int arr[];
	static List<Integer> lst;
	static int num;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		arr = new int[8001];
		lst = new ArrayList<>();
		mst = Integer.MIN_VALUE;
		
		for (int i = 0; i < n; i++) {
			num = Integer.parseInt(br.readLine());
			
			avg += num;
			arr[num+4000]++;
			lst.add(num);
		}
		
		avg  = (int) Math.round((double) avg / n);
		
		Collections.sort(lst);
		mid = lst.get(lst.size() / 2);
		
		int max = 0;
		List<Integer> mst_lst = new ArrayList<>();
		
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
		}
		
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == max) {
				mst_lst.add(i);
			}
		}
		
		Collections.sort(mst_lst);
		
		if (mst_lst.size() >= 2) {
			mst = mst_lst.get(1);
		} else {
			mst = mst_lst.get(0);
		}
		
		len = lst.get(lst.size() - 1) - lst.get(0);
		
		System.out.println(avg);
		System.out.println(mid);
		System.out.println(mst-4000);
		System.out.println(len);
	}
}
