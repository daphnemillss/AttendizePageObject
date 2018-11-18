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
class CustomizeOrganiserPage extends AttendizePage{
    
    public CustomizeOrganiserPage(WebDriver driver) {
        super(driver);
    }
    
    @FindBy(id = "name")
    WebElement inputName;
    
    @FindBy(id = "about")
    WebElement inputDescription;
    
    @FindBy(xpath = "//*[@id=\"organiserSettings\"]/form/div[9]/input")
    WebElement buttonSaveOrganiser;
    
    @FindBy(className = "humane")
    WebElement msgSucesso;
            
    public CustomizeOrganiserPage preencherCamposCom(String nome, String descricao){
        inputName.clear();
        inputName.sendKeys(nome);
        
        inputDescription.clear();
        inputDescription.sendKeys(descricao);
        
        return this;
    }
    
    public CustomizeOrganiserPage salvarMudancas(){
        buttonSaveOrganiser.click();
        sleep(2000);
        
        return this;
    }
    
    public boolean salvouMudancas(){
        return msgSucesso.isDisplayed() && msgSucesso.getText().equals("Successfully Updated Organiser!");
    }
}
