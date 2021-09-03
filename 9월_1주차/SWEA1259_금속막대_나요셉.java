package com.ssafy.algorithm.d0903;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Bar implements Comparable {
	int x;
	int y;

	Bar(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	public int compareTo(Object o) {
		Bar b = (Bar) o;
		
		return this.y - b.y; // 암나사 기준 정렬
	}
	
}

public class SWEA1259_금속막대_나요셉 {
	static int N;
	static List<Bar> lst;
	static List<Point> p;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			lst = new ArrayList<>();
			p = new ArrayList<>();
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				lst.add(new Bar(x, y));
			}
			
			Collections.sort(lst);
			
			// 초기값
			Bar tmp = lst.get(0);
			lst.remove(0);
			p.add(new Point(tmp.x, tmp.y));
			
			// 대입되는 수 뒤에 붙이기
			for(int i = 0; i < lst.size(); i++) {
				Bar tmpL = lst.get(i);
				if (p.get(p.size()-1).y == tmpL.x) {
					p.add(new Point(tmpL.x, tmpL.y));
					lst.remove(i);
					i = -1;
				}
			}
			
			// 대입되는 수 앞에 붙이기
			for(int i = 0; i < lst.size(); i++) {
				Bar tmpL = lst.get(i);
				if (p.get(0).x == tmpL.y) {
					p.add(0, new Point(tmpL.x, tmpL.y));
					lst.remove(i);
					i = -1;
				}
			}
			
			System.out.print("#" + tc + " ");
			for (Point ps : p) System.out.print(ps.x + " " + ps.y + " ");
			System.out.println();
		}
	}
}
