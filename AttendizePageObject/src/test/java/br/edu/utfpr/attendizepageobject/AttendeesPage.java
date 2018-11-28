/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.attendizepageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

/**
 *
 * @author daphnemillss
 */
class AttendeesPage extends AttendizePage{
    
    @FindBy(xpath = "//*[@id=\"main\"]/div/div[3]/div[1]/div/div/div[2]/button")
    WebElement buttonInvite;
    
    @FindBy(id = "ticket_id")
    WebElement selectTickets;
    
    @FindBy(id = "first_name")
    WebElement inputFirstName;
    
    @FindBy(id = "last_name")
    WebElement inputLastName;
    
    @FindBy(id = "email")
    WebElement inputEmail;
    
    @FindBy(xpath = "/html/body/div[3]/form/div/div/div[3]/input")
    WebElement buttonSubmit;
    
    @FindBy(xpath = "//*[@id=\"main\"]/div/div[3]/div[1]/div/div/table/tbody/tr/td[5]/a[2]")
    WebElement buttonCancelAttendee;
    
    @FindBy(xpath = "/html/body/div[3]/form/div/div/div[3]/input[2]")
    WebElement buttonConfirmCancel;
    
    @FindBy(className = "humane")
    WebElement msgAttendeeExlcuido;
    
    public AttendeesPage(WebDriver driver) {
        super(driver);
    }
    
    public AttendeesPage clicarEmInviteAttendees(){
        buttonInvite.click();
        
        return this;
    }
    
    public AttendeesPage preencherCamposCom(String ticket, String firstName, String lastName, String email){
        Select selector = new Select(selectTickets);
        selector.selectByVisibleText(ticket);
        
        inputFirstName.clear();
        inputFirstName.sendKeys(firstName);
        
        inputLastName.clear();
        inputLastName.sendKeys(lastName);
        
        inputEmail.clear();
        inputEmail.sendKeys(email);
        
        return this;
    }
    
    public AttendeesPage confirmarInvite(){
        buttonSubmit.click();
        sleep(2000);
        
        return this;
    }
    
    public AttendeesPage cancelarAttendee(){
        buttonCancelAttendee.click();
        
        return this;
    }
    
    public AttendeesPage confirmarCancelamento(){
        buttonConfirmCancel.click();
        sleep(2000);
        
        return this;
    }
    
    public boolean excluiuAttendee(){
        return msgAttendeeExlcuido.isDisplayed() && msgAttendeeExlcuido.getText().equals("Successfully Cancelled Attendee!");
    }
}
