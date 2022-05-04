package Classes;

import Enums.Industry;
import Enums.Product;
import Enums.Status;
import java.util.Locale;

import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class CRM {
    private static Map<Integer,Lead> leadMap;
    private static Map<Integer,Contact> contactMap;
    private static Map<Integer,Opportunity> opportunityMap;

    private static Menu menu = new Menu();

    public CRM() {
        this.leadMap = new HashMap<>();
        this.contactMap = new HashMap<>();
        this.opportunityMap = new HashMap<>();

    }



    public void processInput(String input){

    }

    public static void setLeadMap(Map<Integer, Lead> leadMap) {
        CRM.leadMap = leadMap;
    }

    public void createLead(Scanner scanner) {
        //Name
        System.out.println("Please insert the name of the new lead");
        String name = scanner.nextLine();
        boolean isNumber = false;
        while (isNumber==false) { //valida que no hayan numeros
            if(!name.matches(".*[0-9].*")){
                isNumber = true;
            }
            else{
                System.err.println("Please select a valid name.");
                name=scanner.nextLine();
            }
        }
        //Phone Number
        System.out.println("Please insert the phone number of the new lead");
        String phoneNumber = scanner.nextLine();
        boolean isWord = false;
        while (isWord==false) { //valida que solo hayan numeros y el tamaño 9
            if(phoneNumber.matches(".*[0-9].*") && phoneNumber.length()==9){
                isWord = true;
            }
            else{
                System.err.println("Please select a valid phone number.");
                phoneNumber=scanner.nextLine();
            }
        }
        //Email
        System.out.println("Please insert the email address of the new lead");
        String emailAddress = scanner.nextLine();
        boolean isEmail=false;
        while(isEmail==false){
            Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
            Matcher mather = pattern.matcher(emailAddress);
            if (mather.find()==true) {
                isEmail=true;
            }
            else{
                System.err.println("Please select a valid email.");
                emailAddress = scanner.nextLine();
                //createLead(scanner);
            }
        }
        //Company name
        System.out.println("Please insert the company the new lead works for");
        String companyName = scanner.nextLine(); //pueden haber letras y numeros

        Lead new_lead = new Lead (name, phoneNumber, emailAddress, companyName);

        leadMap.put(new_lead.getId(), new_lead);

        menu.displayMenu(scanner, this);
    }

    public void listIdName(){
        for(Map.Entry<Integer,Lead> entry : leadMap.entrySet()){
            Integer key = entry.getKey();
            String name = entry.getValue().getName();
            System.out.println(key + "=" + name + " ");
        }
    }

    public void leadDetail(Scanner scanner) {
        System.out.println("There are the Leads. Type an [id] for more details of that Lead");
        System.out.println();
        listIdName();

        System.out.println("Please, insert the id of the Lead");
        boolean idOk = false;
        while (!idOk) {
            try {
                int id = scanner.nextInt();
                if (leadMap.get(id) != null) {
                    System.out.println(leadMap.get(id).toString());
                    idOk = true;
                } else {
                    System.out.println("The entered id does not exist. Please, try again");
                    scanner.next();
                }
            } catch (Exception e) {
                System.out.println("The id entered is wrong. Please, try again");
                scanner.next();
            }

        }
        menu.displayMenu(scanner, this);
    }

    public void convertLead(Scanner scanner){
        System.out.println(Colors.GREEN_BOLD_BRIGHT + "You selected to upgrade a LEAD to an OPPORTUNITY" + Colors.RESET);
        //id
        int id = IdNumber(scanner);
        Lead leadToConvert = leadMap.get(id);
        //creation of the Contact
        Contact contact = new Contact(leadToConvert.getName(), leadToConvert.getPhoneNumber(), leadToConvert.getEmailAddress(), leadToConvert.getCompanyName());
        this.contactMap.put(contact.getId(),contact);
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
        System.out.println(Colors.GREEN_BOLD_BRIGHT +"Lead upgrade correctly!"+ Colors.RESET);
        menu.displayMenu(scanner, this);
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


    //Method that verifies that the id is lead and a String
    public int IdNumber(Scanner scanner){
        System.out.println("Please enter de " +  Colors.YELLOW_BOLD_BRIGHT + " [ID] " + Colors.RESET+ "of the lead you would like to upgrade: ");
        int id = 0;
        try {
            id = scanner.nextInt();
            boolean valid = leadMap.containsKey(id);
            while (!valid) {
                System.err.println("Lead ID not valid");
                id = scanner.nextInt();
                valid = leadMap.containsKey(id);
            }
        }catch(Exception e){
            System.err.println("That´s not a number. Please try again");
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
            System.err.println("That´s not a number. Please try again");
            scanner.next();
            quantity = quantityNumber(scanner);
        }
        return quantity;
    }

    public void changeOppStatus(Scanner scanner){
        System.out.println();
        System.out.println();
        System.out.println(Colors.GREEN_BOLD_BRIGHT + "You are going to change the status of an Opportunity");
        System.out.println(Colors.RESET + "Please, enter the commands" + Colors.YELLOW_BOLD_BRIGHT + " [close-lost id]"
                + Colors.RESET + " or " + Colors.YELLOW_BOLD_BRIGHT + "[close-won id]"
                + Colors.RESET + " with the id of the Opportunity you want to change");
        System.out.println("For example, if you wants to close lost the Opportunity with id \"4321\", you have to type" + Colors.YELLOW_BRIGHT + " [close-lost 4321]");

        Opportunity opportunity = new Opportunity();

        boolean idOk = false;
        boolean command = false;

        String[] typed = scanner.nextLine().toLowerCase().split(" ");

        while (!idOk && !command) {
            if (typed.length != 2) {
                System.out.println("The command entered is wrong. Please, try again");
                scanner.nextLine();
            } else {
                opportunity = opportunityMap.get(typed[1]);
                if (opportunity != null) {
                    command = true;
                }

                switch (typed[0]) {
                    case "close-lost":
                        opportunity.setStatus(Status.CLOSED_LOST);
                        command = true;
                        break;
                    case "close-won":
                        opportunity.setStatus(Status.CLOSED_WON);
                        command = true;
                        break;
                    default:
                        break;
                }
            }
        }
        menu.displayMenu(scanner, this);
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

    public static String countryInput(Scanner scanner){
        System.out.println("Please insert the country of the company");
        String city = scanner.next();
        while (!validateCountry(city)){
            System.err.println("Thats not a valid country. Please try again");
            city = scanner.next();
        }
        return city;
    }
}
