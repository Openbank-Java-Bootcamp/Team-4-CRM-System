package Classes;


import static org.assertj.core.api.Assertions.assertThat;

import nl.altindag.console.ConsoleCaptor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class CRMTest {
    private CRM crm;
    private Scanner s;
    @BeforeEach
    public void setUp(){
        crm = new CRM();
    }

    //CONVERT ID TEST COVERAGE
    @Test
    public void IdNumber_Throw_notINT(){
        //con el scan reader parece que se falsea el scanner
        StringReader sr = new StringReader("s");
        Scanner scan = new Scanner(sr);
        assertThrows(Exception.class,() -> crm.IdNumber(scan));
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
    public void IdNumber_err_notLeadId(){
        //que saque mensaje por pantalla ????
    }
    @Test
    public void quantityNumber_Throw_notINT(){
        //con el scane reader parece que se falsea el scanner
        StringReader sr = new StringReader("s");
        Scanner scan = new Scanner(sr);
        assertThrows(Exception.class,() -> crm.quantityNumber(scan));
    }

    @Test
    public void quantityNumber_err_minus1(){
        //error por pantalla
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

    @Test
    public void countryInput_err(){
        //mensaje error
    }


    /*//CREATE LEAD TEST
    @Test //no funciona porq el scanner es siempre null
    public void nameLeadStandardAndErrorOutput() {
        ConsoleCaptor consoleCaptor = new ConsoleCaptor();
        //Scanner s = new Scanner("maria");
        crm.createLead(s);

        assertThat(consoleCaptor.getStandardOutput()).contains("Please insert the name of the new lead");
        /*assertThat(consoleCaptor.getStandardOutput()).contains("Please insert the phone number of the new lead");
        assertThat(consoleCaptor.getStandardOutput()).contains("Please insert the email address of the new lead");
        assertThat(consoleCaptor.getStandardOutput()).contains("Please insert the company the new lead works for");

        assertThat(consoleCaptor.getErrorOutput()).contains("Please select a valid name.");
        /*assertThat(consoleCaptor.getErrorOutput()).contains("Please select a valid phone number.");
        assertThat(consoleCaptor.getErrorOutput()).contains("Please select a valid email.");

        consoleCaptor.close();
    }*/


}