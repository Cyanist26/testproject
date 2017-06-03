package basicTool;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTest {
	public static void main(String[] args) throws ParseException {
		/*格式化日期的输入输出*/
		Date testDate = new Date();
		System.out.println(testDate.toString());
		
		SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(ft.format(testDate));
		
		String timeStr = "2017-06-01 16:50:00";
		testDate = ft.parse(timeStr);
		System.out.println(testDate.toString());
		/*休眠与计算运行时间*/
		try {
			long start = System.currentTimeMillis( );
			System.out.println(new Date( ) + "\n");
			Thread.sleep(1000);
			System.out.println(new Date( ) + "\n");
			long end = System.currentTimeMillis( );
			long diff = end - start;
			System.out.println("Difference is : " + diff);
		} catch (Exception e) {
			System.out.println("Got an exception!");
		}
		
		Calendar c = Calendar.getInstance();
		c.set(2017, 5 - 1, 10);
		System.out.println(c.getTime());
	}
}
