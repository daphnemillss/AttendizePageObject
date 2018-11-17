/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.attendizepageobject;

import java.util.ArrayList;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author daphnemillss
 */
public class CustomizeEventPage extends AttendizePage{

    public CustomizeEventPage(WebDriver driver) {
        super(driver);
    }
    
    @FindBy(id = "title")
    WebElement inputTitulo;
    
    @FindBy(id = "location_venue_name")
    WebElement inputLocal;
    
    @FindBy(id = "location_state")
    WebElement inputCidade;
    
    @FindBy(id = "location_address_line_1")
    WebElement inputAddressLine1;
    
    @FindBy(id = "location_address_line_2")
    WebElement inputAddressLine2;
    
    @FindBy(xpath = "//*[@id=\"general\"]/form/div/div[2]/div/input[2]")
    WebElement buttonSaveChanges;
    
    @FindBy(className = "humane")
    WebElement msgSucesso;
    
    @FindBy(xpath = "//*[@id=\"header\"]/div[2]/ul[1]/li[2]/a")
    WebElement eventePageButton;
    
    public CustomizeEventPage editarCamposCom(String titulo, String local, String addressLine1, String addressLine2, String cidade){
        inputTitulo.clear();
        inputTitulo.sendKeys(titulo);
        
        inputLocal.clear();
        inputLocal.sendKeys(local);
        
        inputAddressLine1.clear();
        inputAddressLine1.sendKeys(addressLine1);
        
        inputAddressLine2.clear();
        inputAddressLine2.sendKeys(addressLine2);
        
        inputCidade.clear();
        inputCidade.sendKeys(cidade);
        
        return this;
    }
    
    public CustomizeEventPage salvarMudancas(){
        buttonSaveChanges.click();
        
        return this;
    }
    
    public EventOficialPage irParaPaginaDoEvento(){
        sleep(2000);
        eventePageButton.click();
        
        ArrayList<String> tabs2 = new ArrayList<> (driver.getWindowHandles()); //Mudando de abas
        driver.close();
        driver.switchTo().window(tabs2.get(1));
        
        sleep(2000);
        
        return new EventOficialPage(driver);
    }
}
