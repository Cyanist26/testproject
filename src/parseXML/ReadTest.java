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
//		String filePath = "src\\parseXML\\dom\\server.xml";
		String filePath = "src\\parseXML\\xpath\\fontdialog.xml";
		
		File xmlSample = new File(filePath);
		Document doc = builder.parse(xmlSample);
		
		Element root = doc.getDocumentElement();
		
		ReadTest readTest = new ReadTest();
		readTest.getChildrenInfo(root);
		
		System.out.println("------------------------------------------------------------------");
		XPathFactory xpfactory = XPathFactory.newInstance();
		XPath path = xpfactory.newXPath();
		System.out.println(path.evaluate("gridbag/row/cell/bean/class", doc));
		
	}
	
	private void getChildrenInfo(Element parent) {
		putIndent();
		//标签名
		System.out.print("<" + parent.getTagName());
		NamedNodeMap attributes = parent.getAttributes();
		for (int i = 0; i < attributes.getLength(); i++) {
			Node attribute = attributes.item(i);
			//属性名及属性值
			System.out.print(" " + attribute.getNodeName() + "=\"" + attribute.getNodeValue() + "\"");
		}
		System.out.print(">\n");
		
		if(parent.hasChildNodes()) {
			NodeList childrens = parent.getChildNodes();
			for(int i = 0; i < childrens.getLength(); i++) {
				Node child = childrens.item(i);
				if(child instanceof Element) {
					Element childElement = (Element) child;
					indent++;
					getChildrenInfo(childElement);
				} else if(!((Text) child).getData().contains("\n")){
					putIndent();
					//标签内容
					System.out.println(((Text) child).getData().trim());
				}
			}
		}
		
		
		putIndent();
		System.out.println("</" + parent.getTagName() + ">");
		indent--;
		
	}
	
	private void putIndent() {
		for (int i = 0; i < indent; i++) {
			System.out.print("\t");
		}
	}
}
