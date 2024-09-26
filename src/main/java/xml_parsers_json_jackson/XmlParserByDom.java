package xml_parsers_json_jackson;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XmlParserByDom {
    public static void main(String[] args) throws ParseException {
        try {
            File file = new File("src/main/resources/bank.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document =  builder.parse(file);
            NodeList employees = document.getElementsByTagName("employee");
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.US);

            for (int i = 0; i < employees.getLength(); i++) {
                Node node = employees.item(i);
                Element element = (Element) node;
                String employeeId = element.getElementsByTagName("employee_id").item(0).getTextContent();
                String first_name = element.getElementsByTagName("first_name").item(0).getTextContent();
                String last_name = element.getElementsByTagName("last_name").item(0).getTextContent();
                Date birth_date = formatter.parse(element.getElementsByTagName("birth_date").item(0).getTextContent());
                System.out.println("Employee ID: " + employeeId);
                System.out.println("First name: " + first_name);
                System.out.println("Last name: " + last_name);
                System.out.println("Birth date: " + birth_date);
                System.out.println("------------------------------------");
            }
        } catch (ParserConfigurationException | SAXException | IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
