package jcompaser;

import com.sun.org.apache.xerces.internal.parsers.DOMParser;
import org.w3c.dom.NamedNodeMap;
import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Parser {
	/* parse the XML File */
	parsePCM() {
		JDBCHandler jHandler = new JDBCHandler();
		try {
			File BPMNXML = new File("PCM.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(BPMNXML);
			doc.getDocumentElement().normalize();
			System.out.println("Root Element:"
					+ doc.getDocumentElement().getNodeName());
			fillTables(doc, jHandler);
		} catch (ParserConfigurationException | SAXException | IOException e) {
			// TODO Auto-generated catch block
			printErrorMessage(e);
		}
	}
	private static void fillTables(Document doc, JDBCHandler jHandler) {
		// TODO Auto-generated method stub
		filluserTask(doc, jHandler);
		fillAssociation(doc, jHandler);
		fillDataObject(doc, jHandler);
		fillEvent(doc, jHandler);
		fillFragment(doc, jHandler);
		fillGateway(doc, jHandler);
		fillGatewayRule(doc, jHandler);
		fillProcessElement(doc, jHandler);
		fillReference(doc, jHandler);
		fillScenario(doc, jHandler);
		fillSequenceflow(doc, jHandler);
		fillSet(doc, jHandler);
	}

	private static void fillSet(Document doc, JDBCHandler jHandler) {
		// TODO Auto-generated method stub
		/* use doc to get the wanted elements & their attributes
		 * then use jHandler to call JDBC functions to put this information into database
		 * return
		 */
		System.out.println("1st");
		return;
		
	}

	private static void fillSequenceflow(Document doc, JDBCHandler jHandler) {
		// TODO Auto-generated method stub
		System.out.println("2nd");
		return;
		
	}

	private static void fillScenario(Document doc, JDBCHandler jHandler) {
		// TODO Auto-generated method stub
		NodeList nList = doc.getElementsByTagName("Scenario");
		if(nList.getLength() != 0) System.out.println("Scenarios detected"); 
		else System.out.println("No Scenarios found");
		for(int i = 0; i < nList.getLength(); i++){
			Node nNode = nList.item(i);
			Element eElement = (Element) nNode;
			String name = eElement.getElementsByTagName("name").item(0).getTextContent();
			String ter = eElement.getElementsByTagName("terminationCondition").item(0).getTextContent();
			System.out.println(eElement.getElementsByTagName("name").item(0).getTextContent());
			System.out.println(ter);
			jHandler.insertScenarioIntoDatabase(name, ter);
		}
	}

	private static void fillReference(Document doc, JDBCHandler jHandler) {
		// TODO Auto-generated method stub
		
	}

	private static void fillProcessElement(Document doc, JDBCHandler jHandler) {
		// TODO Auto-generated method stub
		
	}

	private static void fillGatewayRule(Document doc, JDBCHandler jHandler) {
		// TODO Auto-generated method stub
		
	}

	private static void fillGateway(Document doc, JDBCHandler jHandler) {
		// TODO Auto-generated method stub
		NodeList nList = doc.getElementsByTagName("Gateway");
		if(nList.getLength() != 0) System.out.println("Gateways detected"); 
		else System.out.println("No Gateways found");
		for(int i = 0; i < nList.getLength(); i++){
			Node nNode = nList.item(i);
			System.out.println("\nGateway: " + nNode.getNodeName());
			Element eElement = (Element) nNode;
			System.out.println(eElement.getTextContent());
			jHandler.insertGatewayIntoDatabase(eElement.getTextContent());
		}
	}

	private static void fillFragment(Document doc, JDBCHandler jHandler) {
		// TODO Auto-generated method stub
		
	}

	private static void fillEvent(Document doc, JDBCHandler jHandler) {
		// TODO Auto-generated method stub
		NodeList nList = doc.getElementsByTagName("Event");
		if(nList.getLength() != 0) System.out.println("Events detected"); 
		else System.out.println("No Events found");
		for(int i = 0; i < nList.getLength(); i++){
			Node nNode = nList.item(i);
			System.out.println("\nEvent: " + nNode.getNodeName());
			Element eElement = (Element) nNode;
			System.out.println(eElement.getTextContent());
			jHandler.insertEventIntoDatabase(eElement.getTextContent());
		}
	}

	private static void fillDataObject(Document doc, JDBCHandler jHandler) {
		// TODO Auto-generated method stub
		
	}

	private static void fillAssociation(Document doc, JDBCHandler jHandler) {
		// TODO Auto-generated method stub
		
	}

	private static void filluserTask(Document doc, JDBCHandler jHandler) {
		// TODO Auto-generated method stub
		NodeList nList = doc.getElementsByTagName("userTask");
		if(nList.getLength() != 0) System.out.println("Activities detected"); 
		else System.out.println("No Activities found");
		for(int i = 0; i < nList.getLength(); i++){
			Node nNode = nList.item(i);
			System.out.println("userTask: " + nNode.getNodeName());
			Element eElement = (Element) nNode;
			System.out.println(eElement.getAttribute("name"));
			jHandler.insertActivityIntoDatabase(eElement.getAttribute("name"));
		}
	}

	private static void printErrorMessage(Exception e) {
		// TODO Auto-generated method stub
		if (e.getClass().equals(ParserConfigurationException.class)) {
			System.out.println("no valid xml");
		} else if (e.getClass().equals(SAXException.class)) {
			System.out.println("could not not normalize xml");
		} else if (e.getClass().equals(IOException.class)) {
			System.out.println("no file found");
		} else {
			e.printStackTrace();
		}
	}
}
