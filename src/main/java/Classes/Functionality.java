package Classes;

import Enums.Industry;
import Enums.Product;
import Enums.Status;
import java.util.Locale;

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

    public static void setLeadMap(Map<Integer, Lead> leadMap) {
        Functionality.leadMap = leadMap;
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

    public void convertLead(Scanner scanner){
        //id
        int id = IdNumber(scanner);
        Lead leadToConvert = leadMap.get(id);
        System.out.println("Lead upgrade correctly!");
        //creation of the Contact
        Contact contact = new Contact(leadToConvert.getName(), leadToConvert.getPhoneNumber(), leadToConvert.getEmailAddress(), leadToConvert.getCompanyName());
        this.contactMap.put(contact.getId(),contact);
        System.out.println("Now lets create your account:");
        //product
        printEnum("product");
        Product product = productSelection(scanner);
        //quantity
        System.out.println("Please enter the quantity you want to purchase: ");
        int quantity = quantityNumber(scanner);
        //creation of the opportunity
        Opportunity opportunity = new Opportunity(product, quantity, contact, Status.OPEN);
        opportunityMap.put(opportunity.getId(), opportunity);
        //industry
        System.out.println("Please insert the industry of the company");
        printEnum("industry");
        Industry industry = industrySelection(scanner);
        //number of employee
        System.out.println("Please insert the number of employees of the company");
        int numberOfEmployees = quantityNumber(scanner);
        //city
        String country = countryInput(scanner);
        //country
        System.out.println("Please insert the city of the company");
        String city = scanner.next();
        //new account
        Account account = new Account(industry,numberOfEmployees,city,country, leadToConvert.getCompanyName());
        account.getContactList().add(contact);
        account.getOpportunityList().add(opportunity);
        leadMap.remove(id); //Leads are removed from the system once they have been successfully converted.
        //lo elimino del hashmap que es donde lo estoy "almacenando" para ser accedido por el usuario.
        System.out.println("Lead coverted correctly!");
    }

    public Industry industrySelection(Scanner scanner){
        Industry i;
        String industry = scanner.next().toUpperCase();
        switch (industry){
            case "PRODUCE":
                i = Industry.PRODUCE;
                System.out.println(i + " Selected!");
                break;
            case "ECOMMERCE":
                i = Industry.ECOMMERCE;
                System.out.println(i + " Selected!");
                break;
            case "MANUFACTURING":
                i = Industry.MANUFACTURING;
                System.out.println(i + " Selected!");
                break;
            case "MEDICAL":
                i = Industry.MEDICAL;
                System.out.println(i + " Selected!");
                break;
            case "OTHER":
                i = Industry.OTHER;
                System.out.println(i + " Selected!");
                break;
            default:
                System.err.println("Invalid input. Please try again");
                i = industrySelection(scanner);
        }
        return i;
    }

    public Product productSelection(Scanner scanner){
        Product p;
        String product = scanner.next().toUpperCase();
        switch (product){
            case "HYBRID":
                p = Product.HYBRID;
                System.out.println(p+ " Selected!");
                break;
            case "FLATBED":
                p = Product.FLATBED;
                System.out.println(p+ " Selected!");
                break;
            case "BOX":
                p = Product.BOX;
                System.out.println(p+ " Selected!");
                break;
            default:
                System.err.println("Invalid input. Please try again");
                p = productSelection(scanner);
        }
        return p;
    }

    //Method for the verification that the ID belongs to an Lead
    public boolean validLeadId(int id){
        for (int k : leadMap.keySet()) {
            if (k == id) {
                return true;
            }
        }
        return false;
    }

    //Method that verifies that the id is lead and a String
    public int IdNumber(Scanner scanner){
        System.out.println("Please enter de ID of the lead you would like to convert");
        int id = 0;
        try {
            id = scanner.nextInt();
            while (!validLeadId(id)) {
                System.err.println("Lead ID not valid");
                id = scanner.nextInt();
            }
        }catch(Exception e){
            System.err.println("Invalid value. Please try again");
            scanner.next();
            id = IdNumber(scanner);
        }
        return id;
    }
    public int quantityNumber(Scanner scanner){
        int quantity = 0;
        try {
            quantity = scanner.nextInt();
            while (quantity < 1) {
                System.err.println("The number must be bigger than 1");
                quantity = scanner.nextInt();
            }
        }catch(Exception e){
            System.err.println("Invalid value. Please try again");
            scanner.next();
            quantity = quantityNumber(scanner);
        }
        return quantity;
    }

    public void changeOppStatus(int id,Status status){
        opportunityMap.get(id).setStatus(status);
    }


    //Method that prints the ENUMs by using a string of its name
    public static void printEnum(String s){
        System.out.println("This are the possible "+ s.toUpperCase() + " types: ");
        if (s.equalsIgnoreCase("Industry")) {
            Industry industries[] = Industry.values();
            for (Industry i : industries) {
                System.out.println("- " + i);
            }
        } else if (s.equalsIgnoreCase("Product")){
            Product products[] = Product.values();
            for (Product p : products) {
                System.out.println("- " + p);
            }
        } else if (s.equalsIgnoreCase("Status")){
            Status statuses[] = Status.values();
            for (Status st : statuses) {
                System.out.println("- " + st);
            }
        }
        System.out.println("Choose one by typing its name");
    }


    public static boolean validateCountry(String s) {

        String[] locales = Locale.getISOCountries();

        for (String countryCode : locales) {

            Locale obj = new Locale("", countryCode);

            if (s.equalsIgnoreCase(obj.getDisplayCountry(java.util.Locale.ENGLISH))) {
                return true;
            }
        }
        return false;
    }

    private static String countryInput(Scanner scanner){
        System.out.println("Please insert the country of the company");
        String city = scanner.next();
        while (!validateCountry(city)){
            System.err.println("Thats not a valid country. Please try again");
            city = scanner.next();
        }
        return city;
    }
}
