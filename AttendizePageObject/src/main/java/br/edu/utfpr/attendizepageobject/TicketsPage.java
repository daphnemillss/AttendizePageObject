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
class TicketsPage extends AttendizePage{
    
    public TicketsPage(WebDriver driver) {
        super(driver);
    }
    
    
    @FindBy(xpath = "//*[@id=\"main\"]/div/div[2]/div/div[1]/div/div/button")
    WebElement buttonCreateTicket;
    
    @FindBy(name = "title")
    WebElement inputNomeDoTicket;
    
    @FindBy(name = "price")
    WebElement inputPrecoDoTicket;
    
    @FindBy(id = "quantity_available")
    WebElement inputQuantidade;
    
    @FindBy(xpath = "/html/body/div[3]/form/div/div/div[3]/input")
    WebElement criarTicket;
    
    @FindBy(className = "humane")
    WebElement msgSucesso;
    
    public TicketsPage clicarEmCreateTicket(){
        buttonCreateTicket.click();
        
        return this;
    }
    
    public TicketsPage preencherCamposCom(String nome, String preco, String quantidade){
        inputNomeDoTicket.sendKeys(nome);
        inputPrecoDoTicket.sendKeys(preco);
        inputQuantidade.sendKeys(quantidade);
        
        return this;
    }
    
    public TicketsPage criarTicket(){
        criarTicket.click();
        
        return this;
    }
    
    
    public boolean criouTicket(){
        sleep(2000);
        
        return msgSucesso.isDisplayed();
    }
    
}
