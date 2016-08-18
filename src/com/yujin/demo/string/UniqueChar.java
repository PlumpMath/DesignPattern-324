package com.yujin.demo.string;

/**
 * 实现一个算法来判断一个字符串中的字符是否唯一
 * 
 * 首先，你可以问面试官，构成字符串的字符集有多大？是ASCII字符，还是只是26个字母？ 
 * 还是有更大的字符集，对于不同的情况，我们可能会有不同的解决方案。
 * @author yujin
 *
 */
public class UniqueChar {

	public boolean isUnique1(String s) {
		boolean[] a = new boolean[256];
		for (int i = 0; i < a.length; i++) {
			System.out.print(" a[" + i +"]:" + a[i]);
		}
		for (int j = 0; j < a.length; j++) {
			
		}
		return true;
	}
	/**
	 * 如果字符集只是a-z或是A-Z，那就更好了，用位运算只需要一个整数即可。
	 * @param s
	 * @return
	 */
	public boolean isUnique3(String s) {
		int check = 0;
		int length = s.length();
		char[] chs = s.toCharArray();
		for (int i = 0; i < length; i++) {
			int  v = (int)(chs[i] - 'a');
			System.out.println("v:" + v);
			//if (check & (1 << v)) return false;
			check |= (1<<v);
		}
		return false;
	}
	public static void main(String[] args) {
		char c = '1';
		int intC = c - '0';
		System.out.println(intC);
		float a = 2.8000023f;
		System.out.println(a/1000);
		
		String temp = "200098-00-0023";
		temp = temp.substring(0, 5);
		System.out.println(temp);
		
		StringBuffer sb = new StringBuffer();
		sb.append("" + null);
	}
}
