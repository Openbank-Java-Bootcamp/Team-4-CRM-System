package Classes;

import java.util.Locale;
import java.util.Scanner;

public class Menu {

    public static void welcome(){
        System.out.println("Welcome to LBL Trucking Company CRM");
        System.out.println("-----------------------------------");
        System.out.println();
    }

    public static void displayMenu(){

        System.out.println("You have the following options");
        System.out.println("Please, type the command indicated [in brackets] for the action you want to perform");
        System.out.println("  - Create a Lead [New Lead]");
        System.out.println("  - Display list of Leads [Show Leads]");
        System.out.println("  - Show details of a Lead [Lookup Lead id]");
        System.out.println("  - Turn a Lead into an Opportunity [convert id]");
        System.out.println("  - Change Opportunity status [change status]");
    }

    public static void selectOption(Scanner scanner){
        CRM crm = new CRM();
        boolean selected = false;
        String option = "";
        while (option.isEmpty()){
            option = scanner.nextLine().toLowerCase();
            switch (option){
                case "new lead":
                    crm.createLead(scanner);
                    break;
                case "show leads":
                    crm.listIdName();
                    break;
                case "lookuo lead id":
                    crm.leadDetail(scanner);
                    break;
                case "convert id":
                    crm.convertLead(scanner);
                    break;
                case "change status":
                    crm.changeOppStatus(scanner);
                    break;
                default:
                    System.out.println("Wrong command. Please, try again");
                    option = "";
                    break;
            }
        }
    }


}
