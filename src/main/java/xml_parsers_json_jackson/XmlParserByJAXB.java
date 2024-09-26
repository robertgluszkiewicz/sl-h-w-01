package xml_parsers_json_jackson;

import java.io.File;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import xml_parsers_json_jackson.model.Bank;
import xml_parsers_json_jackson.model.Employee;

public class XmlParserByJAXB {
    public static void main(String[] args) {
        try {
            File xml = new File("src/main/resources/bank.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(Bank.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Bank bank = (Bank) jaxbUnmarshaller.unmarshal(xml);

            System.out.println("Employees:" + '\n');
            for (Employee employee : bank.getEmployees()) {
                System.out.println("Employee ID: " + employee.getEmployeeId());
                System.out.println("First name: " + employee.getFirstName());
                System.out.println("Last name: " + employee.getLastName());
                System.out.println("Birth date: " + employee.getBirthDate());
                System.out.println("------------------------");
            }
        } catch (JAXBException e) {
            System.out.println("Error: " + e.getMessage());;
        }
    }
}
