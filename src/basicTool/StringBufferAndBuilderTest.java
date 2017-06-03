package basicTool;

public class StringBufferAndBuilderTest {
	public static void main(String args[]){
		StringBuffer sBuffer = new StringBuffer("test");
		System.out.println(sBuffer);
		sBuffer.append(" String Buffer");
		System.out.println(sBuffer);
		sBuffer.reverse();
		System.out.println(sBuffer); 
		sBuffer.reverse();
		sBuffer.delete(0, 2);
		System.out.println(sBuffer);
		sBuffer.replace(0, 2, "re");
		System.out.println(sBuffer);
		System.out.println(sBuffer.capacity());
		System.out.println(sBuffer.toString());
	}
}
