package gui_xml;

import java.io.File;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import java.util.Date;
import java.util.Random;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class XMLcreator {

	public static void main(String[] args) {
		
		try {

			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

			// root elements
			Document doc = docBuilder.newDocument();
			Element rootElement = doc.createElement("Transaction");
			doc.appendChild(rootElement);

			// TransactionID elements
			Element transID = doc.createElement("TransactionID");
			transID.appendChild(doc.createTextNode("idTest"));
			rootElement.appendChild(transID);

			// set attribute to TransactionID element
			Attr attr = doc.createAttribute("id");
			attr.setValue("1");
			transID.setAttributeNode(attr);

			// shorten way
			// transID.setAttribute("id", "1");

			// Patient Name elements
			Element pname = doc.createElement("PatientName");
			pname.appendChild(doc.createTextNode("NameTest"));
			rootElement.appendChild(pname);

			// Patient PCP elements
			Element pcpname = doc.createElement("PatientPCP");
			pcpname.appendChild(doc.createTextNode("PCPnameTest"));
			rootElement.appendChild(pcpname);

			// Event elements
			Element eventName = doc.createElement("EventName");
			eventName.appendChild(doc.createTextNode("EventTest"));
			rootElement.appendChild(eventName);

			// Performed By elements
			Element performed = doc.createElement("PerformedBy");
			performed.appendChild(doc.createTextNode("PerformedByTest"));
			rootElement.appendChild(performed);
			
			// Event Date elements
			Element date = doc.createElement("EventDate");
			date.appendChild(doc.createTextNode("dateTest"));
			rootElement.appendChild(date);
			
			// Added Prescriptions elements
			Element addedPresc = doc.createElement("PrescriptionsAdded");
			addedPresc.appendChild(doc.createTextNode("addedPrescTest"));
			rootElement.appendChild(addedPresc);
			
			// Current Prescriptions elements
			Element currPresc = doc.createElement("CurrentPrescriptions");
			currPresc.appendChild(doc.createTextNode("currentPrecsTest"));
			rootElement.appendChild(currPresc);
			
			// Patient Conditions elements
			Element patientCond = doc.createElement("PatientConditions");
			rootElement.appendChild(patientCond);
			
			// conditions elements
			Element condition1 = doc.createElement("item");
			condition1.appendChild(doc.createTextNode("conditionsTest"));
			patientCond.appendChild(condition1);
			
			// Patient Medical History element
			Element medHist = doc.createElement("PatientMedicalHistory");
			rootElement.appendChild(medHist);
			
			// medical history ITEM element
			Element history1 = doc.createElement("item");
			history1.appendChild(doc.createTextNode("historyTest"));
			medHist.appendChild(history1);


			
			
			
			// write the content into xml file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File("C:/Users/Logan Murray/Desktop/CS programs/CSC 394/XML files/first.xml"));

			// Output to console for testing
			//StreamResult result = new StreamResult(System.out);

			transformer.transform(source, result);

			System.out.println("File saved!");

		  } catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		  } catch (TransformerException tfe) {
			tfe.printStackTrace();
		  }
		

	}

}
