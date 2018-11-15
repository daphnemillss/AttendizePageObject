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
public class DropdownMenu{
    @FindBy(xpath = "//*[@id=\"header\"]/div[2]/ul[2]/li/a")
    WebElement buttonMenu;
    
    @FindBy(xpath = "//*[@id=\"header\"]/div[2]/ul[2]/li/ul/li[10]/a")
    WebElement signOut;
    
    public void abrirMenu(){
        buttonMenu.click();
    }
    
    public void sair(){
        signOut.click();
    }
}
