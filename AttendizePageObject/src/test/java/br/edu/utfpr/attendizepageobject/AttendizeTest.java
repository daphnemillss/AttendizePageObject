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
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;

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

        driver.get("http://192.168.0.102/");
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
        String novoPreco = "50.00";
        
        TicketsPage tickets = login.
                              preencherLogin(email, senha).
                              clicarEmLogin().
                              clicarEmEvent().
                              clicarNoPrimeiroEvento().
                              clicarEmTickets().
                              clicarNoPrimeiroTicket().
                              editarPrecoDoTicketPara(novoPreco).
                              salvarTicket();
                              
        assertEquals("€"+novoPreco, tickets.verNovoPreco());
    }
    
    @Test
    @Ignore
    public void CT05(){
        String novoTitulo = "Teste";
        EventOficialPage oficial = login.
                                       preencherLogin(email, senha).
                                       clicarEmLogin().
                                       clicarEmEvent().
                                       clicarNoPrimeiroEvento().
                                       clicarEmCustomize().
                                       editarCamposCom(novoTitulo, "Mudei", "", "", "Cornélio Procópio").
                                       salvarMudancas().
                                       irParaPaginaDoEvento();
        
        assertEquals(novoTitulo+" - Attendize.com",oficial.getCurrentTitle());
    }
    
    @Test
    @Ignore
    public void CT06(){
        EventsPage events = login.
                            preencherLogin(email, senha).
                            clicarEmLogin().
                            clicarEmEvent().
                            preencherCampoDeBuscaCom("Teste").
                            clicarNaLupa();
        
        assertTrue(events.achouAlgo());
        
        events = events.preencherCampoDeBuscaCom("Nao vai achar nada").clicarNaLupa();
        
        assertTrue(events.naoAchouNada());
    }
    
    @Test
    @Ignore
    public void CT07(){
        AttendeesPage attendees = login.
                                  preencherLogin(email, senha).
                                  clicarEmLogin().
                                  clicarEmEvent().
                                  clicarNoPrimeiroEvento().
                                  clicarEmAttendees().
                                  clicarEmInviteAttendees().
                                  preencherCamposCom("teste", "Tester", "da Silva", "testerdasilva@gmail.com").
                                  confirmarInvite().
                                  cancelarAttendee().
                                  confirmarCancelamento();
        
        assertTrue(attendees.excluiuAttendee());
    }
    
    @Test
    @Ignore
    public void CT08(){
        SurveysPage surveys = login.
                          preencherLogin(email, senha).
                          clicarEmLogin().
                          clicarEmEvent().
                          clicarNoPrimeiroEvento().
                          clicarEmSurveys().
                          clicarEmAddQuestion().
                          preencherCamposCom("What's your name?", "Single-line text box").
                          criarQuestao();
        
        assertTrue(surveys.criouQuestao());
    }
    
    @Test
    @Ignore
    public void CT09(){
        CustomizeEventPage customize = login.
                                  preencherLogin(email, senha).
                                  clicarEmLogin().
                                  clicarEmEvent().
                                  clicarNoPrimeiroEvento().
                                  clicarEmCustomize().
                                  abrirAbaEventDesign().
                                  escolherImgAleatoria().
                                  salvarImgEscolhida();
        
        assertTrue(customize.mudouImgDoEvento());
    }
    
    @Test
    //@Ignore
    public void CT10(){
        CustomizeOrganiserPage customize = login.
                                           preencherLogin(email, senha).
                                           clicarEmLogin().
                                           clicarEmCustomize().
                                           preencherCamposCom("Teste", "Testando").
                                           salvarMudancas();
        
        assertTrue(customize.salvouMudancas());
    }
}
