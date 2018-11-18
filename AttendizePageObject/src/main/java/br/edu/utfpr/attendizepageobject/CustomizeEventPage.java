/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.attendizepageobject;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
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
    
    @FindBy(xpath = "//*[@id=\"main\"]/div/div[3]/div/ul/li[2]/a")
    WebElement eventDesignTab;
    
    @FindBy(xpath = "//*[@id=\"bgImage\"]/div/img")
    List<WebElement> imgs;
    
    @FindBy(xpath = "//*[@id=\"design\"]/div/div[1]/form/div[2]/input")
    WebElement buttonSubmit;
    
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
    
    public CustomizeEventPage abrirAbaEventDesign(){
        eventDesignTab.click();
        
        return this;
    }
    
    public CustomizeEventPage escolherImgAleatoria(){
        int i = getRandomNumberInRange(0, 38); //pois existem 39 opcoes de escolha
        
        imgs.get(i).click();
        
        sleep(2000);
        
        return this;
    }

    public CustomizeEventPage salvarImgEscolhida(){
        buttonSubmit.click();
        sleep(2000);
        
        return this;
    }
    
    public boolean mudouImgDoEvento(){
        return msgSucesso.isDisplayed() && msgSucesso.getText().equals("Event Page Successfully Updated.");
    }
    
    private static int getRandomNumberInRange(int min, int max) {

		if (min >= max) {
			throw new IllegalArgumentException("max must be greater than min");
		}

		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
	}
}
