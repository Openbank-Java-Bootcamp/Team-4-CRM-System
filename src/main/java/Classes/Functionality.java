package Classes;

import Enums.Industry;
import Enums.Product;
import Enums.Status;

import java.util.*;

public class Functionality {
    private static Map<Integer,Lead> leadMap;
    private static Map<Integer,Contact> contactMap;

    private static Map<Integer,Opportunity> opportunityMap;

    public Functionality() {
        this.leadMap = new HashMap<>();
        this.contactMap = new HashMap<>();
        this.opportunityMap = new HashMap<>();
    }

    public void processInput(String input){

    }

    public void createLead(Scanner scanner){
        System.out.println("Please insert the name of the new lead");
        String name = scanner.nextLine();
        System.out.println("Please insert the phone number of the new lead");
        String phoneNumber = scanner.nextLine();
        System.out.println("Please insert the email address of the new lead");
        String emailAddress = scanner.nextLine();
        System.out.println("Please insert the company the new lead works for");
        String companyName = scanner.nextLine();
        Lead lead = new Lead(name,phoneNumber,emailAddress,companyName);
        this.leadMap.put(lead.getId(),lead);
    }

    public void listIdName(){
        for(Map.Entry<Integer,Lead> entry : leadMap.entrySet()){
            Integer key = entry.getKey();
            String name = entry.getValue().getName();
            System.out.println(key + "=" + name + " ");
        }
    }

    public void leadDetail(int id){
        Lead leadToDisplay = leadMap.get(id);
        System.out.println(leadToDisplay.toString());
    }

    public void convertLead(int id, Scanner scanner){
        Lead leadToConvert = leadMap.get(id);
        Contact contact = new Contact(leadToConvert.getName(), leadToConvert.getPhoneNumber(), leadToConvert.getEmailAddress(), leadToConvert.getCompanyName());
        this.contactMap.put(contact.getId(),contact);
        System.out.println("Please insert the product of the new opportunity");
        Product product = Product.valueOf(scanner.nextLine());
        System.out.println("Please insert the quantity of the product");
        int quantity = scanner.nextInt();
        Opportunity opportunity = new Opportunity(product, quantity, contact, Status.OPEN);
        opportunityMap.put(opportunity.getId(), opportunity);
        System.out.println("Please insert the industry of the company");
        Industry industry = Industry.valueOf(scanner.nextLine());
        System.out.println("Please insert the number of employees of the company");
        int numberOfEmployees = scanner.nextInt();
        System.out.println("Please insert the city of the company");
        String city = scanner.nextLine();
        System.out.println("Please insert the country of the company");
        String country = scanner.nextLine();
        Account account = new Account(industry,numberOfEmployees,city,country, leadToConvert.getCompanyName());
        account.getContactList().add(contact);
        account.getOpportunityList().add(opportunity);
        leadMap.remove(id); //Leads are removed from the system once they have been successfully converted.
        //lo elimino del hashmap que es donde lo estoy "almacenando" para ser accedido por el usuario.
    }

    public void changeOppStatus(int id,Status status){
        opportunityMap.get(id).setStatus(status);
    }


}
