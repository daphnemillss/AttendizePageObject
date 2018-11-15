/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.attendizepageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author daphnemillss
 */
public class OrganiserMenu {
    @FindBy(xpath = "//*[@id=\"nav\"]/li[1]/a")
    WebElement dashboard;
    
    @FindBy(xpath = "//*[@id=\"nav\"]/li[2]/a")
    WebElement event;
    
    @FindBy(xpath = "//*[@id=\"nav\"]/li[3]/a")
    WebElement customize;
    
    public void irParaDashboard(){
        dashboard.click();
    }
    
    public void irParaEvent(){
        event.click();
    }
    
    public void irParaCustomize(){
        customize.click();
    }
}
