package Main;

import Classes.*;
import Enums.Product;
import Enums.Status;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {



        CRM crm = new CRM();

        //FOR TESTING...........

        /*Lead lead1 = new Lead("Pedro Lopez", "675345829", "pedro@yahho.es", "Movil Phone");
        Lead lead2 = new Lead("Anier Alvarez", "675345829", "pedro@yahho.es", "Farmacy");
        Lead lead3 = new Lead("Laura Perez", "675345829", "pedro@yahho.es", "Mercadona");

        Map<Integer,Lead> mapLeads = new HashMap<>();
        mapLeads.put(lead1.getId(), lead1);
        mapLeads.put(lead2.getId(), lead2);
        mapLeads.put(lead3.getId(), lead3);

        CRM.setLeadMap(mapLeads);*/

        //Opportunity
        Product prod = Product.BOX;
        Contact contact = new Contact("Pedro Lopez", "675345829", "pedro@yahho.es", "Movil Phone");
        Status status = Status.OPEN;
        Opportunity op = new Opportunity(prod,3,contact,status);
        Map<Integer,Opportunity> mapOp = new HashMap<>();
        mapOp.put(op.getId(),op);
        CRM.setOpportunityMap(mapOp);

        //END OF TESTING..........

        Scanner scanner = new Scanner(System.in);
        Menu.welcome();
        Menu.displayMenu(scanner, crm);

       String userInput = scanner.nextLine();
        //crm.processInput(userInput);

        crm.createLead(scanner);


    }
}
