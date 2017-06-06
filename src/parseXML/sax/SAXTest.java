package parseXML.sax;

import java.io.*;
import java.net.*;
import javax.xml.parsers.*;
import org.xml.sax.*;
import org.xml.sax.helpers.*;

/**
 * This program demonstrates how to use a SAX parser. The program prints all hyperlinks of an
 * XHTML web page. <br>
 * Usage: java sax.SAXTest URL
 * @version 1.00 2001-09-29
 * @author Cay Horstmann
 */
public class SAXTest
{
	public static void main(String[] args) throws Exception
	{
		String url;
		if (args.length == 0)
		{
			url = "http://www.w3c.org";
			System.out.println("Using " + url);
		}
		else url = args[0];

		//覆盖DefaultHandler的startElement方法，识别输入流中带有herf属性的a元素
		DefaultHandler handler = new DefaultHandler()
		{
			public void startElement(String namespaceURI, String lname, String qname, Attributes attrs)
			{
				if (lname.equals("a") && attrs != null)
				{
					for (int i = 0; i < attrs.getLength(); i++)
					{
						String aname = attrs.getLocalName(i);
						if (aname.equals("href")) System.out.println(attrs.getValue(i));
					}
				}
			}
		};

//		获得一个SAXParser，设置相关属性
		SAXParserFactory factory = SAXParserFactory.newInstance();
		factory.setNamespaceAware(true);
		factory.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
		SAXParser saxParser = factory.newSAXParser();
		InputStream in = new URL(url).openStream();
//		使用URL输入流和自定义的handler进行解析
		saxParser.parse(in, handler);
	}
}
