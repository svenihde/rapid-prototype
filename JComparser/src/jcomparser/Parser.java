package jcomparser;

import com.sun.org.apache.xerces.internal.parsers.DOMParser;
import org.apache.commons.fileupload.FileItem;
import org.w3c.dom.NamedNodeMap;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.PrintWriter;
import java.util.List;

public class Parser {
	/* parse the XML File */
	public static void parsePCM(List pcm, Connector jHandler) {
		try {
            System.out.println(pcm.get(0));
            /* hand over uplaoded file to BPMXML */
			File BPMNXML = new File("");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(BPMNXML);
			doc.getDocumentElement().normalize();
			System.out.println("Root Element:"
					+ doc.getDocumentElement().getNodeName());
			fillTables(doc, jHandler);
		} catch (ParserConfigurationException e) {
			printErrorMessage(e);
		} catch (SAXException e) {
			printErrorMessage(e);
		} catch (IOException e) {
			printErrorMessage(e);
		}
    }
	private static void fillTables(Document doc, jcomparser.Connector jHandler) {
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

	private static void fillSet(Document doc, jcomparser.Connector jHandler) {
		/* use doc to get the wanted elements & their attributes
		 * then use jHandler to call JDBC functions to put this information into database
		 * return
		 */
		System.out.println("1st");
		return;
		
	}

	private static void fillSequenceflow(Document doc, jcomparser.Connector jHandler) {
		System.out.println("2nd");
		return;
		
	}

	private static void fillScenario(Document doc, jcomparser.Connector jHandler) {
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

	private static void fillReference(Document doc, jcomparser.Connector jHandler) {
		
	}

	private static void fillProcessElement(Document doc, jcomparser.Connector jHandler) {
		
	}

	private static void fillGatewayRule(Document doc, jcomparser.Connector jHandler) {
		
	}

	private static void fillGateway(Document doc, jcomparser.Connector jHandler) {
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

	private static void fillFragment(Document doc, jcomparser.Connector jHandler) {
		
	}

	private static void fillEvent(Document doc, jcomparser.Connector jHandler) {
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

	private static void fillDataObject(Document doc, jcomparser.Connector jHandler) {
		
	}

	private static void fillAssociation(Document doc, jcomparser.Connector jHandler) {
		
	}

	private static void filluserTask(Document doc, jcomparser.Connector jHandler) {
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
