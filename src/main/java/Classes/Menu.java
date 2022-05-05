package Classes;

import java.util.Locale;
import java.util.Scanner;

public class Menu {

    public static void welcome(){
        System.out.println();
        System.out.println(Colors.YELLOW_BOLD_BRIGHT + "||       ||ººº\\\\   ||        " + Colors.GREEN_BOLD_BRIGHT + "ººººººººº  ||ºººº\\\\  ||      ||   //ººº\\\\  ||   //  ºº||ºº  ||\\\\    ||   //ººº\\\\");
        System.out.println(Colors.YELLOW_BOLD_BRIGHT + "||       ||   //   ||           " + Colors.GREEN_BOLD_BRIGHT + "TT      ||    //  ||      ||  //        ||  //     ||    || \\\\   ||  // ");
        System.out.println(Colors.YELLOW_BOLD_BRIGHT + "||       ||==||    ||           " + Colors.GREEN_BOLD_BRIGHT + "||      ||___//   ||      ||  ||        ||=||      ||    ||  \\\\  ||  ||    ____");
        System.out.println(Colors.YELLOW_BOLD_BRIGHT + "||____   ||   \\\\   ||____      " + Colors.GREEN_BOLD_BRIGHT + " ||      ||   \\\\    \\\\____//   \\\\        ||  \\\\     ||    ||   \\\\ ||  \\\\     //");
        System.out.println(Colors.YELLOW_BOLD_BRIGHT + "||____|  ||___//   ||____|      " + Colors.GREEN_BOLD_BRIGHT + "||      ||    \\\\    \\\\__//     \\\\___//  ||   \\\\  __||__  ||    \\\\||   \\\\___//");
        System.out.println();
        System.out.println("                                 //ººº\\\\   //ººº\\\\   ||\\\\   //||  ||ºººº\\\\    //\\\\       ||\\\\    ||   \\\\    //");
        System.out.println("                                //        //     \\\\  || \\\\ // ||  ||    //   //  \\\\      || \\\\   ||    \\\\  //");
        System.out.println("                                ||        ||     ||  ||  \\=/  ||  ||___//   //____\\\\     ||  \\\\  ||     \\\\//");
        System.out.println("                                \\\\        \\\\     //  ||       ||  ||       //======\\\\    ||   \\\\ ||      ||");
        System.out.println("                                 \\\\___//   \\\\___//   ||       ||  ||      //        \\\\   ||    \\\\||      ||");

        System.out.println(Colors.YELLOW_BRIGHT);
        System.out.println("                                                                                              @codebreakers");
        System.out.println(Colors.RESET);

        System.out.println();
        System.out.println("                                       Welcome to LBL Trucking Company CRM. Press ENTER to start the program");
        enterToContinue("------------------------------------------------------------------------------------------------------------");
    }

    public static void enterToContinue(String enter) {
        System.out.println(enter);
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();

    }

    public static void displayMenu(Scanner scanner, CRM crm) throws Exception {
        System.out.print(Colors.GREEN_BOLD_BRIGHT);
        System.out.println("You have the following options:");
        System.out.println("Please, type the command indicated [in brackets] for the action you want to perform");
        System.out.println(Colors.RESET);
        System.out.println("  - Create a Lead" + Colors.YELLOW_BRIGHT + " [New Lead]" + Colors.RESET);
        System.out.println("  - Display list of Leads"  + Colors.YELLOW_BRIGHT + " [Show Leads]" + Colors.RESET);
        System.out.println("  - Show details of a Lead"  + Colors.YELLOW_BRIGHT + " [Lookup Lead]" + Colors.RESET);
        System.out.println("  - Turn a Lead into an Opportunity" + Colors.YELLOW_BRIGHT + " [convert]" + Colors.RESET);
        System.out.println("  - Change Opportunity status"  + Colors.YELLOW_BRIGHT + " [change status]" + Colors.RESET);
        System.out.println("  - Close the program"  + Colors.YELLOW_BRIGHT + " [exit]" + Colors.RESET);
        scanner = new Scanner(System.in);
        selectOption(scanner,crm);
    }

    public static void selectOption(Scanner scanner, CRM crm) throws Exception {
        boolean selected = false;
        String option = "";
        while (option.isEmpty()){
            option = scanner.nextLine().toLowerCase();
            switch (option) {
                case "new lead" -> crm.createLead(scanner);
                case "show leads" -> crm.listIdName(crm);
                case "lookup lead" -> crm.leadDetail(scanner, crm);
                case "convert" -> crm.convertLead(scanner);
                case "change status" -> crm.changeOppStatus(scanner);
                case "exit" -> {
                    System.out.println();
                    System.out.println(Colors.GREEN_BOLD_BRIGHT + "The program is shutting down");
                    System.out.println(Colors.YELLOW_BOLD_BRIGHT + "See you soon......");
                }
                default -> {
                    System.out.println("Wrong command. Please, try again");
                    option = "";
                }
            }
        }
    }

}
