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
class SurveysPage extends AttendizePage{
    
    public SurveysPage(WebDriver driver) {
        super(driver);
    }
    
    @FindBy(xpath = "//*[@id=\"main\"]/div/div[3]/div/div/div[2]/button")
    WebElement buttonCreateQuestion;
    
    @FindBy(xpath = "//*[@id=\"main\"]/div/div[2]/div/div[1]/div/div[1]/button")
    WebElement buttonCreateQuestion2;
    
    @FindBy(id = "question-title")
    WebElement inputTitle;
    
    @FindBy(id = "question-type")
    WebElement selectType;
    
    @FindBy(xpath = "//*[@id=\"edit-question-form\"]/div/div/div[3]/input")
    WebElement buttonSubmit;
    
    @FindBy(className = "humane")
    WebElement msgSucesso;
    
    public SurveysPage clicarEmAddQuestion(){
        try{
            buttonCreateQuestion.click();
        }catch(org.openqa.selenium.NoSuchElementException e){
            buttonCreateQuestion2.click();
        }
        
        return this;
    }
    
    public SurveysPage preencherCamposCom(String title, String type){
        inputTitle.sendKeys(title);
        
        Select selector = new Select(selectType);
        selector.selectByVisibleText(type);
        
        return this;
    }
    
    public SurveysPage criarQuestao(){
        buttonSubmit.click();
        sleep(2000);
        
        return this;
    }
    
    public boolean criouQuestao(){
        return msgSucesso.isDisplayed() && msgSucesso.getText().equals("Successfully Created Question");
    }
}
