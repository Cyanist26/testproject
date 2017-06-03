package basicTool;

import java.util.regex.*;

public class RegexTest {
	
//	public static void main(String[] args) {
//		String line = "This order was placed for QT3000! OK?";
//		String pattern = "(.*)(\\d+)(.*)";
//		Pattern r = Pattern.compile(pattern);
//		Matcher m = r.matcher(line);
//		if (m.find( )) {
//			System.out.println("Found value: " + m.group(0) );
//			System.out.println("Found value: " + m.group(1) );
//			System.out.println("Found value: " + m.group(2) );
//			System.out.println("Found value: " + m.group(3) );
//		} else {
//			System.out.println("NO MATCH");
//		}
//	}
	
//	private static final String REGEX = "foo";
//	private static final String INPUT = "fooooooooooooooooo";
//	private static Pattern pattern;
//	private static Matcher matcher;
//
//	public static void main( String args[] ){
//		pattern = Pattern.compile(REGEX);
//		matcher = pattern.matcher(INPUT);
//
//		System.out.println("Current REGEX is: "+REGEX);
//		System.out.println("Current INPUT is: "+INPUT);
//		
//		System.out.println("lookingAt(): "+matcher.lookingAt());
//		System.out.println("matches(): "+matcher.matches());
//   }
	
	private static String REGEX = "a*b";
	private static String INPUT = "aabfooaabfooabfoob";
	private static String REPLACE = "-";
	public static void main(String[] args) {
		Pattern p = Pattern.compile(REGEX);
		// 获取 matcher 对象
		Matcher m = p.matcher(INPUT);
		StringBuffer sb = new StringBuffer();
		while(m.find()){
			m.appendReplacement(sb,REPLACE);
		}
		m.appendTail(sb);
		System.out.println(sb.toString());
	}
	
}
