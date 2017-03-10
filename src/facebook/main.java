package facebook;

import java.util.*;

public class main {
	public static void main(String[] args) {
		Tree tr = new Tree();
		tr.insert(1);
		tr.insert(2);
		tr.insert(6);
		tr.insert(1);
		tr.insert(0);
		tr.insert(8);		
		//System.out.println(tr);
		//System.out.println(tr.getHeight());
		List<String> list = tr.binaryTreePaths();
		for (String s : list) {
			System.out.println(s);
		}
		
		String a = "12345";
		String b = a.substring(2) + a.substring(0,2);
		System.out.println(b);

		
		System.out.println(rotate(a,2));
		
	}

	public static String rotate(String a, int r) {
		char temp;

		for (int i=0; i<r; i++) {
			temp = a.charAt(0);
			a = a.substring(1) + temp;
		}
		
		return a;
	}
	
	public static String rotate(int[] a, int r) {
		
		
		return a;
	}

}