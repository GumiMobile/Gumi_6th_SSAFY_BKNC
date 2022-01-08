package com.js.pekah.algorithms.d0108;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ15686_치킨배달_나요셉 {
	static int n, m, min;
	static int arr[][];
	static int chicken[];
	static List<Point> home, chick;
	
	public static int Search() {
		int ans = 0;
		
		for (int i = 0; i < home.size(); i++) {
			int sum = Integer.MAX_VALUE;
			
			for (int j = 0; j < chick.size(); j++) {
				if (chicken[j] == 1) {
					sum = Math.min(sum, Math.abs(home.get(i).x - chick.get(j).x)
							+ Math.abs(home.get(i).y - chick.get(j).y));
				}
			}
			
			ans += sum;
		}
		
		return ans;
	}
	
	public static void dfs(int idx, int cnt) {
		if (cnt == m) {
			min = Math.min(min, Search());
			return;
		}
		
		for (int i = idx + 1; i < chick.size(); i++) {
			chicken[i] = 1;
			dfs(i, cnt + 1);
			chicken[i] = 0;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[51][51];
		chicken = new int[14];
		home = new ArrayList<Point>();
		chick = new ArrayList<>();
		min = Integer.MAX_VALUE;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				
				if (arr[i][j] == 1) {
					home.add(new Point(i, j));
				} else if (arr[i][j] == 2) {
					chick.add(new Point(i, j));
				}
			}
		}
		
		dfs(-1, 0);
		
		System.out.println(min);
	}
}
