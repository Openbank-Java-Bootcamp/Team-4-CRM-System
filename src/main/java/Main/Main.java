package Main;

import Classes.CRM;
import Classes.Lead;
import Classes.Menu;

import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        CRM crm = new CRM();
        Scanner scanner = new Scanner(System.in);
        Menu.welcome();
        Menu.displayMenu(scanner, crm);




        //Functionality f = new Functionality();
        //Scanner scanner = new Scanner(System.in);

        System.out.println("Menu:");
        System.out.println("To create new lead type \"New Lead\"");
        System.out.println("To see leads id type \"Show Leads\"");
        System.out.println("To see a lead details type \"Lookup Lead id\"");
        System.out.println("To covert lead into opportunity type \"convert id\"");
        System.out.println("To change an opportunity status type \"close-lost id\" or \"close-won id\"");
        /*
        String userInput = scanner.nextLine();
        f.processInput(userInput);

         */

        //metodo que reciba el user inout y analice las distintas posibilidades con sus
        // requerimientos de formato y excepciones.

        /*
        //If "New Lead"
        f.createLead(scanner);

        //If “Show Leads”
        f.listIdName();

        //If “Lookup Lead "id"”
        /*int idmomentaneo = 1; //should read the id from the input
        f.leadDetail(idmomentaneo);


        //If “convert id”
        f.convertLead(scanner);


        //If “close-lost id” or “close-won id” where “id”
        Status newStatus = Status.CLOSED_LOST; //should read this from the input
        f.changeOppStatus(idmomentaneo, newStatus);*/


        /*
        f.convertLead(scanner);

        f.createLead(scanner);


         */

    }
}
