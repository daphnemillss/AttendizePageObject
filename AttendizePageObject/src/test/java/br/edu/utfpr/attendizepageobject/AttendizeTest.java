/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.attendizepageobject;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 *
 * @author daphnemillss
 */
public class AttendizeTest {
    private final String email = "teste@teste.com";
    private final String senha = "utfpr";
    
    private WebDriver driver;
    LoginPage login;
    
    @BeforeClass
    public static void setUpClass() {
        WebDriverManager.chromedriver().setup();
    }
    
    @Before
    public void setUp() {
        ChromeOptions chromeOptions = new ChromeOptions();
        //chromeOptions.addArguments("headless");
        chromeOptions.addArguments("window-size=1200x600");
        chromeOptions.addArguments("lang=en-US");
        chromeOptions.addArguments("start-maximized");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("http://192.168.0.106/");
        login = new LoginPage(driver);
    }
    
    @After
    public void tearDown() {
        driver.close();
    }

    @Test @Ignore
    public void CT01(){
        login = login.
                preencherLogin(email, senha).
                clicarEmLogin().
                abrirMenuDeOpcoes().
                clicarEmSignOut();
        
        assertEquals("Login", login.getCurrentTitle());
    }
    
    @Test
    @Ignore
    public void CT02(){
        EventsPage event = login.
                          preencherLogin(email, senha).
                          clicarEmLogin().
                          clicarEmEvent().
                          clicarEmCreateEvent().
                          preencherCamposCom("teste automatizado", "teste", "15-11-2018 20:48", "15-12-2018 20:48", "UTFPR").
                          criarEvento();
        
        /*Este caso de teste nao está funcionando a partir da função preencherCamposCom().
        
          O textarea description não é exatamente um textarea, e ainda não consegui achar uma forma
        de preenchê-lo.*/
        
        assertTrue(event.criouEvento());
    }
    
    @Test
    @Ignore
    public void CT03(){
       TicketsPage tickets = login.preencherLogin(email, senha).
                             clicarEmLogin().
                             clicarEmEvent().
                             clicarNoPrimeiroEvento().
                             clicarEmTickets().
                             clicarEmCreateTicket().
                             preencherCamposCom("teste ticket UTFPR", "100.00", "50").
                             criarTicket();
       
       assertTrue(tickets.criouTicket());
    }
    
    @Test
    @Ignore
    public void CT04(){
        TicketsPage tickets = login.
                              preencherLogin(email, senha).
                              clicarEmLogin().
                              clicarEmEvent().
                              clicarNoPrimeiroEvento().
                              clicarEmTickets().
                              clicarNoPrimeiroTicket().
                              editarPrecoDoTicketPara("10.00").
                              salvarTicket();
                              
        assertEquals("€10.00", tickets.verNovoPreco());
    }
}
