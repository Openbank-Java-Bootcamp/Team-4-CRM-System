package Classes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.StringReader;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class MenuTest {

    private CRM crm;

    @BeforeEach
    public void setUp(){
        crm = new CRM();
    }

    @Test
    public void selectOption_NoPermittedCommand(){
        Scanner scanner = new Scanner(new StringReader("close"));
        assertThrows(Exception.class,() -> Menu.selectOption(scanner,crm));
    }

    @Test
    public void selectOption_EmptyValue(){
        Scanner scanner = new Scanner(new StringReader(""));
        assertThrows(Exception.class,() -> Menu.selectOption(scanner,crm));
    }


}