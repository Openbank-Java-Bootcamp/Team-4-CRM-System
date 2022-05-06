package Classes;
import Enums.Industry;
import Enums.Product;
import Enums.Status;
import nl.altindag.console.ConsoleCaptor;

import org.junit.After;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;


class CRMTest {
    private CRM crm;
    private Scanner s;

    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalErr = System.err;


    @BeforeEach
    public void setUp(){
        crm = new CRM();
        System.setErr(new PrintStream(errContent));
    }
    @After
    public void restoreStreams() {
        System.setErr(originalErr);
    }

    //CONVERT ID TEST COVERAGE
    @Test
    public void IdNumber_Throw_notINT(){
        //con el scan reader parece que se falsea el scanner
        StringReader sr = new StringReader("s");
        Scanner scan = new Scanner(sr);
        ConsoleCaptor consoleCaptor = new ConsoleCaptor();
        List<String> s = consoleCaptor.getErrorOutput();
        consoleCaptor.close();
        assertThat(s.contains("That´s not a number. Please try again"));
    }

    @Test
    public void IdNumber_Works(){
        Lead l = new Lead("pepe", "123123123", "pepe@gmail.com", "Matucos");
        Map<Integer,Lead> leadMap = new HashMap<>();
        leadMap.put(l.getId(), l);
        crm.setLeadMap(leadMap);
        StringReader sr = new StringReader("1");
        Scanner scan = new Scanner(sr);
        assertEquals(l.getId(), crm.IdNumber(scan) );
    }

    @Test
    public void quantityNumber_Throw_notINT(){
        StringReader sr = new StringReader("s");
        Scanner scan = new Scanner(sr);
        ConsoleCaptor consoleCaptor = new ConsoleCaptor();
        List<String> s = consoleCaptor.getErrorOutput();
        consoleCaptor.close();
        assertThat(s.contains("That´s not a number. Please try again"));

    }


    @Test
    public void quantityNumber_err_minus1(){
        StringReader sr = new StringReader("1");
        Scanner scan = new Scanner(sr);
        ConsoleCaptor consoleCaptor = new ConsoleCaptor();
        crm.quantityNumber(scan);
        List<String> s = consoleCaptor.getErrorOutput();
        consoleCaptor.close();
        assertThat(s.contains("The number must be bigger than 1"));
    }
    @Test
    public void quatityNumber_Works(){
        StringReader sr = new StringReader("20");
        Scanner scan = new Scanner(sr);
        assertEquals(20, crm.quantityNumber(scan));
    }
    @Test
    public void ValidateCountry_true(){
        assertTrue(crm.validateCountry("Spain"));
    }
    @Test
    public void ValidateCountry_false(){
        assertFalse(crm.validateCountry("Paloma"));
    }
    @Test
    public void countryInput_Works(){
        StringReader sr = new StringReader("Spain");
        Scanner scan = new Scanner(sr);
        assertEquals("Spain", crm.countryInput(scan));
    }

    //check if we can add shaun ideas
    @Test
    public void countryInput_err(){
        StringReader sr = new StringReader("Spain");
        Scanner scan = new Scanner(sr);
        ConsoleCaptor consoleCaptor = new ConsoleCaptor();
        crm.countryInput(scan);
        List<String> s = consoleCaptor.getErrorOutput();
        consoleCaptor.close();
        assertThat(s.contains("Thats not a valid country. Please try again"));
    }


    @Test
    public void changeNewStatus_PermittedCommand(){
        //Opportunity
        Product prod = Product.BOX;
        Contact contact = new Contact("Pedro Lopez", "675345829", "pedro@yahho.es", "Movil Phone");
        Status status = Status.OPEN;
        Opportunity op = new Opportunity(prod,3,contact,status);
        Map<Integer,Opportunity> mapOp = new HashMap<>();
        mapOp.put(op.getId(),op);
        CRM.setOpportunityMap(mapOp);

        Scanner scanner = new Scanner(new StringReader("close-lost 1"));
        CRM.changeNewStatus(scanner);

        assertEquals(mapOp.get(1).getStatus(), Status.CLOSED_LOST);
    }


    @Test
    public void ContactFromLead_Works(){
        Lead l = new Lead("Paula", "662092398", "paula@gmail.com", "Matucos");
        Map<Integer,Lead> leadMap = new HashMap<>();
        leadMap.put(l.getId(), l);
        CRM.setLeadMap(leadMap);
        Contact c = new Contact("Paula", "662092398", "paula@gmail.com", "Matucos");
        assertThat(c.equals(CRM.ContactFromLead(l.getId())));
        assertEquals(1, CRM.getContactMap().size());
    }

    @Test
    public void OpportunityFromLead_Works(){
        Contact c = new Contact("Paula", "662092398", "paula@gmail.com", "Matucos");
        Opportunity o = new Opportunity(Product.FLATBED, 2,c, Status.OPEN);
        assertThat(o.equals(crm.OpportunityFromLead(Product.FLATBED, 2,c)));
        assertEquals(1, crm.getOpportunityMap().size());
    }

    @Test
    public void IndustrySelection_PRODUCE_works(){
        Industry i = Industry.PRODUCE;
        StringReader sr = new StringReader("PRODUCE");
        Scanner scan = new Scanner(sr);
        ConsoleCaptor consoleCaptor = new ConsoleCaptor();
        assertEquals(i, crm.industrySelection(scan));;
        List<String> s = consoleCaptor.getStandardOutput();
        consoleCaptor.close();
        assertThat(s.contains("PRODUCE selected!"));
    }

    @Test
    public void IndustrySelection_ECOMMERCE_works(){
        Industry i = Industry.ECOMMERCE;
        StringReader sr = new StringReader("ECOMMERCE");
        Scanner scan = new Scanner(sr);
        ConsoleCaptor consoleCaptor = new ConsoleCaptor();
        assertEquals(i, crm.industrySelection(scan));;
        List<String> s = consoleCaptor.getStandardOutput();
        consoleCaptor.close();
        assertThat(s.contains("ECOMMERCE selected!"));
    }

    @Test
    public void IndustrySelection_MANUFACTURING_works(){
        Industry i = Industry.MANUFACTURING;
        StringReader sr = new StringReader("MANUFACTURING");
        Scanner scan = new Scanner(sr);
        ConsoleCaptor consoleCaptor = new ConsoleCaptor();
        assertEquals(i, crm.industrySelection(scan));;
        List<String> s = consoleCaptor.getStandardOutput();
        consoleCaptor.close();
        assertThat(s.contains("MANUFACTURING selected!"));
    }

    @Test
    public void IndustrySelection_MEDICAL_works(){
        Industry i = Industry.MEDICAL;
        StringReader sr = new StringReader("MEDICAL");
        Scanner scan = new Scanner(sr);
        ConsoleCaptor consoleCaptor = new ConsoleCaptor();
        assertEquals(i, crm.industrySelection(scan));;
        List<String> s = consoleCaptor.getStandardOutput();
        consoleCaptor.close();
        assertThat(s.contains("MEDICAL selected!"));
    }

    @Test
    public void IndustrySelection_OTHER_works(){
        Industry i = Industry.OTHER;
        StringReader sr = new StringReader("OTHER");
        Scanner scan = new Scanner(sr);
        ConsoleCaptor consoleCaptor = new ConsoleCaptor();
        assertEquals(i, crm.industrySelection(scan));;
        List<String> s = consoleCaptor.getStandardOutput();
        consoleCaptor.close();
        assertThat(s.contains("OTHER selected!"));
    }

    @Test
    public void printEnum_Insdustry_Works(){
        ConsoleCaptor consoleCaptor = new ConsoleCaptor();
        crm.printEnum("Industry");
        List<String> s = consoleCaptor.getStandardOutput();
        assertThat(s.contains("- PRODUCE\n- ECOMMERCE\n- MANUFACTURING\n- MEDICAL\n- OTHER\n"));
        consoleCaptor.close();
    }

    @Test
    public void printEnun_Product_Works(){
        ConsoleCaptor consoleCaptor = new ConsoleCaptor();
        crm.printEnum("Product");
        List<String> s = consoleCaptor.getStandardOutput();
        assertThat(s.contains("- HYBRID\n- HYBRID\n- HYBRID\n"));
        consoleCaptor.close();
    }

    @Test
    public void printEnun_Status_Works(){
        ConsoleCaptor consoleCaptor = new ConsoleCaptor();
        crm.printEnum("Status");
        List<String> s = consoleCaptor.getStandardOutput();
        assertThat(s.contains("- OPEN\n- CLOSED_LOST\n- CLOSED_WIN\n"));
        consoleCaptor.close();
    }


    @Test
    public void ProductSelection_HYBRID_works(){
        Product i = Product.HYBRID;
        StringReader sr = new StringReader("HYBRID");
        Scanner scan = new Scanner(sr);
        ConsoleCaptor consoleCaptor = new ConsoleCaptor();
        assertEquals(i, crm.productSelection(scan));;
        List<String> s = consoleCaptor.getStandardOutput();
        consoleCaptor.close();
        assertThat(s.contains("HYBRID selected!"));
    }

    @Test
    public void ProductSelection_FLATBED_works(){
        Product i = Product.FLATBED;
        StringReader sr = new StringReader("FLATBED");
        Scanner scan = new Scanner(sr);
        ConsoleCaptor consoleCaptor = new ConsoleCaptor();
        assertEquals(i, crm.productSelection(scan));;
        List<String> s = consoleCaptor.getStandardOutput();
        consoleCaptor.close();
        assertThat(s.contains("FLATBED selected!"));
    }

    @Test
    public void ProductSelection_BOX_works(){
        Product i = Product.BOX;
        StringReader sr = new StringReader("BOX");
        Scanner scan = new Scanner(sr);
        ConsoleCaptor consoleCaptor = new ConsoleCaptor();
        assertEquals(i, crm.productSelection(scan));;
        List<String> s = consoleCaptor.getStandardOutput();
        consoleCaptor.close();
        assertThat(s.contains("BOX selected!"));
    }



    //================= CREATE A LEAD TEST==================

    @Test
    public void nameLead_Works() throws Exception {
        StringReader sr = new StringReader("pepe");
        Scanner scan = new Scanner(sr);
        assertEquals("pepe", crm.nameLead(scan) );
    }
    @Test
    public void phoneNumberLead_Works(){
        StringReader sr = new StringReader("675345829");
        Scanner scan = new Scanner(sr);
        assertEquals("675345829", crm.phoneNumberLead(scan) );
    }
    @Test
    public void emailLead_Works(){
        StringReader sr = new StringReader("paula@gmail.com");
        Scanner scan = new Scanner(sr);
        assertEquals("paula@gmail.com", crm.emailLead(scan) );
    }
    @Test
    public void companyLead_Works(){
        StringReader sr = new StringReader("Matucos");
        Scanner scan = new Scanner(sr);
        assertEquals("Matucos", crm.companyNameLead(scan) );
    }

}