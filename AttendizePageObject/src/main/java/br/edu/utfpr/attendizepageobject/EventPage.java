/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.attendizepageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author daphnemillss
 */
public class EventPage extends AttendizePage{
    
    @FindBy(xpath = "//*[@id=\"nav_event\"]/li[2]/a")
    WebElement ticketsButton;
    
    @FindBy(xpath = "//*[@id=\"nav_event\"]/li[6]/a")
    WebElement customizeButton;
    
    public EventPage(WebDriver driver) {
        super(driver);
    }
    
    public TicketsPage clicarEmTickets(){
        ticketsButton.click();
        
        return new TicketsPage(driver);
    }
    
    public CustomizeEventPage clicarEmCustomize(){
        customizeButton.click();
        
        return new CustomizeEventPage(driver);
    }
    
}
