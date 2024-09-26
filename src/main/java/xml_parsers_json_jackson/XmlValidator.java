package xml_parsers_json_jackson;

import java.io.File;
import java.io.IOException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;

public class XmlValidator {
    public static void main(String[] args) {
        try {
            String xmlFilePath = "src/main/resources/bank.xml";
            String xsdFilePath = "src/main/resources/bank.xsd";

            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(new File(xsdFilePath));
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(new File(xmlFilePath)));

            System.out.println("The XML file is valid according to the XSD schema");
        } catch (SAXException | IOException e) {
            System.out.println("XML file validation error: " + e.getMessage());
        }
    }
}
