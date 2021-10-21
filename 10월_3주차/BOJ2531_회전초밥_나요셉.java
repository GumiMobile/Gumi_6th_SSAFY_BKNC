package com.js.pekah.algorithms.d1021;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2531_회전초밥_나요셉 {
	static int N, d, k, c;
	static int arr[];
	static int visited[];
	static int result, max;
	
	static int solve() {
		for (int i = 0; i < k; i++) {
			if (visited[arr[i]] == 0) max++;
			visited[arr[i]]++;
		}
		
		result = max;
		
		for (int i = 1; i < N; i++) {
			if (result <= max) {
				if (visited[c] == 0) result = max + 1;
				else result = max;
			}
			
			visited[arr[i-1]]--;
			
			if (visited[arr[i-1]] == 0) max--;
			
			if (visited[arr[(i+k-1) % N]] == 0) max++;
			visited[arr[(i+k-1) % N]]++;
		}
		
		return result;
		
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		 
		N = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        arr = new int[N];
        
        for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
        
        visited = new int[d + 1];
        
        System.out.println(solve());
	}
}
