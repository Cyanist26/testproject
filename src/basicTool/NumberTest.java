package basicTool;

public class NumberTest {
	public static void main(String[] args) {
		try {
			final class Inner{
				Integer i = 5;
				Integer i2 = 10;
				Long l = i.longValue();
				int resi = i.compareTo(i2);
				Integer valof = Integer.valueOf(15);
				Integer parse = Integer.parseInt("10");
				
				public Integer getI() {
					return i;
				}
				public Integer getI2() {
					return i2;
				}
				public Long getL() {
					return l;
				}
				public int getResi() {
					return resi;
				}
				public Integer getValof() {
					return valof;
				}
				public Integer getParse() {
					return parse;
				}
			}
			Inner in = new Inner();
			System.out.println(in.getI());
			System.out.println(in.getI2());
			System.out.println(in.getL());
			System.out.println(in.getResi());
			System.out.println(in.getValof());
			System.out.println(in.getParse());
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
