package jcomparser;

import java.io.IOException;
import java.io.File;
//something else
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
// Java XML Parser
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
// DOM
import org.apache.commons.fileupload.FileItem;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;


public class JComparser {

	public static void main(List pcm) {

		Connector jHandler = new Connector();
        jcomparser.Parser.parsePCM(pcm, jHandler);
    }
}
