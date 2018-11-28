/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.attendizepageobject;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 *
 * @author daphnemillss
 */
public class BasePage {
    protected WebDriver driver;
    
    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    public String getCurrentURL(){
        return driver.getCurrentUrl();
    }
    
    public String getCurrentTitle(){
        return driver.getTitle();
    }
    
    public void sleep(long milis){
        try {
            Thread.sleep(milis);
        } catch (InterruptedException ex) {
            Logger.getLogger(BasePage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
