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

    public CRM() {
        leadMap = new HashMap<>();
        contactMap = new HashMap<>();
        opportunityMap = new HashMap<>();
    }


    public void processInput(String input){

    }

    //================== SETTER =======================

    //================== SETTERS AND GETTERS =======================


    public static Map<Integer, Lead> getLeadMap() {
        return leadMap;
    }

    public static Map<Integer, Contact> getContactMap() {
        return contactMap;
    }

    public void setContactMap(Map<Integer, Contact> contactMap) {
        CRM.contactMap = contactMap;
    }

    public static Map<Integer, Opportunity> getOpportunityMap() {
        return opportunityMap;
    }

    public static void setOpportunityMap(Map<Integer, Opportunity> opportunityMap) {
        CRM.opportunityMap = opportunityMap;
    }

    public static void setLeadMap(Map<Integer, Lead> leadMap) {
      
        CRM.leadMap = leadMap;
    }

    //================= CREATE A LEAD ==================




    public void createLead(Scanner scanner) throws Exception {

        //Header of the method
        System.out.println();
        System.out.println(Colors.GREEN_BOLD_BRIGHT + "You have selected the \"Create a Lead\" option");
        System.out.println(Colors.YELLOW_BOLD_BRIGHT + "You must enter the data that will be requested below");
        System.out.println(Colors.RESET);

        Lead new_lead = new Lead (nameLead(scanner), phoneNumberLead(scanner), emailLead(scanner), companyNameLead(scanner));
        System.out.println(new_lead.getId());

        leadMap.put(new_lead.getId(), new_lead);


        //Foot of the method
        System.out.println();
        System.out.println(Colors.YELLOW_BOLD_BRIGHT + "You have inserted a Lead");
        Menu.enterToContinue(Colors.YELLOW_BOLD_BRIGHT + "Press ENTER to continue...");
        System.out.println();
        System.out.println(Colors.RESET + "---------------------------------------------------------------------------------");
        System.out.println();
        Menu.displayMenu(scanner, this);
    }
    public String nameLead(Scanner scanner) throws Exception {

        System.out.println("Please insert the name of the new lead");
        String name = scanner.nextLine();
        boolean isNumber = false;
        while (!isNumber) { //valida que no hayan numeros
             if(!name.matches(".*[0-9].*")){
                 isNumber = true;
             }
             else{
                 System.err.println("Please select a valid name");
                 name=scanner.nextLine();
             }
        }
        return name;
    }
    public String phoneNumberLead(Scanner scanner){
        System.out.println("Please insert the phone number of the new lead");
        String phoneNumber = scanner.nextLine();
        boolean isWord = false;
        while (!isWord) { //valida que solo hayan numeros y el tamaño 9
            if(phoneNumber.matches(".*[0-9].*") && phoneNumber.length()==9){
                isWord = true;
            }
            else{
                System.err.println("Please select a valid phone number");
                phoneNumber=scanner.nextLine();
            }
        }
        return phoneNumber;
    }
    public String emailLead(Scanner scanner){
        System.out.println("Please insert the email address of the new lead");
        String emailAddress = scanner.nextLine();
        boolean isEmail=false;
        while(!isEmail){
            Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
            Matcher mather = pattern.matcher(emailAddress);
            if (mather.find()) {
                isEmail=true;
            }
            else{
                System.err.println("Please select a valid email");
                emailAddress = scanner.nextLine();
            }
        }
        return emailAddress;
    }
    public String companyNameLead(Scanner scanner){
        System.out.println("Please insert the company the new lead works for");
        String companyName = scanner.nextLine(); //pueden haber letras y numeros*/
        return companyName;
    }

    //====================== SHOW LEADS =======================
    public void listIdName(CRM crm) throws Exception {

            //Header of the Method
            System.out.println();
            System.out.println(Colors.GREEN_BOLD_BRIGHT + "You have selected the \"Display list of Leads\" option");

            //The company has no Leads
            if (leadMap.size() == 0) {
                System.out.println(Colors.RESET + "The company has no leads yet");
            } else {

                System.out.println(Colors.YELLOW_BOLD_BRIGHT + "The company owns the following Leads:");
                System.out.println(Colors.RESET);

                //List of Leads
                showLeadsNamesAndCompany();

          
   /* public void listIdName(){
        if(!leadMap.isEmpty()){
            System.out.println("Showing list of corresponding names and id's from leads");
            for(Map.Entry<Integer,Lead> entry : leadMap.entrySet()){
                System.out.println(entry.getKey() + " = " + entry.getValue().getName());
            }
        } else {
            System.out.println("No leads found");
        } */



                /*
            public void listIdName(){
                if(!leadMap.isEmpty()){
                    System.out.println("Showing list of corresponding names and id's from leads");
                    for(Map.Entry<Integer,Lead> entry : leadMap.entrySet()){
                    System.out.println(entry.getKey() + " = " + entry.getValue().getName());
                } else {
                    System.out.println("No leads found");
            } */


                //Foot of method
                System.out.println();
                Menu.enterToContinue(Colors.YELLOW_BOLD_BRIGHT + "Press ENTER to continue...");
                System.out.println();
                System.out.println(Colors.RESET + "---------------------------------------------------------------------------------");
                System.out.println();
                Scanner scanner = new Scanner(System.in);
                System.out.println();
                Menu.displayMenu(scanner, this);
            }
        }



    //========================== SHOW DETAILS OF A LEAD ===========================

    public void leadDetail(Scanner scanner, CRM crm) throws Exception {
        //Header of the Method
        System.out.println();
        System.out.println(Colors.GREEN_BOLD_BRIGHT + "You have selected the \"Show details of a Lead\" option");

        //The company has no Leads
        if (leadMap.size() == 0) {
            System.out.println(Colors.RESET + "The company has no leads yet");
        } else {
            System.out.println(Colors.YELLOW_BOLD_BRIGHT + "The company owns the following Leads:");
            System.out.println(Colors.RESET);

            showLeadsNamesAndCompany();

            System.out.println();
            System.out.println(Colors.RESET + "Please, enter the command" + Colors.YELLOW_BOLD_BRIGHT + " [lookup lead id]"
                    + Colors.RESET + " with the id of the Lead you want to show details");
            System.out.println("For example, if you wants to show the Lead with id \"12\", you have to type"
                    + Colors.YELLOW_BRIGHT + " [lookup lead 12]");

            boolean commandOk = false;
            String[] typed = scanner.nextLine().toLowerCase().split(" ");
            Lead fondedLead = new Lead();

            //comprobar que length == 3 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

            while (!commandOk) {
                if (!typed[2].matches(".*[0-9].*")) {
                    System.out.println("The command entered is wrong. Please, try again");
                    Menu.enterToContinue(Colors.YELLOW_BOLD_BRIGHT + "Press ENTER to continue...");
                    leadDetail(scanner, this);
                }else{
                    fondedLead = leadMap.get(Integer.parseInt(typed[2]));
                    if (typed.length == 3 && typed[0].equals("lookup") && typed[1].equals("lead") && fondedLead != null) {
                        commandOk = true;
                    } else {
                        System.out.println("The command entered is wrong. Please, try again");
                        Menu.enterToContinue(Colors.YELLOW_BOLD_BRIGHT + "Press ENTER to continue...");
                        leadDetail(scanner, this);
                    }
                }
            }
            System.out.println(Colors.GREEN_BOLD_BRIGHT + "NAME: " + Colors.RESET + fondedLead.getName());
            System.out.println(Colors.GREEN_BOLD_BRIGHT + "PHONE NUMBER: " + Colors.RESET + fondedLead.getPhoneNumber());
            System.out.println(Colors.GREEN_BOLD_BRIGHT + "EMAIL: " + Colors.RESET + fondedLead.getEmailAddress());
            System.out.println(Colors.GREEN_BOLD_BRIGHT + "COMPANY: " + Colors.RESET + fondedLead.getCompanyName());

        }

        //Foot of method
        System.out.println();
        Menu.enterToContinue(Colors.YELLOW_BOLD_BRIGHT + "Press ENTER to continue...");
        System.out.println();
        System.out.println(Colors.RESET + "---------------------------------------------------------------------------------");
        System.out.println();
        Menu.displayMenu(scanner, this);

    }

    //=================== CONVERT A LEAD INTO AN OPPORTUNITY ======================
      
    public void convertLead(Scanner scanner) throws Exception {
        //Header of the Method
        System.out.println();
        //The company has no Leads
        if (leadMap.size() == 0) {
            System.out.println(Colors.RESET + "The company has no leads yet");
        } else {
            System.out.println(Colors.YELLOW_BOLD_BRIGHT + "The company owns the following Leads:");
            System.out.println(Colors.RESET);

            showLeadsNamesAndCompany();
            System.out.println(Colors.GREEN_BOLD_BRIGHT + "You have selected the \"Upgrade a Lead to an Opportunity\" option");
            System.out.println(Colors.YELLOW_BOLD_BRIGHT + "You must enter the data that will be requested below");
            System.out.println(Colors.RESET);

            //id
            int id = IdNumber(scanner);
            Lead leadToConvert = leadMap.get(id);

            //creation of the Contact
            Contact contact = new Contact(leadToConvert.getName(), leadToConvert.getPhoneNumber(), leadToConvert.getEmailAddress(), leadToConvert.getCompanyName());
            contactMap.put(contact.getId(), contact);

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
            Account account = new Account(industry, numberOfEmployees, city, country, leadToConvert.getCompanyName());
            account.getContactList().add(contact);
            account.getOpportunityList().add(opportunity);
            leadMap.remove(id); //Leads are removed from the system once they have been successfully converted.
            //lo elimino del hashmap que es donde lo estoy "almacenando" para ser accedido por el usuario.
            System.out.println(Colors.GREEN_BOLD_BRIGHT + "Lead upgrade correctly!" + Colors.RESET);

            //Foot of method
            System.out.println();
            Menu.enterToContinue(Colors.YELLOW_BOLD_BRIGHT + "Press ENTER to continue...");
            System.out.println();
            System.out.println(Colors.RESET + "---------------------------------------------------------------------------------");
            System.out.println();
            Menu.displayMenu(scanner, this);
        }
    }

   
 /*
    public void convertLead(Scanner scanner){
        System.out.println(Colors.GREEN_BOLD_BRIGHT + "You selected to upgrade a LEAD to an OPPORTUNITY" + Colors.RESET);
        //id
        int id = IdNumber(scanner);
        Lead leadToConvert = leadMap.get(id);
        //creation of the Contact
        Contact contact = ContactFromLead(id);
        //product
        printEnum("product");
        Product product = productSelection(scanner);
        //quantity
        System.out.println("Please enter the quantity you want to purchase: ");
        int quantity = quantityNumber(scanner);
        //creation of the opportunity
        Opportunity opportunity = OpportunityFromLead(product, quantity, contact);
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
        String companyName =leadToConvert.getCompanyName();
        //new account
        Account account = new Account(industry,numberOfEmployees,city,country, companyName);
        account.getContactList().add(contact);
        account.getOpportunityList().add(opportunity);
        leadMap.remove(id); //Leads are removed from the system once they have been successfully converted.
        //lo elimino del hashmap que es donde lo estoy "almacenando" para ser accedido por el usuario.
        System.out.println(Colors.GREEN_BOLD_BRIGHT +"Lead upgrade correctly!"+ Colors.RESET);
        menu.displayMenu(scanner, this);
    }  
    */

  
    //================== UTILITIES FOR CONVERT A LEAD INTO AN OPPORTUNITY =============
      
      //Find Opportunity
       public static Opportunity OpportunityFromLead(Product product, int quantity, Contact contact){
        Opportunity opportunity = new Opportunity(product, quantity, contact, Status.OPEN);
        opportunityMap.put(opportunity.getId(), opportunity);
        return opportunity;
    }
      
      //Find Contact
    public static Contact ContactFromLead(int id){
        Lead leadToConvert = leadMap.get(id);
        Contact contact = new Contact(leadToConvert.getName(), leadToConvert.getPhoneNumber(), leadToConvert.getEmailAddress(), leadToConvert.getCompanyName());
        contactMap.put(contact.getId(),contact);
        return contact;
    }

    //Industry
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

    //Product
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

    //Verify number
    public static int quantityNumber(Scanner scanner){
        int quantity = 0;
        try {
            quantity = scanner.nextInt();
            if (quantity < 1) {
                System.err.println("The number must be bigger than 1");
                //quantity = 1;
                quantity = quantityNumber(scanner);
            }
        }catch(Exception e){
            System.err.println("That´s not a number. Please try again");
            scanner.next();
            quantity = quantityNumber(scanner);
        }
        return quantity;
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

    //Valid Country
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

    //=================== CHANGE STATUS ===========================
    
    public void changeOppStatus(Scanner scanner) throws Exception {

        //Header of the method
        System.out.println();
        System.out.println(Colors.GREEN_BOLD_BRIGHT + "You have selected the \"Change Opportunity status\" option");
        System.out.println(Colors.RESET);
        if (opportunityMap.isEmpty()) {
            throw new Exception("The company has no Opportunities yet");
            //System.out.println(Colors.RESET + "The company has no Opportunities yet");
        } else {
            System.out.println(Colors.YELLOW_BOLD_BRIGHT + "The company owns the following Opportunities:");
            System.out.println(Colors.RESET);
            showOpportunities();
            System.out.println();
        System.out.println("Please, enter the commands" + Colors.YELLOW_BOLD_BRIGHT + " [close-lost id]"
                    + Colors.RESET + " or " + Colors.YELLOW_BOLD_BRIGHT + "[close-won id]"
                    + Colors.RESET + " with the id of the Opportunity you want to change");
            System.out.println("For example, if you wants to close lost the Opportunity with id \"4321\", you have to type"
                + Colors.YELLOW_BRIGHT + " [close-lost 4321]" + Colors.RESET);

            changeNewStatus(scanner);

        }
        //Foot of method
        System.out.println();
        Menu.enterToContinue(Colors.YELLOW_BOLD_BRIGHT + "Press ENTER to continue...");
        System.out.println();
        System.out.println(Colors.RESET + "---------------------------------------------------------------------------------");
        System.out.println();
        Menu.displayMenu(scanner, this);
    }
      
    //============= UTILITIES METHODS ===========
      
    //Assign new Status

    public void changeNewStatus(Scanner scanner) throws Exception {
        boolean commandOk = false;
        String[] typed = scanner.nextLine().toLowerCase().split(" ");
        Opportunity opportunity = new Opportunity();

    public static void changeNewStatus(Scanner scanner) throws Exception{
        try {
            String[] typed = scanner.nextLine().toLowerCase().split(" ");
            Opportunity opportunity = new Opportunity();
        

            if (typed.length != 2) {
                throw new Exception("The command entered or the id are wrong");
            }

            if (typed[1].matches(".*[0-9].*")) {
                opportunity = opportunityMap.get(Integer.parseInt(typed[1]));
                if (opportunity != null) {
                    switch (typed[0]) {
                        case "close-lost" -> {
                            opportunityMap.get(opportunity.getId()).setStatus(Status.CLOSED_LOST);
                            System.out.println(Colors.GREEN_BOLD_BRIGHT + "The status was changed successfully into CLOSED_LOST"
                                 + Colors.RESET);
                        }
                        case "close-won" -> {
                            opportunityMap.get(opportunity.getId()).setStatus(Status.CLOSED_WON);
                            System.out.println(Colors.GREEN_BOLD_BRIGHT + "The status was changed successfully into CLOSE_WON"
                                  + Colors.RESET);
                        }
                        default -> {
                            throw new Exception("The command entered is wrong");
                        }
                    }
                } else {
                    throw new Exception("The id entered not exist");

                }
            }

        } catch (Exception e) {
            //System.out.println(Colors.RED_BRIGHT + e.getMessage() + Colors.RESET);
            System.out.println("Please, try again");
            throw new Exception("cualquiera");
            //changeNewStatus(scanner);
        }
    }

    //Show List of Leads
    public static void showLeadsNamesAndCompany(){
        for (Map.Entry<Integer, Lead> entry : leadMap.entrySet()) {
            Integer key = entry.getKey();
            String name = entry.getValue().getName();
            System.out.println(key + ". " + name);
        }
    }

    public static void showOpportunities(){
        for (Map.Entry<Integer, Opportunity> entry : opportunityMap.entrySet()) {
            Integer key = entry.getKey();
            String name = entry.getValue().getDecisionMaker().getName();
            String status = entry.getValue().getStatus().toString();
            System.out.println(key + ". DECISION MAKER: " + name + ". STATUS: " + status);
        }
    }
}
