/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.attendizepageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author daphnemillss
 */
public class EventsPage extends AttendizePage{
    
    public EventsPage(WebDriver driver) {
        super(driver);
    }
    
    @FindBy(xpath = "//*[@id=\"main\"]/div/div[2]/div/div[1]/div/div/a")
    WebElement buttonCreateEvent;
    
    @FindBy(xpath = "//*[@id=\"main\"]/div/div[4]/div[1]/div/div[1]/ul/li[1]/a")
    WebElement firstEvent;
    
    @FindBy(id = "title")
    WebElement inputTitulo;
    
    @FindBy(tagName = "textarea")
    WebElement textAreaDescricao;
    
    @FindBy(id = "start_date")
    WebElement inputInicio;
    
    @FindBy(id = "end_date")
    WebElement inputFim;
    
    @FindBy(name = "venue_name_full")
    WebElement inputLocal;
    
    @FindBy(xpath = "/html/body/div[7]/form/div/div/div[3]/input")
    WebElement createEvent;
    
    @FindBy(xpath = "/html/body/div[1]")
    WebElement dialogBox;
    
    @FindBy(xpath = "/html/body/div[2]/form/div/div/div[2]/div/div/div[2]/div[2]/div[6]")
    WebElement divDesc;
    
    @FindBy(name = "q")
    WebElement inputSearch;
    
    @FindBy(className = "ico-search")
    WebElement buttonSearch;
    
    @FindBy(tagName = "h5")
    WebElement nothingFound;

    
    public EventsPage clicarEmCreateEvent(){
        buttonCreateEvent.click();
        
        return this;
    }
    
    public EventPage clicarNoPrimeiroEvento(){
        firstEvent.click();
        
        return new EventPage(driver);
    }
    
    public EventsPage preencherCamposCom(String titulo, String descricao, String inicio, String fim, String local){
        inputTitulo.sendKeys(titulo);
        divDesc.click();
        sleep(1000);
        JavascriptExecutor ex = (JavascriptExecutor) driver;
        //not working
        ex.executeScript("document.getElementsByClassName(\"CodeMirror-code\")[0].innerHTML = '<pre class=\"CodeMirror-line\">"+descricao+"</pre>'");
        createEvent.click();
        sleep(2000);
        
        inputInicio.sendKeys(inicio);
        inputFim.sendKeys(fim);
        inputLocal.sendKeys(local);
        
        return this;
    }
    
    public EventsPage criarEvento(){
        createEvent.click();
        
        return this;
    }
    
    public EventsPage preencherCampoDeBuscaCom(String busca){
        inputSearch.clear();
        inputSearch.sendKeys(busca);
        
        return this;
    }
    
    public EventsPage clicarNaLupa(){
        buttonSearch.click();
        sleep(2000);
        
        return this;
    }
    
    public boolean criouEvento(){
        return dialogBox.isDisplayed();
    }
    
    public boolean achouAlgo(){
        return firstEvent.isDisplayed();
    }
    
    public boolean naoAchouNada(){
        return nothingFound.isDisplayed();
    }
}
