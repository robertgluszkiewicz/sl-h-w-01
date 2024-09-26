package xml_parsers_json_jackson;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import xml_parsers_json_jackson.model.Branch;

public class JSONParserByJackson {
    public static void main(String[] args) {
        try {
            File json = new File("src/main/resources/bank.json");
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(json);

            JsonNode accountsNode = rootNode.get("bank").get("accounts").get("account");
            System.out.println("Accounts details based on JsonNode.get() method from Jackson" + '\n');
            for (JsonNode account : accountsNode) {
                System.out.println("Account ID: " + account.get("account_id").asInt());
                System.out.println("Account number: " + account.get("account_number").asText());
                System.out.println("Balance: " + account.get("balance").asDouble());
                System.out.println("------------------------");
            }

            JsonNode branchesNode = rootNode.get("bank").get("branches").get("branch");
            System.out.println();
            System.out.println("Branches details based on created object getters" + '\n');
            for (JsonNode branchNode : branchesNode) {
                Branch branch = objectMapper.treeToValue(branchNode, Branch.class);
                System.out.println("Country: " + branch.getCountry());
                System.out.println("City: " + branch.getCity());
                System.out.println("Number of employees: " + branch.getEmployeesNumber());
                System.out.println("------------------------");
            }
        } catch (IOException e) {
            System.out.println("JSON file tree reading error: " + e.getMessage());
        }
    }
}
