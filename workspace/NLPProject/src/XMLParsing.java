
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

import java.io.File;
import java.io.FileWriter;
 
public class XMLParsing {
 
  public static void main(String args[]) {
 
    try {
 
	File inputxmlFile = new File("C:/Users/Shruti/Desktop/Maritime.xml");
	DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	Document doc = dBuilder.parse(inputxmlFile);
 
	System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
 
	NodeList nl = doc.getElementsByTagName("Risk");
 
 	for (int i = 0; i < nl.getLength(); i++) {
 
		Node n = nl.item(i);
		//System.out.println("\nCurrent Element :" + n.getNodeName());
		if (n.getNodeType() == Node.ELEMENT_NODE) {
 
			Element e = (Element) n;
 
			System.out.println("Vessel Type : " + e.getElementsByTagName("vesseltype").item(0).getTextContent());
			System.out.println("Risk Type : " + e.getElementsByTagName("risktype").item(0).getTextContent());
			System.out.println("Risk Associates : " + e.getElementsByTagName("riskassoc").item(0).getTextContent());
			System.out.println("Maritime General Location : " + e.getElementsByTagName("genlocation").item(0).getTextContent());
			System.out.println("Maritime Absolute Location : " + e.getElementsByTagName("abslocation").item(0).getTextContent());
			System.out.println("Date : " + e.getElementsByTagName("date").item(0).getTextContent());
			 
			
			FileWriter writer = new FileWriter("C:/Users/Shruti/Desktop/Maritime.csv");
			writer.append(e.getElementsByTagName("vesseltype").item(0).getTextContent());
			writer.append(",");
			writer.append(e.getElementsByTagName("risktype").item(0).getTextContent());
			writer.append(",");
			writer.append(e.getElementsByTagName("riskassoc").item(0).getTextContent());
			writer.append(",");
			writer.append(e.getElementsByTagName("genlocation").item(0).getTextContent());
			writer.append(",");
			writer.append(e.getElementsByTagName("abslocation").item(0).getTextContent());
			writer.append(",");
			writer.append(e.getElementsByTagName("date").item(0).getTextContent());
			writer.close();
		}
	}
    } 
    
    catch (Exception e) 
    {
	e.printStackTrace();
    }
      
  }
 
}