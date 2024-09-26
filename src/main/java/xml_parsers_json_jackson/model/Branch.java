package xml_parsers_json_jackson.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Branch {
    @JsonProperty("country")
    @XmlElement(name = "country")
    private String country;

    @JsonProperty("city")
    @XmlElement(name = "city")
    private String city;

    @JsonProperty("employees_number")
    @XmlElement(name = "employees_number")
    private int employeesNumber;

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public int getEmployeesNumber() {
        return employeesNumber;
    }

    public Branch() {
    }
}
