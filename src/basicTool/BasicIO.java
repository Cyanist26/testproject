package basicTool;

import java.io.*;

public class BasicIO {
	
//	public static void main(String args[]) throws IOException
//	{
//		char c;
//		// 使用 System.in 创建 BufferedReader 
//		BufferedReader br = new BufferedReader(new 
//				InputStreamReader(System.in));
//		System.out.println("Enter characters, 'q' to quit.");
//		// 读取字符
//		do {
//			c = (char) br.read();
//			System.out.println(c);
//		} while(c != 'q');
//	}
	
//	public static void main(String args[]) throws IOException
//	{
//		// 使用 System.in 创建 BufferedReader 
//		BufferedReader br = new BufferedReader(new
//				InputStreamReader(System.in));
//		String str;
//		System.out.println("Enter lines of text.");
//		System.out.println("Enter 'end' to quit.");
//		do {
//			str = br.readLine();
//			System.out.println(str);
//		} while(!str.equals("end"));
//	}
	
	public static void main(String[] args) {
		int nDisks = 5;
		doTowers(nDisks, 'A', 'B', 'C');
	}
	public static void doTowers(int topN, char from, char inter, char to) {
		if (topN == 1){
			System.out.println("Disk 1 from "
					+ from + " to " + to);
		}else {
			doTowers(topN - 1, from, to, inter);
			System.out.println("Disk "
					+ topN + " from " + from + " to " + to);
			doTowers(topN - 1, inter, from, to);
		}
	}
	
}
