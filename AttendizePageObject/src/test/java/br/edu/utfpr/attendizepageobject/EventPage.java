/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.attendizepageobject;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author daphnemillss
 */
public class EventPage extends AttendizePage{
    
    @FindBy(xpath = "//*[@id=\"nav_event\"]/li[2]/a")
    List<WebElement> list;
    
    @FindBy(xpath = "//*[@id=\"nav_event\"]/li[6]/a")
    WebElement customizeButton;
    
    @FindBy(xpath = "//*[@id=\"nav_event\"]/li[4]/a")
    WebElement attendeesButton;
    
    public EventPage(WebDriver driver) {
        super(driver);
    }
    
    public TicketsPage clicarEmTickets(){
        list.get(0).click();
        
        return new TicketsPage(driver);
    }
    
    public CustomizeEventPage clicarEmCustomize(){
        customizeButton.click();
        
        return new CustomizeEventPage(driver);
    }
    
    public AttendeesPage clicarEmAttendees(){
        attendeesButton.click();
        
        return new AttendeesPage(driver);
    }
    
    public SurveysPage clicarEmSurveys(){
        list.get(1).click();
        sleep(3000);
        return new SurveysPage(driver);
    }
    
    
}
