package parseXML;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.*;
import javax.xml.xpath.*;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

public class ReadTest {
	
	private int indent = 0;

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, XPathExpressionException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		
//		String filePath = "src\\parseXML\\fontdialog.xml";
		String filePath = "src\\parseXML\\dom\\server.xml";
//		String filePath = "src\\parseXML\\xpath\\fontdialog.xml";
		
		File xmlSample = new File(filePath);
		Document doc = builder.parse(xmlSample);
		
		Element root = doc.getDocumentElement();
		
		ReadTest readTest = new ReadTest();
		readTest.getChildrenInfo(root);
		
		//XPath Demo
		System.out.println("------------------------------------------------------------------");
		XPathFactory xpfactory = XPathFactory.newInstance();
		XPath path = xpfactory.newXPath();
		String xpFilePath = "src\\parseXML\\fontdialog.xml";
		File xpSample = new File(xpFilePath);
		Document xDoc = builder.parse(xpSample);
		System.out.println(path.evaluate("gridbag/row/cell/bean/class", xDoc));
		
	}
	
	private void getChildrenInfo(Element parent) {
		putIndent();
		//标签名
		System.out.print("<" + parent.getTagName());
		//标签属性
		NamedNodeMap attributes = parent.getAttributes();
		for (int i = 0; i < attributes.getLength(); i++) {
			Node attribute = attributes.item(i);
			//属性名及属性值
			System.out.print(" " + attribute.getNodeName() + "=\"" + attribute.getNodeValue() + "\"");
		}
		if (parent.hasChildNodes())
			//标签内有其他元素，非自结束标签
			System.out.print(">\n");
		else
			//标签内没有其他元素，自结束标签
			System.out.print("/>\n");
		
		
		if(parent.hasChildNodes()) {
			NodeList childrens = parent.getChildNodes();
			for(int i = 0; i < childrens.getLength(); i++) {
				Node child = childrens.item(i);
				//该子元素类型为Element，可能包含其他子元素，递归遍历
				if(child instanceof Element) {
					Element childElement = (Element) child;
					indent++;
					getChildrenInfo(childElement);
				}
				//该子元素类型为Text，且不是换行符
				else if(child instanceof Text && !((Text) child).getData().contains("\n")) {
					putIndent();
					System.out.println(((Text) child).getData().trim());
				}
				//该子元素类型为Comment
				else if (child instanceof Comment) {
					putIndent();
					System.out.println("<!-- " + ((Comment) child).getData().trim() + " -->");
				}
			}
		}
		//非自结束标签，打印结束标签
		if (parent.hasChildNodes()) {
			putIndent();
			System.out.println("</" + parent.getTagName() + ">");
		}
		indent--;
		
	}
	
	private void putIndent() {
		for (int i = 0; i < indent; i++) {
			System.out.print("\t");
		}
	}
}
