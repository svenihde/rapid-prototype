package jcompaser;
// open & read file
import java.io.IOException;
import java.io.File;
//something else
import java.util.List;
import java.util.Iterator;
// Java XML Parser
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
// DOM
import org.w3c.dom.Document;
import org.xml.sax.SAXException;


public class JComparser {
    /* read the XML file, parse it and wrap it up for engine use and write it to DB */

    /* @TODO: do we want a webbased application -> makes sense
             therefor we need a webform in order to upload the file
     */
	public static void main(String[] args) {

		// TODO Auto-generated method stub
		//JDBCHandler jHandler = new JDBCHandler();
		try {
			File BPMNXML = new File("./" + args[1]);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(BPMNXML);
			doc.getDocumentElement().normalize();
			System.out.println("Root Element:"
					+ doc.getDocumentElement().getNodeName());
			//fillTables(doc, jHandler);
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			printErrorMessage(e);
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			printErrorMessage(e);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			printErrorMessage(e);
		}
    }

	private static void fillTables(Document doc, JDBCHandler jHandler) {
		// TODO Auto-generated method stub
		fillActivity(doc, jHandler);
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
		
	}

	private static void fillSequenceflow(Document doc, JDBCHandler jHandler) {
		// TODO Auto-generated method stub
		
	}

	private static void fillScenario(Document doc, JDBCHandler jHandler) {
		// TODO Auto-generated method stub
		
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
		
	}

	private static void fillFragment(Document doc, JDBCHandler jHandler) {
		// TODO Auto-generated method stub
		
	}

	private static void fillEvent(Document doc, JDBCHandler jHandler) {
		// TODO Auto-generated method stub
		
	}

	private static void fillDataObject(Document doc, JDBCHandler jHandler) {
		// TODO Auto-generated method stub
		
	}

	private static void fillAssociation(Document doc, JDBCHandler jHandler) {
		// TODO Auto-generated method stub
		
	}

	private static void fillActivity(Document doc, JDBCHandler jHandler) {
		// TODO Auto-generated method stub
		
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
