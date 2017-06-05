package basicTool;

import java.util.Scanner;
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
	
//	private static String REGEX = "a*b";
//	private static String INPUT = "aabfooaabfooabfoob";
//	private static String REPLACE = "-";
//	public static void main(String[] args) {
//		Pattern p = Pattern.compile(REGEX);
//		// 获取 matcher 对象
//		Matcher m = p.matcher(INPUT);
//		StringBuffer sb = new StringBuffer();
//		while(m.find()){
//			m.appendReplacement(sb,REPLACE);
//		}
//		m.appendTail(sb);
//		System.out.println(sb.toString());
//	}
	
	public static void main(String[] args) throws PatternSyntaxException
	{
		Scanner in = new Scanner(System.in);
		System.out.println("Enter pattern: ");
		String patternString = in.nextLine();

		Pattern pattern = Pattern.compile(patternString);

		while (true)
		{
			System.out.println("Enter string to match: ");
			String input = in.nextLine();        
			if (input == null || input.equals("")) return;
			Matcher matcher = pattern.matcher(input);
			if (matcher.matches())
			{
				System.out.println("Match");
				int g = matcher.groupCount();
				if (g > 0)
				{
					for (int i = 0; i < input.length(); i++)
					{
						// Print any empty groups
						for (int j = 1; j <= g; j++)
							if (i == matcher.start(j) && i == matcher.end(j)) 
								System.out.print("()");        
						// Print ( for non-empty groups starting here
						for (int j = 1; j <= g; j++)
							if (i == matcher.start(j) && i != matcher.end(j)) 
								System.out.print('(');
						System.out.print(input.charAt(i));
						// Print ) for non-empty groups ending here
						for (int j = 1; j <= g; j++)
							if (i + 1 != matcher.start(j) && i + 1 == matcher.end(j)) 
								System.out.print(')');
					}
					System.out.println();
				}
			}
			else
				System.out.println("No match");
		}
	}
	
}
