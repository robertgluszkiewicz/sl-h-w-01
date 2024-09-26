package xml_parsers_json_jackson.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Employee {
    @JsonProperty("employee_id")
    @XmlElement(name = "employee_id")
    private int employeeId;

    @JsonProperty("first_name")
    @XmlElement(name = "first_name")
    private String firstName;

    @JsonProperty("last_name")
    @XmlElement(name = "last_name")
    private String lastName;

    @JsonProperty("birth_date")
    @XmlElement(name = "birth_date")
    private String birthDate;

    public int getEmployeeId() {
        return employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public Employee() {
    }
}
