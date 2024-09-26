package xml_parsers_json_jackson.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Card {
    @JsonProperty("card_id")
    @XmlElement(name = "card_id")
    private int cardId;

    @JsonProperty("card_number")
    @XmlElement(name = "card_number")
    private String cardNumber;

    public int getCardId() {
        return cardId;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public Card() {
    }
}
